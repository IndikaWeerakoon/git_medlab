package com.fullbright.medlab.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullbright.medlab.entities.CustomerVisit;

@Repository
public interface CustomerVisitRepository extends CrudRepository<CustomerVisit, Long> {

}
