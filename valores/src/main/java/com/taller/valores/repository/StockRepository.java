package com.taller.valores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

	Stock findByName(String name);
}
