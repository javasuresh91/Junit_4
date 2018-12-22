package com.junit.basic.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringhelperBooleanTest {

	StringHelper stringHelper = new StringHelper();
	
	@Test
	public void testTwoCharactersTheSameOne() {
		boolean actualResponse = stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD");
		boolean expectedResponse =  false;
//		ABCD=>false
		assertEquals(expectedResponse, actualResponse); 
	}
	
	@Test
	public void testTwoCharactersTheSametwo()
	{
		/**
		 * For assert the boolean value this a special method, this is another way of assert
		 */
//		b=>false
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("B")); //It check the actual response is false
	}
	
	@Test
	public void testTwoCharactersTheSameThree()
	{
//		ABAB=>true
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB")); //It chacks the actual response is true
	}
	
	@Test
	public void testTwoCharactersTheSameFour()
	{
		/**
		 * Comment can be pass to the true or false condition
		 */
		assertFalse("Not matched Value from data",stringHelper.areFirstAndLastTwoCharactersTheSame("ABcAB"));
	}
	
	@Test
	public void testTwoCharactersTheSameFive()
	{
		assertTrue("Data breached", stringHelper.areFirstAndLastTwoCharactersTheSame("aaaza"));
	}

}
