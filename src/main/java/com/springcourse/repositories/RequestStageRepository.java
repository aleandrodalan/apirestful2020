package com.springcourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcourse.domains.RequestStage;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {

	List<RequestStage> findAllByRequestId(Long id);
}