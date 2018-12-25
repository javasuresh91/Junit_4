package com.mockito.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mockito.service.TodoService;

/**
 * @BDD -Behavioral Driven Development 
 * @Spilting the Software requirement into scenarios and test them by using BDD style   
 * @BDD Style follows three steps
 * Step 1 : Given - giving something(Setup or Arrange the scenarios)
 * step 2 : When - happens something(Actual or Act of method call)
 * Step 3 : Then - do this(assertion)
 *
 */

public class TodoBusinessImplUsingBDDMockStyleTest {

	@Test
	public void testOne() {
		// Step 1 : (Given) 
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC", "Learn Spring MVC");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(asList); // BDD style of mocking
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		// Step 2 : (When)
		int size = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy").size();
		
		//Step 3: (Then)
		assertThat( size,is(1)); // BDD style of Assertion
	}
	
	
	@Test
	public void mockListGet()
	{
		// Step 1 : (Given) 
		List<String> mockList = mock(List.class);
		given(mockList.get(0)).willReturn("Suresh");
		
		// Step 2 : (When)
		String actual = mockList.get(0);
		String actual2 = mockList.get(1);
		
		//Step 3: (Then)
		assertThat(actual, is("Suresh"));
//		assertThat(actual2, null);
		
	}
	
	
	
}
