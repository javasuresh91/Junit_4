package com.junit.exception;

import java.util.Arrays;

public class ExceptionHelper {

	public int[] sortedArray(int[] input) {
		int[] output = input;
		try {
			Arrays.sort(output);
		} catch (NullPointerException e) {
			throw e;
		}
		return output;
	}
}
