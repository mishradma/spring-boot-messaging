package com.mycompany.messaging.web.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.messaging.domain.Sales;
import com.mycompany.messaging.repositories.SalesRepository;

@RunWith(MockitoJUnitRunner.class)
public class SalesControllerTest {
	private MockMvc mockMvc;

	@Mock
	private SalesRepository repository;

	@InjectMocks
	private SalesController userController;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testSubmit() throws JsonProcessingException, Exception {
		List<Sales> sales = Arrays.asList(new Sales());
		ObjectMapper mapper = new ObjectMapper();
		Mockito.when(repository.save(sales)).thenReturn(sales);
		String content = mapper.writeValueAsString(sales);
		RequestBuilder builder = MockMvcRequestBuilders.post("/sales/post").contentType(MediaType.APPLICATION_JSON)
				.content(content);

		mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(repository, Mockito.times(0)).save(sales);
		Mockito.verifyNoMoreInteractions(repository);
	}

}
