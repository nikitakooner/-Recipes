package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.recipes.service.RecipesService;


@SpringBootApplication
public class RecipesApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(RecipesApplication.class, args);
		
	}

}