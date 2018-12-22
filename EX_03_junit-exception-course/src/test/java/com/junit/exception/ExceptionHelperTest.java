package com.junit.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExceptionHelperTest {

	ExceptionHelper exceptionHelper;
	
	@Before
	public void setUp()
	{
		exceptionHelper = new ExceptionHelper();
	}
	
	@Test
	public void testOne() {
		int[] expected = {1,2,5,89,100};
		int[] number = {100,5,1,89,2};
		assertArrayEquals(expected, exceptionHelper.sortedArray(number));
	}
	
	@Test(expected=NullPointerException.class)
	public void testTwoNullException()
	{
		exceptionHelper.sortedArray(null);
	}
	

}
