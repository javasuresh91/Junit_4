package com.mockito.spy.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MockitoSpyTest {

	@Test
	public void test() {
		List<String> arrayListMock = mock(ArrayList.class);
		assertEquals(0, arrayListMock.size()); // it will return 0 default value
		when(arrayListMock.size()).thenReturn(5); // we mocked here as 5
		assertEquals(5, arrayListMock.size()); // It return 5 because, it is mocked in before line
		/**
		 * Mock will create a dummy object and it wont do any business logic in that and it wont affect the Mock values
		 */
		arrayListMock.add("Hai");
		assertEquals(5, arrayListMock.size()); // It also return 5
			
	}
	/**
	 * @In the above test case, the real business logic cannot be done, So SPY came into the picture
	 * @SPY will enable some feature to override the mock behaviour and help to give our business logic into that 
	 */
	
	@Test
	public void testOne() {
		List<String> arrayListSpy = spy(ArrayList.class); // spy is used
		assertEquals(0, arrayListSpy.size()); // it will return 0 default value
		arrayListSpy.add("Hai");
		assertEquals(1, arrayListSpy.size()); // It also return 1
		when(arrayListSpy.size()).thenReturn(5); // we can mocked spy and here as 5
		assertEquals(5, arrayListSpy.size()); // It return 5 because, it is mocked in before line
			
	}

}
