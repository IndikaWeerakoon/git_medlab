package com.fullbright.medlab.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fullbright.medlab.entities.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

	@Query(value = "SELECT report_id FROM report WHERE specimen_id = (:specimenId)", nativeQuery = true)
	long getReportIdBySpecimenId(@Param("specimenId") String specimenId);
}
