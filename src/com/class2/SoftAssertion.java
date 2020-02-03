package com.class2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class SoftAssertion extends CommonMethods {

	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test
	public void LogoAndLogin() {
		boolean logoDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
	//	logoDisplayed = false;
	
	// Hard Assertion will fail and execution will stop at that point
	//	Assert.assertTrue(logoDisplayed, "Logo is not displayed");
		
		
	// Soft Assertion	
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "Logo is NOT Displayed");
		

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();

		boolean welcomeDisplayed = driver.findElement(By.id("welcome")).isDisplayed();
	//	Assert.assertTrue(welcomeDisplayed);
		
		softAssert.assertTrue(welcomeDisplayed, "Welcome element is NOT displayed");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
