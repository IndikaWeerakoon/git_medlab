package com.fullbright.medlab.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fullbright.medlab.entities.Test;
import com.fullbright.medlab.entities.TestProfile;

@Repository
public interface TestProfileRepository extends CrudRepository<TestProfile, Long>{
	
	@Query(value = "SELECT t.test_id, t.name, t.hours, t.unit, t.range, t.specimen_type, t.price FROM test as t, test_profile_detail as tpd WHERE tpd.test_profile_id = (:testProfileId) AND t.test_id = tpd.test_test_id", nativeQuery = true)
	ArrayList<Object[]> getTestByProfile(@Param("testProfileId") long testProfileId);
}
