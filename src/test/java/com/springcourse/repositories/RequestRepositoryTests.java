package com.springcourse.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.enums.RequestState;
import com.springcourse.domains.Request;
import com.springcourse.domains.User;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@SpringBootTest
public class RequestRepositoryTests {

	@Autowired
	private RequestRepository requestRepository;
	
	@Test
	public void AsaveTest() {
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request(null, "Novo Laptop HP", "Pretendo obter um laptop HP", new Date(), RequestState.OPEN, owner, null);
		
		Request createdRequest = requestRepository.save(request);
		
		assertThat(createdRequest.getId()).isEqualTo(1L);
	}
	
	@Test	
	public void updateTest() {
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request(1L, "Novo Laptop HP", "Pretendo obter um laptop HP, de RAM 16GB", null, RequestState.OPEN, owner, null);
		
		Request updateRequest = requestRepository.save(request);
		
		assertThat(updateRequest.getDescription()).isEqualTo("Pretendo obter um laptop HP, de RAM 16GB");		
	}
	
	@Test	
	public void getByIdTest() {
		Optional<Request> result = requestRepository.findById(1L);
		
		Request request = result.get();
		
		assertThat(request.getSubject()).isEqualTo("Novo Laptop HP");
	}
	
	@Test	
	public void listTest() {
		List<Request> result = requestRepository.findAll();
		assertThat(result.size()).isEqualTo(1);
	}
	
	@Test	
	public void listByOwnerIdTest() {
		List<Request> result = requestRepository.findAllByOwnerId(1L);
		assertThat(result.size()).isEqualTo(1);
	}	
	
	@Test
	public void updateStatusTest() {
		int affectedRows = requestRepository.updateStatus(1L, RequestState.IN_PROGRESS);
		assertThat(affectedRows).isEqualTo(1);
	}
}
