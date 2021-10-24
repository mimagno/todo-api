package com.programar.todo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.programar.todo.services.DBService;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instacia() throws ParseException {
		this.dbService.instanciaBaseDeDados();
		return true;
	}

}
