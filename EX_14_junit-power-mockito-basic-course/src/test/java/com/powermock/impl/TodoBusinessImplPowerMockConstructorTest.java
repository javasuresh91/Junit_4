package com.powermock.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * We are mocking the constructor of the ArrayList in our example
 * 
 * @Step 1 : setup the runner
 * @Step 2 : prepare for the test
 * @Step 3 : override the constructor
 *
 */

//Step 1
@RunWith(PowerMockRunner.class)
/**
 * @Step 2
 * @In the constructor mocking, we should use the class name where the
 *     constructor is used instead of constructor class name
 */
@PrepareForTest(TodoBusinessImpl.class) //
public class TodoBusinessImplPowerMockConstructorTest {

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Mock
	ArrayList arrayList;

	@Test
	public void testOne() throws Exception {
		List<Integer> listOfTodo = Arrays.asList(5, 100, 85, 45, 690);
		//Step 3
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(arrayList);
		
		when(arrayList.size()).thenReturn(5); //Here we mocking the size method of the Array Mock object
		int size = todoBusinessImpl.methodUsingAnArrayListConstructor();
		assertThat(size,is(5));
		
	}

}
