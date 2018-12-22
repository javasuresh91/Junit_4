package com.junit.test.performance;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayHelperPerformanceTest {

	ArrayHelper arrayHelper = new ArrayHelper();
	
	
	@Test(timeout=400)
	public void testSort_performance() {
		int[] input = {100,5,9,1,250,1000}; 
		for(int i=0;i<10000000;i++)
		{
			input[0]=i;
			arrayHelper.sortedArray(input);
		}
	}

}
