package com.kang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSocketApplication {

	public static void main(String[] args) {
		System.out.println("hello hello"); 
		System.out.println("hello test"); 
		SpringApplication.run(WebSocketApplication.class, args);
	}
}
