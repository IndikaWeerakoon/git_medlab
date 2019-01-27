package com.fullbright.medlab.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullbright.medlab.entities.CollectionCenter;

@Repository
public interface LocationRespository extends CrudRepository<CollectionCenter, Long>{
	
}
