package com.WEBApp.springMVC5demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class SpringMvc5DemoApplication {
	private static final String URL = "jdbc:postgresql://localhost:5432/Dictionary";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "[eqeuflftimgfhjkm";
	private static Connection connection;
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringMvc5DemoApplication.class, args);
	}

}
