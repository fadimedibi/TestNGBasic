package com.TestNGstudyMySelf;

import org.testng.annotations.Test;

public class TestNGFeatures {

	@Test
	public void loginTest() {
		System.out.println("login test");
	//	int i=9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homePageTest() {
		System.out.println("Home page Test");
	}
	
	
}
