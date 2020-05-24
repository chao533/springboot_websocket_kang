package com.kang;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSocketApplication {

	public static void main(String[] args) {
		System.err.println("hello test"); 
		System.err.println("hello hello");
		SpringApplication.run(WebSocketApplication.class, args);
	}
}
