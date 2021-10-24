package com.programar.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programar.todo.domain.Todo;
import com.programar.todo.repository.TodoRepository;

@Service
public class DBService {
	@Autowired()
	private TodoRepository todoRepository;

	public void instanciaBaseDeDados() throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Todo t1 = new Todo(1, "Estudar", "Estudar Spring Boot 2 e Angular 12",
				simpleDateFormat.parse("25/03/2022"), false);
		
		Todo t2 = new Todo(2, "Ler", "Clean code bundle",
				simpleDateFormat.parse("25/03/2022"), true);

		Todo t3 = new Todo(3, "Comer", "Cumprir a dieta",
				simpleDateFormat.parse("25/03/2022"), true);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3));
	}
}
