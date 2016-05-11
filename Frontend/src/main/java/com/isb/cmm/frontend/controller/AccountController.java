package com.isb.cmm.frontend.controller;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isb.cmm.frontend.remote.account.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private MovementConverter converter;

	@RequestMapping(method = GET)
	public List<Long> getAccountList() {
		return accountService.getAccounts();
	}

	@RequestMapping(path = "/{account}", method = GET)
	public double getBalance(@PathVariable("account") String accountId) {
		return accountService.getBalance(accountId);
	}

	@RequestMapping(path = "/{account}/movements", method = GET)
	public List<Movement> getMovements(@PathVariable("account") String accountId,
			@RequestParam(defaultValue = "4") int count) {
		return accountService.getMovements(accountId, count).stream().map(converter).collect(toList());
	}
}
