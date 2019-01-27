package com.fullbright.medlab.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullbright.medlab.entities.TestReportDetail;
import com.fullbright.medlab.entities.TestReportDetailId;

@Repository
public interface TestReportDetailRepository extends CrudRepository<TestReportDetail, TestReportDetailId> {

}
