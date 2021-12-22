package com.eci.training.service;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.eci.training.domain.Product;
import com.eci.training.service.ProductService;
import com.eci.training.web.ProductController;

@RunWith(SpringRunner.class)
@WebMvcTest(value= {ProductController.class})
/*
 * here we are specifying which controller need to be initiate at the junit
 * test it will only start current controller rest will be as it is.
 * 
 * spring controller is up in limited 
 */
public class ProductControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ProductService service;
	
	@Test
	public void test_GET_Product_Item_Must_Return_Success() throws Exception {
		//Arraange
		int id = 1;
		Product dataReturned = new Product("test", 9999, 1000);
		dataReturned.setId(id);
		Mockito.when(service.findById(id)).thenReturn(dataReturned);
		//Act and Assert
		mockMvc.perform(get("/products/{id}", id).accept(MediaType.APPLICATION_JSON))
		/* if you try to access other api here you will get 404 error
		 * because we are define productcontroller class only
		 */
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(id)));
		
	}

}
