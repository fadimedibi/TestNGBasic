package com.class2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AssertionsDemo extends CommonMethods {
	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(enabled = true)
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle, "Titles are matched");
		System.out.println("I am text after the Assertion");

	}

	@Test(enabled = true)
	public void logoValidation() {
		boolean isDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertTrue(isDisplayed, "Syntax logo is displayed");

//		//using if condition we cannot make testNG test fails
//		 	if (isDisplayed) {
//			System.out.println("test pass");
//		} else {
//			System.out.println("test fails");
//		}
//	}
		 
	}
}
