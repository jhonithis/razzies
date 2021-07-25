package com.razzies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razzies.dto.Interval;
import com.razzies.service.ProducerService;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {

	@Autowired
	ProducerService service;

	@GetMapping("/min-max-interval-award")
	public ResponseEntity<List<Interval>> getMinMaxIntervalAward() {
		return new ResponseEntity<>(service.getMinMaxIntervalAwardByProducer(), HttpStatus.OK);
	}
	
}
