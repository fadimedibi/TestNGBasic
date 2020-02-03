package com.class1;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TitleAndLoginVerification extends CommonMethods {

	// @BeforeMethod
	@BeforeClass
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}

	// @AfterMethod
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@Test(priority = 3, groups= {"regression", "Sprint1"})
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("test pass");
		} else {
			System.out.println("test fails");
		}
	}

	@Test(priority = 2)
	public void logoValidation() {
		boolean isDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		if (isDisplayed) {
			System.out.println("test pass");
		} else {
			System.out.println("test fails");
		}
	}

	@Test(priority = 1, groups= {"smoke", "login"})
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}

}
