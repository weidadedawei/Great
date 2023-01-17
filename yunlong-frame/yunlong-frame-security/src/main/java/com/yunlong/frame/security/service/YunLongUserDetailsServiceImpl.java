package com.yunlong.frame.security.service;

import com.yunlong.frame.core.constant.SecurityConstants;
import com.yunlong.frame.core.util.R;
import com.yunlong.system.api.dto.UserInfo;
import com.yunlong.system.api.feign.RemoteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义 UserDetailsService实现类
 *
 * @author david
 * @date 2023/1/16
 */
@Service
@RequiredArgsConstructor
public class YunLongUserDetailsServiceImpl implements YunLongUserDetailsService {

    //	private final BCryptPasswordEncoder passwordEncoder;
    private final RemoteUserService remoteUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //		Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
//		if (cache != null && cache.get(username) != null) {
//			return cache.get(username, PigxUser.class);
//		}

        R<UserInfo> result = remoteUserService.info(username, SecurityConstants.FROM_IN);
        UserDetails userDetails = getUserDetails(result);
//		cache.put(username, userDetails);
        return userDetails;

//		if(!"admin".equals(username)) {
//			throw new UsernameNotFoundException("用户名或密码错误！");
//		}

//        String password = new BCryptPasswordEncoder().encode("123456");
////		return new User("admin", "$2a$10$mGyvMFrVQTEsFztx/41hie9shqJaDOtdrOhEA8/HJgYHtXZmQjoqC", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//        return new User("admin", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
