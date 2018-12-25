package com.mockito.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.List;

import org.junit.Test;

public class MockListAndException {

	@Test
	public void mockListSize() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(2);
		assertEquals(2, mockList.size());
		assertEquals(2, mockList.size());
		assertEquals(2, mockList.size());
		
	}
	
	@Test
	public void mockListSize_1() 
	{
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(2);
		assertEquals(2, mockList.size());
		assertEquals(3, mockList.size());
		assertEquals(2, mockList.size());
	}
	
	@Test
	public void mockListSize_2() 
	{
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, mockList.size());
		assertEquals(3, mockList.size());
	}
	
	@Test
	public void mockListGet()
	{
		List mockList = mock(List.class);
		when(mockList.get(0)).thenReturn("Suresh");
		assertEquals("Suresh", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	/**
	 * Argument matcher can be anything, Class Type or Object or etc
	 * any()
	 * anyInt()
	 * anyXXX()
	 * anyXXX(classType)
	 */
	@Test
	public void mockListGetUsingArgument()
	{
		List mockList = mock(List.class);
		//Argument matcher
		when(mockList.get(anyInt())).thenReturn("Suresh");
		assertEquals("Suresh", mockList.get(0));
		assertEquals("Suresh", mockList.get(1));
		assertEquals("Suresh", mockList.get(2));
		assertEquals("Suresh", mockList.get(100));
	}
	
	@Test
	public void mockListGetUsingArgument_1()
	{
		List mockList = mock(List.class);
		//Argument matcher
		when(mockList.get(anyInt())).thenReturn("Suresh");
		assertEquals("Suresh", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	/**
	 * Exception in LIst
	 */
	@Test(expected=Exception.class)
	public void mockListWithException()
	{
		List mockList = mock(List.class);
		//Argument matcher
		when(mockList.get(anyInt())).thenThrow(new NullPointerException());
		assertEquals("Suresh", mockList.get(0));
		
	}

}
