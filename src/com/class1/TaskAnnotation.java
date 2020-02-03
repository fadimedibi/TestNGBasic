package com.class1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Task 1: Executing different test based TestNG annotations

Create class that will have:
Before and After Class annotation
Before and After Method annotation
2 methods with Test annotation

Observe the results!



 */
public class TaskAnnotation {

	@BeforeClass

	public void getPage() {
		System.out.println("getting the URL");
	}

	@AfterClass

	public void close() {
		System.out.println("closing the page");

	}

	@BeforeMethod

	public void deleteCookies() {
		System.out.println("deleting the cookies");
	}

	@AfterMethod

	public void logIn() {
		System.out.println("logging in to the page");
	}

	@Test
	public void change() {
		System.out.println("Changing sth");
	}

	@Test
	public void delete() {
		System.out.println("deleting");
	}
}
