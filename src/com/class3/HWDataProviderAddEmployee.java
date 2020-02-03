package com.class3;
/*
 * TC 1: HRMS Add Employee: 

Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Login into the application
Add 5 different Employees and create login credentials by providing: 
First Name
Last Name
Username
Password
Provide Employee First and Last Name
Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
Close the browser
Specify group for this test case, add it into specific suite and execute from xml file.
 */

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;

public class HWDataProviderAddEmployee extends CommonMethods {

	@BeforeClass(alwaysRun=true)
	public void openAndNavigate() {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	}

	@BeforeMethod(alwaysRun=true)
	public void logIn() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();

	}

	@AfterMethod(alwaysRun=true)
	public void logOut() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
	}

	@Test(dataProvider = "employeeData", groups="Add Employee")

	public void addEmployee(String firstName, String lastName, String userName, String password)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("firstName")));
		Thread.sleep(1000);
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("chkLogin")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("user_name")));
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		driver.findElement(By.id("btnSave")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='profile-pic']/h1")));
		String nameOfEmp = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		System.out.println(nameOfEmp + " has been added successfully");
		Thread.sleep(1000);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(nameOfEmp, firstName + " " + lastName, "Employee is Not Added");
		softAssert.assertAll();
		Thread.sleep(1000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen,
					new File("C:\\Users\\murat\\eclipse-workspace\\TestNGBasic\\screenshots/HMRS/AddEmployee"
							+ firstName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@DataProvider

	public Object[][] employeeData() {
		Object[][] data = { { "Lady", "Macbeth", "CrazyMacbeth", "t/%v+/ rIp/;0Vp" },
				{ "Juliet", "Capulet", "Juliet&Romeo", "t/%v+/ rIp/;0Vp" },
				{ "Romeo", "Montague", "LonelyStar", "t/%v+/ rIp/;0Vp" },
				{ "Prince", "Hamlet", "PoisonedHamlet", "t/%v+/ rIp/;0Vp" },
				{ "King", "Lear", "LearNotLiar", "t/%v+/ rIp/;0Vp" }

		};
		return data;

	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
