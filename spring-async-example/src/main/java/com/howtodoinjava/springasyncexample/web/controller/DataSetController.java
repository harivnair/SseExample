package com.howtodoinjava.springasyncexample.web.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DataSetController {

	private SseEmitter emitter;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Integer getUser() throws IOException {


		// Send message to "connected" web page:

		if (emitter != null) {
			emitter.send(1);
		}

		// This return value goes back as a response to your android device
		// i.e. the caller of the getUser rest service.
		return 0;
	}

	@RequestMapping(value = "/sse")
	public SseEmitter getSseEmitter() {
		emitter = new SseEmitter();
		return emitter;
	}
}
