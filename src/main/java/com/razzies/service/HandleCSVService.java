package com.razzies.service;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class HandleCSVService {

	public void init() {
		log.info("init " + HandleCSVService.class.getName());
	}

}
