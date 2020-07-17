package com.springcourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcourse.domain.enums.RequestState;
import com.springcourse.domains.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	List<Request> findAllByOwnerId(Long id);

	@Query("UPDATE Request SET state = ?2 WHERE id = ?1")
	Request updateStatus(Long id, RequestState state);
}