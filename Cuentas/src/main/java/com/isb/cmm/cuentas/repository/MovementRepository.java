package com.isb.cmm.cuentas.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {
	
	List<Movement> findByAccountId(Long accountId, Pageable pageable);

	List<Movement> findByAccountUserId(Long userId);

}
