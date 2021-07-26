package com.razzies.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.razzies.controller.ProducerController;
import com.razzies.dto.Interval;
import com.razzies.projection.ProducerProjection;
import com.razzies.service.ProducerService;

@SpringBootTest
class ProducerTests {

	@Autowired
	ProducerService producerService;

	@Autowired
	private ProducerController controller;
	
	@Test
	void checkMinMaxIntervalAwardByProducer() {
		Interval intervals = producerService.getMinMaxIntervalAwardByProducer();
		assertThat(intervals).isNotNull();
		assertThat(intervals.getMax()).isNotEmpty();
		assertThat(intervals.getMin()).isNotEmpty();
		assertThat(intervals.getMax()).isNotNull();
		assertThat(intervals.getMin()).isNotNull();
		assertThat(intervals.getMax().size() > 0);
		assertThat(intervals.getMin().size() > 0);
		
	}
	
	@Test
	void checkProducerWinnerInsertedInDatabaseByFileCSV() {
		List<ProducerProjection> producerProjections = producerService.getProducerWinner();
		assertThat(producerProjections).isNotNull();
		assertThat(producerProjections).isNotEmpty();
		assertThat(producerProjections.size() > 0);
	}

	@Test
	public void checkInjectionProducerController() {
		assertThat(controller).isNotNull();
	}

}
