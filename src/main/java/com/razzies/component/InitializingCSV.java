package com.razzies.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.razzies.service.HandleCSVService;

import lombok.extern.java.Log;

@Component
@Log
public class InitializingCSV {

	@Autowired
	private HandleCSVService handleCSVService;
	
	@PostConstruct
	public void init() {
		log.info("#### Begin InitializingCSV ###");
		this.handleCSVService.init();
		log.info("#### End InitializingCSV ###");

	}
}
