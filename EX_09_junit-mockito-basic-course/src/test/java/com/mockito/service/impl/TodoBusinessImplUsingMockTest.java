package com.mockito.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mockito.service.TodoService;

/**
 * 1. Mock - Creating the Object that simulate the behaviour of the real object
 * 2. Mock will dynamically create from the code at runtime
 * 3. Mock comes with more functionality than stubbing 
 *
 */
public class TodoBusinessImplUsingMockTest {

	@Test
	public void testOne() {
		TodoService todoServiceMock = mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		assertEquals(0, todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy").size());
	}

	@Test
	public void testTwo() {
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC", "Learn Spring MVC");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		assertEquals(1, todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy").size());
	}
	
	//Here we have did two tests without any code level implementation like stub classes
	
}
