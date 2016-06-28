package com.satish.SpringBootBasics;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.satish.SpringBootBasics.rest.service.Adapter;



@Configuration
public class ConfigurationTest extends BootConfiguration {

	@Mock
	Adapter adapter;
	
	@Bean
    public Adapter adapterImpl()
	{ 
		return adapter;
	}
	
	ConfigurationTest() {
		MockitoAnnotations.initMocks(this);
	}
	
}
