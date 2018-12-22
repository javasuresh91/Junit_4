package com.junit.helper.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.junit.helper.StringHelper;

public class StringHelperTest {

	StringHelper stringHelper = new StringHelper(); 
	
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

}
