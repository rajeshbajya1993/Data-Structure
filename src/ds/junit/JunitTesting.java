package ds.junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.junit.Assert;

import ds.array.BinaryS;

public class JunitTesting {

	static BinaryS bs;
	public static void main(String[] args) {
		

	}
	@BeforeClass
	public static void setUp(){
		bs = new BinaryS();
	}
	@AfterClass
	public static void tearDown(){
		bs =null;
	}
	
	@Test
	public void binarySearchTest(){
		int [] arr = {1,4,6,8,11,20};
		int expected = 4;
		assertEquals(expected,bs.binarySearch(arr, 12));
	}

}
