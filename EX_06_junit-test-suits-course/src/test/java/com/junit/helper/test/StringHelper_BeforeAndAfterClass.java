package com.junit.helper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.junit.helper.StringHelper;

public class StringHelper_BeforeAndAfterClass {

	
	static StringHelper stringHelper;
	
	/**
	 * @BeforeClass should be static method
	 */
	@BeforeClass
	public static void classSetup()
	{
		System.out.println("Before Class Executed");
		stringHelper = null;
	}
	
	@Before
	public void setUp() {
		System.out.println("Before Exceuted=========");
		if(stringHelper==null) {
			System.out.println("Object Created=========");
			stringHelper = new StringHelper();
		}
		
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
	
	@After
	public void destory()
	{
		System.out.println("After Exceuted=========");
		stringHelper = null;
	}
	
	@AfterClass
	public static void destorySetup()
	{
		System.out.println("After Class Executed");
		stringHelper = null;
	}
	

}
