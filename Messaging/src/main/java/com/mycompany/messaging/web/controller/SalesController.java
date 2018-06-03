package com.mycompany.messaging.web.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mycompany.messaging.domain.Sales;
import com.mycompany.messaging.repositories.SalesRepository;
import com.mycompany.messaging.web.dto.WebResponse;

@RestController
@RequestMapping("sales")
public class SalesController extends AbstractController {
	// In interest of time Service layer not implemented. So directly using crud
	// repository
	@Autowired
	SalesRepository repository;

	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	@RequestMapping(value = "post", method = RequestMethod.POST, consumes = {
			/*
			 * MediaType.TEXT_XML_VALUE,
			 * MediaType.APPLICATION_XML_VALUE,
			 */ MediaType.APPLICATION_JSON_VALUE }, produces = { /*
																	 * MediaType.TEXT_XML_VALUE,
																	 * MediaType.APPLICATION_XML_VALUE,
																	 */ MediaType.APPLICATION_JSON_VALUE })
	public WebResponse<String> submit(@RequestBody @JsonDeserialize(contentAs = Sales.class) final List<Sales> sale) {
		final WebResponse<String> response = createResponse();
		int visitNumber = 0;
		if (!CollectionUtils.isEmpty(sale)) {
			visitNumber = SalesController.atomicInteger.incrementAndGet();
			if (visitNumber % 10 == 0) {
				response.getStatus().setReason("Sales data posted successfully for post " + visitNumber);
			} else if (visitNumber < 50) {
				response.getStatus().setReason("Sales data posted successfully for post less then 50 " + visitNumber);
			} else {
				response.getStatus().setSuccess(Boolean.FALSE);
				response.getStatus().setReason("Paused");
			}
		}

		return response;
	}

}
