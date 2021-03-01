package com.billr.tradesysv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication
@EnableJdbcHttpSession
public class Tradesysv1Application {

	public static void main(String[] args) {		
		SpringApplication.run(Tradesysv1Application.class, args);
	}

}
