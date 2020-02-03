package com.TestNGstudyMySelf;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
//	@BeforeSuite---Set up system property for chrome
//	@BeforeTest---login to app
//	@BeforeClass---Launch chrome browser
//	@BeforeMethod---Enter URL
//	@Test---Google logo test
//	@AfterMethod---log out from the app
//	@BeforeMethod---Enter URL
//	@Test---Google Title Test
//	@AfterMethod---log out from the app
//	@BeforeMethod---Enter URL
//	@Test---Search Test
//	@AfterMethod---log out from the app
//	@AfterClass---Closing Browser
//	@AfterTest---deleting all cookies
	
//Preconditions annotations--- Starting with @Before
	@BeforeSuite
	public void setup() {
		System.out.println("@BeforeSuite---Set up system property for chrome");
	}

	@BeforeTest
	public void login() {
		System.out.println("@BeforeTest---login to app");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("@BeforeClass---Launch chrome browser");
	}

	@BeforeMethod
	public void enterURL() {
		System.out.println("@BeforeMethod---Enter URL");
	}

	// test cases---- starting with @Test
	@Test
	public void googleTitleTest() {
		System.out.println("@Test---Google Title Test");

	}
	@Test
	public void searchTest() {
		System.out.println("@Test---Search Test");
	}
	
	@Test
	public void googleLogoTest() {
		System.out.println("@Test---Google logo test");
	}

	// post conditions ---- starting with @After
	@AfterMethod
	public void logout() {
		System.out.println("@AfterMethod---log out from the app");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("@AfterClass---Closing Browser");
	}

	@AfterTest
	public void deleteAllCookies() {
		System.out.println("@AfterTest---deleting all cookies");
	}

	@AfterSuite
	public void generateTestReport() {
		System.out.println("@AfterSuite---Generating test reports");
	}

}
