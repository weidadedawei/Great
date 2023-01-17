package com.yunlong.frame.security.service;

import cn.hutool.core.util.ArrayUtil;
import com.yunlong.frame.core.constant.CommonConstants;
import com.yunlong.frame.core.constant.SecurityConstants;
import com.yunlong.frame.core.util.R;
import com.yunlong.frame.core.util.RetOps;
import com.yunlong.frame.security.pojo.PigxUser;
import com.yunlong.system.api.dto.UserInfo;
import com.yunlong.system.api.entity.SysUser;
import org.springframework.core.Ordered;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义 UserDetailsService 接口类
 * @author david
 * @date 2023/1/16
 */
public interface YunLongUserDetailsService extends UserDetailsService, Ordered {

	/**
	 * 是否支持此客户端校验
	 * @param clientId 请求客户端
	 * @param grantType 授权类型
	 * @return true/false
	 */
	default boolean support(String clientId, String grantType) {
		return true;
	}

	/**
	 * 排序值 默认取最大的
	 * @return 排序值
	 */
	default int getOrder() {
		return 0;
	}

	/**
	 * 构建userdetails
	 * @param result 用户信息
	 * @return UserDetails
	 * @throws UsernameNotFoundException
	 */
	default UserDetails getUserDetails(R<UserInfo> result) {
		// @formatter:off
		return RetOps.of(result)
				.getData()
				.map(this::convertUserDetails)
				.orElseThrow(() -> new UsernameNotFoundException("用户名或密码错误"));
		// @formatter:on
	}

	/**
	 * UserInfo 转 UserDetails
	 * @param info
	 * @return 返回UserDetails对象
	 */
	default UserDetails convertUserDetails(UserInfo info) {
		Set<String> dbAuthsSet = new HashSet<>();
		if (ArrayUtil.isNotEmpty(info.getRoles())) {
			// 获取角色
			Arrays.stream(info.getRoles()).forEach(roleId -> dbAuthsSet.add(SecurityConstants.ROLE + roleId));
			// 获取资源
			dbAuthsSet.addAll(Arrays.asList(info.getPermissions()));

		}
		Collection<? extends GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(dbAuthsSet.toArray(new String[0]));
		SysUser user = info.getSysUser();
		// 构造security用户

		return new PigxUser(user.getUserId(), user.getUsername(), user.getDeptId(), user.getPhone(), user.getAvatar(),
				user.getNickname(), user.getName(), user.getEmail(), user.getTenantId(),
				SecurityConstants.BCRYPT + user.getPassword(), true, true, true,
				!CommonConstants.STATUS_LOCK.equals(user.getLockFlag()), authorities);
	}

	/**
	 * 通过用户实体查询
	 * @param pigxUser user
	 * @return
	 */
	default UserDetails loadUserByUser(PigxUser pigxUser) {
		return this.loadUserByUsername(pigxUser.getUsername());
	}

}
