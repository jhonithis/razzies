package com.razzies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razzies.dto.Interval;
import com.razzies.projection.ProducerProjection;
import com.razzies.repository.ProducerRepository;

@Service
public class ProducerService {
	
	@Autowired
	ProducerRepository producerRepository;
	
	public List<Interval> getMinMaxIntervalAwardByProducer() {
		List<Interval> intervals = new ArrayList<Interval>();
		List<ProducerProjection> projections = this.producerRepository.getProducerWinner();

		projections.forEach(pro -> System.out.println(pro.getName() + " - " + pro.getYear()));
		
		//Implementar logica para setar em interval
		
		return intervals;
	}
	
}
