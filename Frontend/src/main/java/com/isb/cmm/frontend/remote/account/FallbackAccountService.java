package com.isb.cmm.frontend.remote.account;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FallbackAccountService implements AccountService {

	private static final String ACCOUNT2 = "1638742746";
	private static final String ACCOUNT1 = "3543548621";
	private static final String[] CONCEPTOS = new String[] { "Actividades extraescolares", "Colegio niños", "Nómina",
			"Recibo tarjeta", "Seguro hogar", "Seguro vida", "Restaurante La Comida", "Amazon.es", "PCComponentes",
			"La tienda en casa", "Gas Artificial", "Recibo de la luz", "Recibo de la oscuridad", "Hipoteca",
			"Rendimientos cuenta", "Carrefive", "Vacunas", "Seguro Médico", "Gaztelubide", "Zapatos La Begoña",
			"Compra de Extintores", "Obras La Reforma s.l.", "Puenting", "Viajes Atahualpa", "Cables y Latiguillos" };


	@Override
	public double getBalance(String id) {
		return 0;
	}

	@Override
	public List<Long> getAllByUser(Long userId) {
		return asList(Long.valueOf(ACCOUNT2), Long.valueOf(ACCOUNT1));
	}

	@Override
	public List<Long> getAccounts() {
		return asList(Long.valueOf(ACCOUNT2), Long.valueOf(ACCOUNT1));
	}

	@Override
	public List<AccountMovement> getMovements(String id) {
		return emptyList();
	}

	@Override
	public List<AccountMovement> getMovements(String id, long size) {
		List<AccountMovement> result = new ArrayList<>();
		Random r = new Random();
		Date fecha = new Date();
		for (int i = 0; i < size; i++) {
			AccountMovement apunte = new AccountMovement();
			apunte.setConcept(CONCEPTOS[r.nextInt(CONCEPTOS.length)]);
			if (r.nextBoolean()) {
				fecha = new Date(fecha.getTime() - (1000 * 60 * 60 * 24));
			}
			apunte.setDate(fecha);
			apunte.setAmount(((double) r.nextInt(50000)) / 100.0);

			result.add(0, apunte);
		}

		return result;	
	}

}
