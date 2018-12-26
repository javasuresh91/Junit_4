package com.powermock.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockPrivateMethodTest {

	@Mock
	Dependency dependency;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	
	
	@Test
	public void testOne() throws Exception {
		List<Integer> listOfTodo = Arrays.asList(5, 100, 85, 45, 690);
		when(dependency.retrieveAllStats()).thenReturn(listOfTodo);
		/**
		 * Whitebox is used to test the private method
		 */
		long actualResult = Whitebox.invokeMethod(todoBusinessImpl, "privateMethodUnderTest");
		
		assertEquals(925, actualResult);
		
	}
	
	@Test
	public void testTwo() throws Exception {
		List<Integer> listOfTodo = Arrays.asList(5, 100, 85, 45, 690);
		when(dependency.retrieveAllStats()).thenReturn(listOfTodo);
		/**
		 * Whitebox is used to test the private method
		 */
		long actualResult = Whitebox.invokeMethod(todoBusinessImpl, "privateMethodUnderTest");
		
		assertEquals(9325, actualResult);
		
	}

}
