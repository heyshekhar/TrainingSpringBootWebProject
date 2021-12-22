package com.eci.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eci.training.dal.InMemoryProductDAO;
import com.eci.training.dal.ProductDAO;
import com.eci.training.service.ProductService;
import com.eci.training.service.ProductServiceImpl;
import com.eci.training.ui.ProductConsoleUI;

//@Configuration
public class ProductAppConfiguration {
    
	/*
	 * @Bean public ProductDAO daoObj() { InMemoryProductDAO dao = new
	 * InMemoryProductDAO(); return dao; }
	 * 
	 * @Bean public ProductService serviceObj() { ProductServiceImpl service = new
	 * ProductServiceImpl(); service.setDao(daoObj()); return service; }
	 * 
	 * @Bean public ProductConsoleUI uiObj() { ProductConsoleUI ui = new
	 * ProductConsoleUI(); ui.setService(serviceObj()); return ui; }
	 */

}

