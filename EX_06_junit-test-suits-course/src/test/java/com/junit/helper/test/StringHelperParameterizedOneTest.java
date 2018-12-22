package com.junit.helper.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.junit.helper.StringHelper;

@RunWith(Parameterized.class)
public class StringHelperParameterizedOneTest {

	private String input;
	private boolean excepted;
	StringHelper stringHelper = new StringHelper();
	public StringHelperParameterizedOneTest(String input, boolean excepted) {
		super();
		this.input = input;
		this.excepted = excepted;
	}
	
	
	@Parameters
	public static Collection<Object[]> getDataForTest() 
	{
		Object testData[][]= {{"B",false},{"ABAB",true}};
		
		return Arrays.asList(testData);
	}
	
	@Test
	public void test() {
		assertEquals(excepted, stringHelper.areFirstAndLastTwoCharactersTheSame(input));
	}
	
	
	

}
