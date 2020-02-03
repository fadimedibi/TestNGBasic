package reviewTestNG;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionReviewDemo {

	@Test
	public void testOne() {
		String actualTitle="HRM";
		String expectedTitle="HRM";
		
		
//		if(actualTitle.equals(expectedTitle)) {
//			System.out.println("test pass");
//		}else {
//			System.out.println("test failed");
//		}
		
		Assert.assertEquals(actualTitle, expectedTitle,"Actual Title did not match");
	//	Assert.assertTrue(test);
		
		System.out.println("Another testcase");
	}
	
	@Test
	public void testTwo() {
		ArrayList<String> ui=new ArrayList<>();
		ui.add("a");
		ui.add("b");
		ui.add("c");
		
		ArrayList<String> db=new ArrayList<>();
		db.add("a");
		db.add("b");
		db.add("cb");
		
	//	Assert.assertEquals(ui, db);
		
		//OR
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(ui, db);
	//	softAssert.assertAll();
		System.out.println("After Assertion demo");
	}
	
	
	
	
	
	
	
	
	
	
}
