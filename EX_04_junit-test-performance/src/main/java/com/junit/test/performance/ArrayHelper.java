package com.junit.test.performance;

import java.util.Arrays;

public class ArrayHelper {

	public int[] sortedArray(int[] input) {
		System.out.println("Calling Function");
		int[] output = input;
		try {
			Arrays.sort(output);
		} catch (NullPointerException e) {
			throw e;
		}
		return output;
	}
}
