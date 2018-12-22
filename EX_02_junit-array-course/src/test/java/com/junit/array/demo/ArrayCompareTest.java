package com.junit.array.demo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArrayCompareTest {

	@Test
	public void test() {
		int[] number = {12,2,89,9,1};
		int[] expected = {1,2,9,12,89};
		Arrays.sort(number);
		/*
		 * This would be fail because it compares the array object not the arrays value
		 */
		assertEquals(expected, number);
		
	}
	
	@Test
	public void testOne()
	{
		int[] number = {12,2,89,9,1};
		int[] expected = {1,2,9,12,89};
		Arrays.sort(number);
		/**
		 * it compares the values in the Array object, so it would be pass
		 */
		assertArrayEquals(expected, number);
		
	}
	
	@Test
	public void testTwo()
	{
		int[] number = {12,2,89,9,1};
		int[] expected = {1,12,9,2,89};
		Arrays.sort(number);
		assertArrayEquals(expected, number);
	}

}
