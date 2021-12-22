package com.eci.training.restclient;

import org.springframework.web.client.RestTemplate;

import com.eci.training.domain.Product;

public class ResClient {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		Product fromServer = template.getForObject("http://localhost:8080/products/2", Product.class);
		System.out.println(fromServer.getName()+" : "+fromServer.getPrice());
	}

}
