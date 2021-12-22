package com.eci.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.eci.training.domain.Product;

import com.eci.training.service.ProductService;

@RestController
public class ProductController {
	
	ProductService service;
	
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}
	
	// GET /products, 200 + Json data 
	
	@RequestMapping(method = RequestMethod.GET, value = "/products")
	public List<Product> getAllProducts(){
		return service.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id")int id) {
		Product product = service.findById(id);;
		if(product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}
		
	}
	
	 // POST /products + Json data , 201 + location header + Json data
		// 400 Bad Request
		@PostMapping("/products")
		public ResponseEntity addNewProduct(@RequestBody Product toBeAdded){
			
			try {
				int id = service.createNewProduct(toBeAdded);
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(URI.create("/products/"+id));
				return new ResponseEntity<Product>(toBeAdded, headers, HttpStatus.CREATED);
			} catch (IllegalArgumentException e) {
				ProductResponse response = new ProductResponse(e.getMessage());
				return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			}
		}

}
