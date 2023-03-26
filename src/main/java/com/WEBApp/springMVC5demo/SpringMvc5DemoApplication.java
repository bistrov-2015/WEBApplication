package com.WEBApp.springMVC5demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class SpringMvc5DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvc5DemoApplication.class, args);
	}

}
