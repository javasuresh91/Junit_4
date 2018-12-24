package com.mockito.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mockito.service.TodoService;
import com.mockito.service.TodoServiceStub;

public class TodoBusinessImplTest {

	@Test
	public void test() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todo = new TodoBusinessImpl(todoServiceStub);
		
		List<String> retrieveTodoRelatedToSpring = todo.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(1, retrieveTodoRelatedToSpring.size());
	}
	
	// If we need to test the empty array list we need to change "TodoServiceStub" class
	// So it is the disadvantage of the Stubbing 

}
