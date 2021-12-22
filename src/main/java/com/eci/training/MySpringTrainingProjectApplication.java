package com.eci.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.eci.training.domain.Review;
import com.eci.training.ui.ProductConsoleUI;
import com.eci.training.ui.ReviewUI;

@SpringBootApplication
public class MySpringTrainingProjectApplication {

	 public static void main(String[] args) {
		 
		 SpringApplication.run(MySpringTrainingProjectApplication.class, args);
		 
			/*
			 * ApplicationContext springContainer =
			 * SpringApplication.run(MySpringTrainingProjectApplication.class, args); //
			 * ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class); //
			 * ui.createProductWithUI();
			 * 
			 * ReviewUI ui = springContainer.getBean(ReviewUI.class);
			 * 
			 * // Review sample = new Review("pradeep", "good", 5); //ui.addReview(sample);
			 * 
			 * ui.addReview();
			 * 
			 * System.exit(0);
			 */
	        
	    }

}
