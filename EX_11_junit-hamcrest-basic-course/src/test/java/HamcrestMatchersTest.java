import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Hamcrest is used only for the matching the value in the assertion part
 * @It is more readable and effective way of asserting the value
 * @It has vast variety of methods in the Matchers
 *
 */
public class HamcrestMatchersTest {

	List<Integer> scores ;
	String[] strArr = {"","hai","welcome",null};;
	
	@Before
	public void setUp() {
		scores = Arrays.asList(100,58,65,45);
	}
	
	//Collection Value Testing
	@Test
	public void testOne()
	{
		assertThat(scores, hasSize(4));
	}
	@Test
	public void testTwo()
	{
		assertThat(scores, hasSize(3));
	}
	
	
	@Test
	public void testThree()
	{
		assertThat(scores, hasItems(100,58,45));
	}
	
	@Test
	public void testFour()
	{
		assertThat(scores, hasItems(100,85,58,45));
	}
	
	@Test
	public void testFive()
	{
		assertThat(scores, everyItem(greaterThan(35)));
	}
	
	@Test
	public void testSix()
	{
		assertThat(scores, everyItem(lessThan(35)));
	}
	
	@Test
	public void testSeven()
	{
		assertThat(null, isEmptyOrNullString());
		assertThat("", isEmptyString());
	}
	
	//Array Testing
	@Test
	public void testEight()
	{
		assertThat(strArr, arrayWithSize(4));
	}
	
	@Test
	public void testNine()
	{
		assertThat(strArr, arrayWithSize(greaterThan(4)));
	}
	
	@Test
	public void testTen()
	{
		assertThat(strArr, arrayWithSize(equalTo(4)));
	}
	
	@Test
	public void test_11()
	{
		assertThat(strArr, arrayContaining("","hai","welcome",null));
	}
	
	@Test
	public void test_12()
	{
		assertThat(strArr, arrayContainingInAnyOrder("welcome",null,"","hai"));
	}
	
	
	

}
