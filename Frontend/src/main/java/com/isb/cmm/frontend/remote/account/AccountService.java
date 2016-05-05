package com.isb.cmm.frontend.remote.account;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cuentas", fallback=FallbackAccountService.class)
public interface AccountService {

	@RequestMapping(method = RequestMethod.GET, path = "/account/{id}/balance")
	double getBalance(@PathVariable("id") String id);

	@RequestMapping(method = RequestMethod.GET, path = "/account/{id}")
	List<Long> getAllByUser(@PathVariable("id") Long userId);

	@RequestMapping(method = RequestMethod.GET, path = "/account")
	List<Long> getAccounts();

	@RequestMapping(method = RequestMethod.GET, path = "/account/{id}/movements")
	List<AccountMovement> getMovements(@PathVariable("id") String id);

	@RequestMapping(method = RequestMethod.GET, path = "/account/{id}/movements")
	List<AccountMovement> getMovements(@PathVariable("id") String id, @RequestParam("size") long size);

}
