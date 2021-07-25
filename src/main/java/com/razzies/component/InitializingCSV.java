package com.razzies.component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.razzies.service.HandleCSVService;

@Component
public class InitializingCSV {

	@Autowired
	private HandleCSVService handleCSVService;
	private static final Logger log = LoggerFactory.getLogger(HandleCSVService.class);
	
	@PostConstruct
	public void init() {
		log.info("#### Begin InitializingCSV ###");
		this.handleCSVService.init();
		log.info("#### End InitializingCSV ###");
	}
}
