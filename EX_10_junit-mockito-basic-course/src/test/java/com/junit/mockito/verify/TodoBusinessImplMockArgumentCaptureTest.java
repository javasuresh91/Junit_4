package com.junit.mockito.verify;



import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
import org.mockito.ArgumentCaptor;

import com.mockito.service.TodoService;
import com.mockito.service.impl.TodoBusinessImpl;

/**
 * @Step 1 : Declare the Argument Capture
 * @Step 2 : Define the Argument capture on the specific method call
 * @Step 3 : Capture the argument and verify
 * 
 */
public class TodoBusinessImplMockArgumentCaptureTest {
	
	@Test
	public void testOne() {
		
		//Step 1 : Declare the Argument Capture
		ArgumentCaptor<String> stringArgumentCap = ArgumentCaptor.forClass(String.class);
		
		
		
		TodoService todoService = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC", "Learn Spring MVC");
		given(todoService.retrieveTodos("Dummy")).willReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
		
		//STEP 2: Define the Argument capture
		verify(todoService).deleteTodo(stringArgumentCap.capture());
		//Step 3 : Capture the argument and verify
		assertThat(stringArgumentCap.getValue(), is("Learn MVC"));
	}
	
	@Test
	public void testTwo() {
		
		//Step 1 : Declare the Argument Capture
		ArgumentCaptor<String> stringArgumentCap = ArgumentCaptor.forClass(String.class);
		
		
		
		TodoService todoService = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC", "Learn Spring MVC");
		given(todoService.retrieveTodos("Dummy")).willReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
		
		//STEP 2: Define the Argument capture
		verify(todoService).deleteTodo(stringArgumentCap.capture());
		//Step 3 : Capture the argument and verify
		assertThat(stringArgumentCap.getValue(), is("Learn Spring MVC"));
	}
	
	@Test
	public void testThree() {
		
		//Step 1 : Declare the Argument Capture
		ArgumentCaptor<String> stringArgumentCap = ArgumentCaptor.forClass(String.class);
		
		
		
		TodoService todoService = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn MVC","Learn MVC love it ", "Learn Spring MVC");
		given(todoService.retrieveTodos("Dummy")).willReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
		
		//STEP 2: Define the Argument capture
		verify(todoService,times(2)).deleteTodo(stringArgumentCap.capture());
		//Step 3 : Capture the argument and verify
		assertThat(stringArgumentCap.getAllValues().size(), is(2));
	}
	
}
