package com.mockito.service;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @Stub means a sekelton of real-time implementation in the test
 *
 */
public class TodoServiceStub implements TodoService {

	/**
	 * @Disadvantage for stub
	 * @1.Dynamic Condition - If we need to test different condition , we need to
	 *            give or implement different condition of "retrieveTodos()" override method
	 * @2.Service definition - if we change the "TodoService" interface we need to
	 *            maintain here too
	 * 
	 */
	@Override
	public List<String> retrieveTodos(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("Learn MVC", "Learn Spring MVC");
	}

}
