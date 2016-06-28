package com.satish.SpringBootBasics.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satish.SpringBootBasics.util.Util;

@RestController
public class TestBootService {

	@Autowired
	Adapter adapter;
	
	@RequestMapping("/")
    String testBootService() {
		String outputAdapter = adapter.getAdapter("input");
		System.out.println("Instance:::::"+outputAdapter);
		String output = Util.testStatic();
		System.out.println("Static:::::"+output);
        return "testBootService";
    }
}
