package com.mockito.annotation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mockito.service.TodoService;
import com.mockito.service.impl.TodoBusinessImpl;


@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplIArgumentCaptorTest {

	@Mock
	TodoService todoServiceMock;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCap = ArgumentCaptor.forClass(String.class);

	
	@Test
	public void testThree() {
		List<String> asList = Arrays.asList("Learn MVC", "Learn Spring MVC");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(asList);
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");
		verify(todoServiceMock).deleteTodo(stringArgumentCap.capture());
		assertThat(stringArgumentCap.getValue(), is("Learn MVC"));
	}

}
