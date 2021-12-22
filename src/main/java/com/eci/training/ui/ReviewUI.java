package com.eci.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eci.training.dal.ReviewRepository;
import com.eci.training.domain.Product;
import com.eci.training.domain.Review;

@Component
public class ReviewUI {

	
	@Autowired
	ReviewRepository reviewDAO;
	
	
	/*
	 * public void addReview(Review r) { System.out.println("[[[[[[[[[[[[[[[[[[[" +
	 * reviewDAO.getClass().getName() + "]]]]]]]]]]]]]]]]]]"); reviewDAO.save(r); }
	 */
	public void addReview() {
			Review toBeSaved = new Review();
		 	Scanner kb = new Scanner(System.in);
	        System.out.println("Enter a name: ");
	        toBeSaved.setReviewerName(kb.nextLine());
	        //String name = kb.nextLine();
	        System.out.println("Enter price: ");
	        toBeSaved.setReviewText(kb.nextLine());
	        //String text = kb.nextLine();
	        //float price = Float.parseFloat(kb.nextLine());
	        System.out.println("Enter rating: ");
	        toBeSaved.setRating(Integer.parseInt(kb.nextLine()));
	        //int rating = Integer.parseInt(kb.nextLine());
	        
	        
	       // Review toBeSaved = new Review(name, text, rating);
	        reviewDAO.save(toBeSaved);
	        System.out.println("Created Product with Id: "+toBeSaved.getId());
	}
}
