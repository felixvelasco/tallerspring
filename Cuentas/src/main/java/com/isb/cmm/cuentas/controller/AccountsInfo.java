package com.isb.cmm.cuentas.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isb.cmm.cuentas.repository.Account;
import com.isb.cmm.cuentas.repository.AccountRepository;
import com.isb.cmm.cuentas.repository.Movement;
import com.isb.cmm.cuentas.repository.MovementRepository;

@RestController
public class AccountsInfo {

	@Autowired
	private MovementRepository movementRepository;
	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/account/{id}/balance")
	public double getBalance(@PathVariable("id") Account account) {
		return account.getBalance();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/account/{id}")
	public Account getInfo(@PathVariable("id") Account account) {
		return account;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/account/{id}/movements")
	public List<Movement> getMovements(@PathVariable("id") Long accountId, Pageable pageable) {
		return movementRepository.findByAccountId(accountId, pageable);
	}

	@RequestMapping(method = RequestMethod.GET, path ="/account")
	public List<Long> getAllByUser(@RequestParam(defaultValue = "1", name= "id") Long userId){
		return accountRepository.findByUserId(userId).stream().map(acc -> acc.getid()).collect(toList());
	}
}
