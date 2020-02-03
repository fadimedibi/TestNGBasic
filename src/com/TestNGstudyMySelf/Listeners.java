package com.TestNGstudyMySelf;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Listeners{

	@Test
	public void loginWithEmail() {
		System.out.println("inside test login with email");
	}
	
	@Test
	public void loginWithFacebook() {
		System.out.println("inside test login with facebook");
		Assert.assertEquals("testString","testString1");
	}
	
	
}
