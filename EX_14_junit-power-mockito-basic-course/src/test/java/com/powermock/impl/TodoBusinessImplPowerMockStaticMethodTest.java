package com.powermock.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;

import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Step 1 : Specify the Runner 
 * @Step 2 : Initialize the Class which has static methods
 * @Step 3 : Initialize the class specific to static method 
 * @Step 4: mock the static methods using when or given 
 */

//Step 1 :PowerMockRunner is a combination of MockitoJUnitRunner and power mock
@RunWith(PowerMockRunner.class)
//STEP 2
@PrepareForTest(UtilityClass.class)
public class TodoBusinessImplPowerMockStaticMethodTest {

	/**
	 * @Rule is used instead if @Runwith() Multiple Runner is not possible to use,
	 *       but multiple rules can be used
	 */
	//@Rule
	//public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	Dependency dependency;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Test
	public void testOne() {

		List<Integer> listOfTodo = Arrays.asList(5, 100, 85, 45, 690);
		when(dependency.retrieveAllStats()).thenReturn(listOfTodo);
		/**
		 * @This will call the Static method in the real implementation and do the
		 *       business logic and return the int value
		 */
		int actual = todoBusinessImpl.methodCallingAStaticMethod();
		assertEquals(5 + 100 + 85 + 45 + 690, actual);
	}
	
	@Test
	public void testTwo() {

		List<Integer> listOfTodo = Arrays.asList(5, 100, 85, 45, 690);
		when(dependency.retrieveAllStats()).thenReturn(listOfTodo);
		//STEP 3
		PowerMockito.mockStatic(UtilityClass.class);
		
		/**
		 * STEP 4
		 * This will mock the static method using the runner and  PowerMockito.mockStatic(...)
		 */
		when(UtilityClass.staticMethod(anyLong())).thenReturn(500);
		
		/**
		 * @This will call the mocked Static method in the real implementation and return the mock int value
		 */
		int actual = todoBusinessImpl.methodCallingAStaticMethod();
		assertEquals(500, actual);
	}
	
	
	@Test
	public void testThree() {

		List<Integer> listOfTodo = Arrays.asList(5, 100, 85, 45, 690);
		when(dependency.retrieveAllStats()).thenReturn(listOfTodo);
		//STEP 3
		PowerMockito.mockStatic(UtilityClass.class);
		
		/**
		 * STEP 4
		 * This will mock the static method using the runner and  PowerMockito.mockStatic(...)
		 */
		when(UtilityClass.staticMethod(925)).thenReturn(500);
		
		/**
		 * @This will call the mocked Static method in the real implementation and return the mock int value
		 */
		int actual = todoBusinessImpl.methodCallingAStaticMethod();
		//assertEquals(500, actual);
		
		/**
		 * Verifying the Static method is called or not
		 */
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(925);
	}
	
	@Test
	public void testFour() {

		List<Integer> listOfTodo = Arrays.asList(5, 100, 85, 45, 690);
		when(dependency.retrieveAllStats()).thenReturn(listOfTodo);
		//STEP 3
		PowerMockito.mockStatic(UtilityClass.class);
		
		/**
		 * STEP 4
		 * This will mock the static method using the runner and  PowerMockito.mockStatic(...)
		 */
		when(UtilityClass.staticMethod(925)).thenReturn(500);
		
		/**
		 * @This will call the mocked Static method in the real implementation and return the mock int value
		 */
		int actual = todoBusinessImpl.methodCallingAStaticMethod();
		//assertEquals(500, actual);
		
		/**
		 * Verifying the Static method is called or not
		 */
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6); //Real call will go, so TC will fail
	}

}
