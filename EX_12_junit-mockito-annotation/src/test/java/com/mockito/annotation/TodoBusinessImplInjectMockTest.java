package com.mockito.annotation;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mockito.service.TodoService;
import com.mockito.service.impl.TodoBusinessImpl;

/**
 * 
 * @org.mockito.InjectMocks is used to Inject the Dependency Object/mock into
 *                          the class which is annotated by @InjectMocks
 * @In Our scenario,
 * @1.TodoBusinessImpl is annotated with @InjectMocks
 * @2.So Our @RunWith(MockitoJUnitRunner.class) will look into the
 *       TodoBusinessImpl.java and get all the Dependency Object and compare
 *       with the @Mock object it any Mock is available.
 * @3.If any Mock object matches, it automatically inject our Mock object into the TodoBusinessImpl.java
 * @4.It helps us to avoid manual injection or new object creation
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplInjectMockTest {

	@Mock
	TodoService todoServiceMock;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Test
	public void testOne() {
		assertEquals(0, todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy").size());
	}

	@Test
	public void testTwo() {
		List<String> asList = Arrays.asList("Learn MVC", "Learn Spring MVC");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(asList);
		assertEquals(1, todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy").size());
	}

}
