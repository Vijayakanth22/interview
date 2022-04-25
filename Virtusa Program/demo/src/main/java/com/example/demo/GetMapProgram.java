package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
public class GetMapProgram {

	@Autowired
	RestTemplate restTemplate;

	ResultHelper[] helpers = new ResultHelper[3];

	@GetMapping("/retrieveMails")
	private ResponseEntity<String> getAllMailIds() throws JsonMappingException, JsonProcessingException {

		System.out.println("inside method");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Accept", "*/*");
		headers.set("User-Agent", "Mozilla/5.0");
		headers.set("Cache-Control", "no-cache");
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String result = "";

		String res1 = restTemplate.exchange("https://reqres.in/api/users/1", HttpMethod.GET, entity, String.class)
				.getBody();
		String res2 = restTemplate.exchange("https://reqres.in/api/users/3", HttpMethod.GET, entity, String.class)
				.getBody();
		String res3 = restTemplate.exchange("https://reqres.in/api/users/10", HttpMethod.GET, entity, String.class)
				.getBody();

		ObjectMapper mapper = new ObjectMapper();

		helpers[0] = mapper.readValue(res1, ResultHelper.class);
		helpers[1] = mapper.readValue(res2, ResultHelper.class);
		helpers[2] = mapper.readValue(res3, ResultHelper.class);

		for (int i = 0; i < helpers.length; i++) {
			result += helpers[i].getData().getEmail() + "\n";
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
