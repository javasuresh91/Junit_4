package com.junit.mockito.verify;



import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mockito.service.TodoService;
import com.mockito.service.impl.TodoBusinessImpl;

public class TodoBusinessImplMockVerifyTest {

	@Test
	public void testOne() {
		//Given
		TodoService todoService = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC", "Learnss MVC", "Learn Spring MVC");
		given(todoService.retrieveTodos("Dummy")).willReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		//When
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
		
		//Then
		//verify is used to check whether the particular line/method/block is executed with/with-not particular value
		verify(todoService).deleteTodo("Learn Spring MVC");
	}
	
	@Test
	public void testTwo() {
		//Given
		TodoService todoService = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC", "Learn Spring MVC");
		given(todoService.retrieveTodos("Dummy")).willReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		//When
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
		
		//Then
		//verify is used to check whether the particular line/method/block is executed with/with-not particular value
		verify(todoService).deleteTodo("Learn MVC");
	}
	
	@Test
	public void testThree() {
		//Given
		TodoService todoService = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC", "Learnss MVC", "Learn Spring MVC");
		given(todoService.retrieveTodos("Dummy")).willReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		//When
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
		
		//Then
		//verify is used to check whether the particular line/method/block is executed with/with-not particular value
		//never will ensure that the specified method is not called 
		verify(todoService,never()).deleteTodo("Learn Spring MVC");
	}
	
	@Test
	public void testFour() {
		//Given
		TodoService todoService = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC", "Learnss MVC", "Learn Spring MVC");
		when(todoService.retrieveTodos("Dummy")).thenReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		//When
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
		
		//Then
		//verify is used to check whether the particular line/method/block is executed with/with-not particular value
		//time will ensure that the specified method is called for specified time 
		verify(todoService,times(1)).deleteTodo("Learn MVC");
		verify(todoService,times(2)).deleteTodo(anyString());
	}
	
	@Test
	public void testFive() {
		//Given
		TodoService todoService = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC", "Learn Spring MVC");
		given(todoService.retrieveTodos("Dummy")).willReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		//When
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
		
		//Then
		//should can be pass with the VerificationMode methods
		then(todoService).should().deleteTodo("Learn MVC"); //BBD Style of verifying
	}
	
	/**
	 * times,never are called VerificationMode, there are many verification mode available in  the package 
	 */

}
