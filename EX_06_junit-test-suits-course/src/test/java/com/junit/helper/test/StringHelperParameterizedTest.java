package com.junit.helper.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.junit.helper.StringHelper;

/**
 * Step 1:
 * @RunWith is used to tell it is a parameterized test class
 *
 */
@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
	
	StringHelper stringHelper = new StringHelper();
	
	private String input;
	private String expectedOut;
	
	
	
	public StringHelperParameterizedTest(String input, String expectedOut) {
		super();
		this.input = input;
		this.expectedOut = expectedOut;
	}

	/**
	 * Step 2:
	 * @Form the input and excepted output as Array with @parameter
	 */
	@Parameters
	public static Collection<String[]> testCondition()
	{
		String expectedOutput[][]={{"AACD","CD"},{"ACD","CD"},{"CDEF","CDEF"},{"CDAA","CDAA"}};
		
		return Arrays.asList(expectedOutput);
	}

	@Test
	public void testStringHelperTruncateAOne()
	{
		// AACD=> CD
		assertEquals(expectedOut, stringHelper.truncateAInFirst2Positions(input));
		
	}
	
//	@Test
//	public void testStringHelperTruncateATwo()
//	{
//		//ACD=>CD 
//		assertEquals(expectedOut, stringHelper.truncateAInFirst2Positions(input));
//	}
//	
//	@Test
//	public void testStringHelperTruncateAThree()
//	{
//		//CDEF=>CDEF
//		assertEquals(expectedOut, stringHelper.truncateAInFirst2Positions(input));
//	}
//	
//	@Test
//	public void testStringHelperTruncateAFour()
//	{
//		//CDAA=>CDAA
//		assertEquals(expectedOut, stringHelper.truncateAInFirst2Positions(input));
//	}

}
