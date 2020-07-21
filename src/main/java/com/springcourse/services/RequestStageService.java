package com.springcourse.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.enums.RequestState;
import com.springcourse.domains.RequestStage;
import com.springcourse.repositories.RequestRepository;
import com.springcourse.repositories.RequestStageRepository;

@Service
public class RequestStageService {

	@Autowired
	private RequestStageRepository requestStageRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	public RequestStage save(RequestStage stage) {
		stage.setRealizationDate(new Date());
		
		RequestStage createdStage = requestStageRepository.save(stage);
		
		requestRepository.updateStatus(stage.getId(), RequestState.IN_PROGRESS);
		
		return createdStage;
	}
	
	public RequestStage getById(Long id) {
		return requestStageRepository.findById(id).get();
	}
	
	public List<RequestStage> ListAllByRequestId(Long id) {
		return requestStageRepository.findAllByRequestId(id);
	}
}
