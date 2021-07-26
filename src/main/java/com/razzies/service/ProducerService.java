package com.razzies.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.iterators.PeekingIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razzies.dto.Award;
import com.razzies.dto.Interval;
import com.razzies.projection.ProducerProjection;
import com.razzies.repository.ProducerRepository;

@Service
public class ProducerService {
	
	@Autowired
	ProducerRepository producerRepository;
	
	public Interval getMinMaxIntervalAwardByProducer() {
		
		List<ProducerProjection> producersWinner = this.producerRepository.getProducerWinner();
		
		Map<String, List<ProducerProjection>> groupByProducer = producersWinner.stream().
				collect(
					Collectors.groupingBy(
						ProducerProjection::getName
					)
				);
		
		List<Award> awards = processIntervalsAwardByGroupProducer(groupByProducer);
		
		return getAllMinMaxIntervalByAwardsInterval(awards);
		
	}
	
	public Interval getAllMinMaxIntervalByAwardsInterval(List<Award> awards) {
		Interval interval = new Interval();
		if(!awards.isEmpty()) {
			int minInterval = awards.stream().
				min(Comparator.comparing(Award::getInterval)).get().getInterval();
			
			int maxInterval = awards.stream().
				max(Comparator.comparing(Award::getInterval)).get().getInterval();
			
			interval.setMin(
				awards.stream().
					filter(award -> award.getInterval() == minInterval).
					collect(Collectors.toList())
			);
			
			interval.setMax(
				awards.stream().
					filter(award -> award.getInterval() == maxInterval).
					collect(Collectors.toList())
			);
		}
		return interval;
	}
	
	public List<ProducerProjection> getProducerWinner(){
		return this.producerRepository.getProducerWinner();
	}
	
	private List<Award> processIntervalsAwardByGroupProducer(Map<String, List<ProducerProjection>> groupByProducer) {
		List<Award> awardsWithInterval = new ArrayList<>();
		
		groupByProducer.entrySet().stream().
			forEach(
				groupProducer -> {
					PeekingIterator<ProducerProjection> iterator = PeekingIterator.peekingIterator(groupProducer.getValue().listIterator());
					while(iterator.hasNext()){
						ProducerProjection current = iterator.next();	
						ProducerProjection next = iterator.peek();	
						if(next != null) {
							Award awardProducer = new Award(
								groupProducer.getKey(), 
								next.getYear() - current.getYear(), 
								current.getYear(), 
								next.getYear()
							);
							awardsWithInterval.add(awardProducer);
						}
					}
				}
			);
		
		return awardsWithInterval;
	}
	
}
