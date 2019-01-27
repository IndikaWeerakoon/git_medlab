package com.fullbright.medlab.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fullbright.medlab.entities.Customer;
import com.fullbright.medlab.entities.User;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	@Query(value  = "SELECT * FROM customer c WHERE c.telephone_no = (:telephone)", nativeQuery = true)
	Customer findCustomerByTelephone(@Param("telephone") String telephone);
}
