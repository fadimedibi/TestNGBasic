package reviewTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationDemo {
	@Test(priority=1)
	public void test4() {
		System.out.println("Open Browser");
	}

	@Test

	public void test1() {
		System.out.println("Logining in");

	}

	@Test(priority=3)
	public void test0() {

		System.out.println("PIM Test Case");
	}

	@Test(priority=4)
	public void test2() {
		System.out.println("Leave test case");
	}

	@Test
	public void test3() {
		System.out.println("Close Browser");
	}

}
