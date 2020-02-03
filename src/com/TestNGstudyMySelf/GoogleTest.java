package com.TestNGstudyMySelf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}

	@Test(priority=1,groups="Title")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		
		//validation
		
		Assert.assertEquals(title, "Google", "title is not passed");
		
	}

	@Test(priority=3,groups="logo")
	public void googleLogoTest() {
		boolean logo = driver.findElement(By.id("hplogo")).isDisplayed();
		System.out.println("is logo displayed : " + logo);

		Assert.assertTrue(logo);
		Assert.assertEquals(logo, true);
	}

	@Test(priority=2,groups="Link Test")
	public void mailLinkTest() {
		boolean mailLink = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println("is mail link displayed: " + mailLink);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
