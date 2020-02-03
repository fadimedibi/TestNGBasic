package com.class2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * TC 1: HRMS Add Employee: 

Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Login into the application
Click on Add Employee
Verify labels: Full Name, Employee Id, Photograph are displayed
Provide Employee First and Last Name
Verify Employee has been added successfully
Close the browser

 */
public class TaskHrmsAddEmployeeAssertion extends CommonMethods {

	@BeforeMethod
	public void openAndLogIn() {
		setUp("chrome", Constants.HRMS_URL);

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();

		// clicking PIM button to access Add Employee Option
		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		// clicking Add Employee button
		driver.findElement(By.id("menu_pim_addEmployee")).click();
	}

	@Test
	public void verifyLabel() throws InterruptedException {
		Thread.sleep(3000);
		boolean fullNameDisp = driver.findElement(By.xpath("//label[text()='Full Name']")).isDisplayed();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(fullNameDisp, "Full name label Displayed");

		boolean employeeIdDisp = driver.findElement(By.xpath("//label[text()='Employee Id']")).isDisplayed();
		softAssert.assertTrue(employeeIdDisp, "Employee Id label Displayed");

		boolean photoDisp = driver.findElement(By.xpath("//label[text()='Photograph']")).isDisplayed();
		softAssert.assertTrue(photoDisp, "Photo label Displayed");

		// instantiating web elements and clicking (entering inputs)
		driver.findElement(By.id("firstName")).sendKeys("Aksam oldu ");
		driver.findElement(By.id("lastName")).sendKeys("Boyle Olsun");
		// String empId = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();

		boolean isDisplayed = driver.findElement(By.xpath("//h1[text()='Personal Details']")).isDisplayed();

		softAssert.assertEquals(isDisplayed, true, "Employee added succesfully");
		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
