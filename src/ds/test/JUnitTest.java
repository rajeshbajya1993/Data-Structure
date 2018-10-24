package ds.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class JUnitTest {

	@Test
	public void testGenericArray(){
		assertEquals("Hello Rajesh", "Rajesh", "Rajesh");
	}
	public static void main(String[] args) {
		
		JUnitTest test = new JUnitTest();
		test.testGenericArray();

	}

}
