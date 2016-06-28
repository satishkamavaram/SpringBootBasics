package com.satish.SpringBootBasics.rest.service;

import org.springframework.stereotype.Component;

@Component
public class AdapterImpl implements Adapter {

	@Override
	public String getAdapter(String input) {
		System.out.println("input::::::");
		return "TestInstance";
	}

}
