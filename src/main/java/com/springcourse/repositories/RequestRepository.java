package com.springcourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcourse.domain.enums.RequestState;
import com.springcourse.domains.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	List<Request> findAllByOwnerId(Long id);

	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE Request SET state = ?2 WHERE id = ?1")
	int updateStatus(Long id, RequestState state);
}