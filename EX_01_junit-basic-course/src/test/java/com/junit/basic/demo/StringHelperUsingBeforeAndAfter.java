package com.junit.basic.demo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StringHelperUsingBeforeAndAfter {

	
	StringHelper stringHelper;
	
	/**
	 * It will execute before each and every test case
	 */
	@Before
	public void setUp()
	{
		System.out.println("Before Exceuted=========");
		stringHelper = new StringHelper();
	}
	
	
	@Test
	public void testOne() {
		System.out.println("Test One");
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void testtwo() {
		System.out.println("Test two");
		assertTrue("CD", stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
	
	/**
	 * This will execute after each and every test completed
	 */
	@After
	public void destory()
	{
		System.out.println("After Exceuted=========");
		stringHelper = null;
	}

}
