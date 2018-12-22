package com.junit.basic.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringHelperTest {
	
	
	StringHelper stringHelper = new StringHelper(); 

	/**
	 * Test methods always should be public and void
	 */
	@org.junit.Test
	public void test() {
		/**
		 * First arguments - Expected
		 * Second Arguments - Actual
		 */
		assertEquals("ABCD", "ABCD");
	}
	
	@Test
	public void testStringHelperTruncateAOne()
	{
		// AACD=> CD
		String actualResponse = stringHelper.truncateAInFirst2Positions("AACD");
		String expectedResponse = "CD";
		assertEquals(expectedResponse, actualResponse);
		
	}
	
	@Test
	public void testStringHelperTruncateATwo()
	{
		//ACD=>CD 
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testStringHelperTruncateAThree()
	{
		//CDEF=>CDEF
		assertEquals("CDEF", stringHelper.truncateAInFirst2Positions("CDEF"));
	}
	
	@Test
	public void testStringHelperTruncateAFour()
	{
		//CDAA=>CDAA
		assertEquals("CDAA", stringHelper.truncateAInFirst2Positions("CDAA"));
	}


}
