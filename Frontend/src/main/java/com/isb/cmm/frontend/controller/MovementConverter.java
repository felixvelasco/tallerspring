package com.isb.cmm.frontend.controller;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.isb.cmm.frontend.remote.account.AccountMovement;

@Component
public class MovementConverter implements Function<AccountMovement,Movement> {

	@Override
	public Movement apply(AccountMovement original) {
		Movement result = new Movement();
		result.setConcepto(original.getConcept());
		result.setFecha(original.getDate());
		result.setValor(original.getAmount());
		
		return result;
	}

}
