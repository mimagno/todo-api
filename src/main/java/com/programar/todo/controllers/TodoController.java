package com.programar.todo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.programar.todo.domain.Todo;
import com.programar.todo.services.TodoService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService = new TodoService();

	@GetMapping("/test")
	private String test() {
		return "Hello World";
	}
	
	@GetMapping(value="/{id}")
	private ResponseEntity<Todo> finById(@PathVariable Integer id) throws ObjectNotFoundException {
		return ResponseEntity.ok().body(todoService.findById(id));
	}
	
	@GetMapping(value= "/opened")
	private ResponseEntity<List<Todo>> listOpen(){
		return ResponseEntity.ok().body(todoService.findAllOpened());
	}
	
	@GetMapping(value= "/closed")
	private ResponseEntity<List<Todo>> listClose(){
		return ResponseEntity.ok().body(todoService.findAllClosed());
	}
	
	@GetMapping()
	private ResponseEntity<List<Todo>> listAll(){
		return ResponseEntity.ok().body(todoService.findAll());
	}
	
	@PostMapping(value="/create")
	private ResponseEntity<Todo> createTodo(@RequestBody Todo obj){
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(todoService.createTodo(obj));
	}
	
	@DeleteMapping(value="/{id}")
	private ResponseEntity<String> deleteById(@PathVariable Integer id){
		todoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	private ResponseEntity<Todo> updateById(@PathVariable Integer id, @RequestBody Todo obj) throws ObjectNotFoundException{
		return ResponseEntity.ok().body(todoService.updateById(id, obj));
	}
	
	
}
