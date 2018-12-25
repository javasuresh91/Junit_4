package com.mockito.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mockito.service.TodoService;

public class TodoBusinessImpl {
	
	TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodoRelatedToSpring(String user)
	{
		List<String> filterTodos = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);
		
		filterTodos = todos.stream().filter(todo->todo.contains("Spring")).collect(Collectors.toList());
		
		return filterTodos;
	}
	
	public void deleteTodoNotRelatedToSpring(String user)
	{
		List<String> todos = todoService.retrieveTodos(user);
//		todos.stream().filter(todo->!todo.contains("Spring")).forEach(todoService::deleteTodo);
		for(String a: todos)
		{
			if(!a.contains("Spring"))
			{
				todoService.deleteTodo(a);
			}
		}
		
	}
	
	

}
