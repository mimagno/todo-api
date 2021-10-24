package com.programar.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programar.todo.domain.Todo;
import com.programar.todo.repository.TodoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Todo findById(Integer id) throws ObjectNotFoundException {	
		Optional<Todo> obj = todoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Todo.class.getName()));
	}
	
	public List<Todo> findAllOpened(){
		List<Todo> list = todoRepository.findAllOpened();
		
		return list;
	}

	public List<Todo> findAllClosed() {
	List<Todo> list = todoRepository.findAllClosed();	
		return list;
	}
	
	public List<Todo> findAll(){
		List<Todo> list = todoRepository.findAll();
		return list;
	}
	
	public Todo createTodo(Todo obj) {
		obj.setId(null);
		return todoRepository.save(obj);	
	}

	public String deleteById(Integer id) {
		todoRepository.deleteById(id);
		
		return "Delete Sucess";
	}
	
	public Todo updateById(Integer id, Todo obj) throws ObjectNotFoundException {
		Todo newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		
		return todoRepository.save(newObj);
		
	}
}
