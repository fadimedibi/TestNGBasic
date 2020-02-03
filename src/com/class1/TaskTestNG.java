package com.class1;

import org.testng.annotations.Test;

public class TaskTestNG {

	@Test
	public void getPage() {
		System.out.println("Page opened");
	}
	@Test
	public void loggingIn() {
		System.out.println("Logged in");
	}
	
	@Test
	public void close() {
		System.out.println("Closing the page");
	}
	
}
