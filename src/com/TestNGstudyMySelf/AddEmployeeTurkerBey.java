package com.TestNGstudyMySelf;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class AddEmployeeTurkerBey extends CommonMethods {
	  @BeforeClass(alwaysRun=true) 
	    public void openWebPage() {
	       setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	    }
	    @BeforeMethod(alwaysRun=true) 
	    public void login() {
	        driver.findElement(By.id("txtUsername")).sendKeys("admin");
	        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
	        driver.findElement(By.id("btnLogin")).submit();
	        boolean welcomeDisplayed = driver.findElement(By.id("welcome")).isDisplayed();
	        Assert.assertTrue(welcomeDisplayed, "Welcome element is NOT displayed");
	    }
	    @Test (priority=1,dataProvider="getData")
	    public void addEmployee(String firstName, String lastName, String userName, String password) throws InterruptedException {
	    	  Thread.sleep(1000);
	    	driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
	    	 Thread.sleep(1000);
	        driver.findElement(By.id("menu_pim_addEmployee")).click();
	        driver.findElement(By.id("firstName")).sendKeys(firstName);
	        driver.findElement(By.id("lastName")).sendKeys(lastName);
	        Thread.sleep(3000);
	        driver.findElement(By.id("btnSave")).click();
	    }
	    @Test(priority=2,dataProvider="getData")
	    public void addUserRole(String firstName, String lastName, String userName, String password) throws InterruptedException {
	        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
	        Select userRole=new Select(driver.findElement(By.id("systemUser_userType")));
	        userRole.selectByVisibleText("Admin");
	        Thread.sleep(1000);
	        driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(firstName+" "+lastName);
	        driver.findElement(By.id("systemUser_userName")).sendKeys(userName);
	        driver.findElement(By.id("systemUser_password")).sendKeys(password);
	        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(password);
	        driver.findElement(By.id("btnSave")).click();
	    }
	    @Test(priority=3,dataProvider="getData")
	    public void verifyEmp(String firstName, String lastName, String userName, String password) {
	        String expectedElement=firstName+" "+lastName;
	        String actualValue="";
	        List<WebElement> row=driver.findElements(By.xpath("//*[@id=\\\"resultTable\\\"]/tbody/tr"));
	        List<WebElement> col=driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td"));
	        for(int i=1;i<row.size();i++) {
	            actualValue=row.get(i-1).getText();
	            if(actualValue.contains(expectedElement)) {
	                 TakesScreenshot ts=(TakesScreenshot) driver;
	                    File screen=ts.getScreenshotAs(OutputType.FILE);
	                    try {
	                    FileUtils.copyFile(screen, new File("screenshots/HRMS/"+userName+".png"));
	                    }catch(IOException e) {
	                        e.printStackTrace();
	                    }
	            }else {
	                System.out.println(firstName+" "+lastName+" is not found");
	            }
	        }
	    }
	    @DataProvider
	    public Object[][] getData(){
	        Object[][] data= {
	                {"Samuel1", "Alacakli","Samuel123", "Samuel_123456789"  },
	                {"Turker1", "Korekli", "Turker123", "Turker_321654987"},
	                {"Harun1", "Dumanlidag", "Harun123","Harun_741258963"},
	                {"Ahmet1","Gul","Ahmet123","Ahmet_951263847"},
	                {"Ridvan1","Kirimci", "Ridvan","Ridvan_357891462"},
	        };
	        return data;
	    }
	    @AfterMethod(alwaysRun=true) 
	    public void closeWindow() throws InterruptedException {
	        Thread.sleep(3000);
	        driver.close();
	    }
	}

