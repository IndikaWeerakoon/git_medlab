package com.fullbright.medlab.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullbright.medlab.entities.Receipt;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

	@Query(value = "SELECT receipt_id FROM receipt ORDER BY receipt_id ASC limit 1", nativeQuery = true)
	String getLastReceiptId();
}
