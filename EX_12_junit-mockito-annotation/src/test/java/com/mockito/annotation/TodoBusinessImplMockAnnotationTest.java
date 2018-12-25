package com.mockito.annotation;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mockito.service.TodoService;
import com.mockito.service.impl.TodoBusinessImpl;


/**
 * 
 * @org.mockito.Mock is used to create a Mock object of the mentioned type
 * @To use Mock , need to use the special runwith as "MockitoJUnitRunner"
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockAnnotationTest {
	
	@Mock
	TodoService todoServiceMock;
	

	@Test
	public void testOne() {
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		assertEquals(0, todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy").size());
	}

	@Test
	public void testTwo() {
		List<String> asList = Arrays.asList("Learn MVC", "Learn Spring MVC");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		assertEquals(1, todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy").size());
	}

}
