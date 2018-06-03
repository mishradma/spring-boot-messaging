package com.mycompany.messaging.web.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Lookup;

import com.mycompany.messaging.web.dto.Status;
import com.mycompany.messaging.web.dto.WebResponse;

public class AbstractController {
	@Lookup
	protected <T extends Serializable> WebResponse<T> createResponse() {
		WebResponse<T> obj = new WebResponse<>();
		obj.setStatus(new Status());
		return obj;
	};
}
