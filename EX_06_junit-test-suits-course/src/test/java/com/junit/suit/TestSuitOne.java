package com.junit.suit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.junit.helper.StringHelper;
import com.junit.helper.test.StringHelperParameterizedOneTest;
import com.junit.helper.test.StringHelperTest;


/**
 * 
 * @Suit will help to collect the test classes and run it 
 *
 */
@RunWith(Suite.class)
@SuiteClasses({StringHelperTest.class,StringHelperParameterizedOneTest.class})
public class TestSuitOne {

	

}
