package com.javainuse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	/**
	 * test first endPoint
	 * @return
	 */
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

}
