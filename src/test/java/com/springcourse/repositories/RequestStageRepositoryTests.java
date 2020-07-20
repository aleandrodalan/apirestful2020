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
import com.springcourse.domains.RequestStage;
import com.springcourse.domains.User;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@SpringBootTest
public class RequestStageRepositoryTests {

	@Autowired
	private RequestStageRepository requestStageRepository;
	
	@Test
	public void AsaveTest() {
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request();
		request.setId(1L);
		
		RequestStage stage = new RequestStage(null, "Foi comprado um laptop de marca HP com 16 GB de RAM", new Date(), RequestState.CLOSED, request, owner);
		
		RequestStage createdStage = requestStageRepository.save(stage);
		
		assertThat(createdStage.getId()).isEqualTo(1L);
	}
	
	@Test	
	public void getByIdTest() {
		Optional<RequestStage> result = requestStageRepository.findById(1L);
		RequestStage stage = result.get();
		
		assertThat(stage.getDescription()).isEqualTo("Foi comprado um laptop de marca HP com 16 GB de RAM");
	}
	
	@Test	
	public void listByRequestIdTest() {
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(1L);
		assertThat(stages.size()).isEqualTo(1);
	}
}
