package com.satish.SpringBootBasics;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.satish.SpringBootBasics.rest.service.Adapter;
import com.satish.SpringBootBasics.util.Util;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConfigurationTest.class)
@WebAppConfiguration
@PrepareForTest(Util.class)
public class TestBootServiceTest 
   
{
	private MockMvc mvc;

	@Autowired
	Adapter adapter;
	
	@Autowired
	WebApplicationContext wac;
	
	@Before
	public void setUp() throws Exception {
		PowerMockito.mockStatic(Util.class);
		mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void test() throws Exception {
		PowerMockito.when(Util.testStatic()).thenReturn("mockedStatic");
		Mockito.when(adapter.getAdapter((String)Mockito.anyString())).thenReturn("mockedInstance");
		mvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("testBootService")));
	}
	
	@Test
	public void test1() throws Exception {
		PowerMockito.when(Util.testStatic()).thenReturn("mockedStatic1");
		Mockito.when(adapter.getAdapter((String)Mockito.anyString())).thenReturn("mockedInstance1");
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("testBootService")));
	}
}
