package com.yunlong.system.api.feign;

import com.yunlong.frame.core.constant.SecurityConstants;
import com.yunlong.frame.core.constant.ServiceNameConstants;
import com.yunlong.frame.core.util.R;
import com.yunlong.system.api.entity.SysOauthClientDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * @author david
 * @date 2023/1/17
 */
@FeignClient(contextId = "remoteClientDetailsService", value = ServiceNameConstants.SYSTEM_SERVICE)
public interface RemoteClientDetailsService {

	/**
	 * 通过clientId 查询客户端信息
	 * @param clientId 用户名
	 * @param from 调用标志
	 * @return R
	 */
	@GetMapping("/sysOauthClientDetails/getClientDetailsById/{clientId}")
	R<SysOauthClientDetails> getClientDetailsById(@PathVariable("clientId") String clientId,
												  @RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 查询全部客户端
	 * @param from 调用标识
	 * @return R
	 */
	@GetMapping("/sysOauthClientDetails/list")
	R<List<SysOauthClientDetails>> listClientDetails(@RequestHeader(SecurityConstants.FROM) String from);

}
