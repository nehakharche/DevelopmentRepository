package com.webApp.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoTest {
	initializeEnvironment objinitializeEnvironment=new initializeEnvironment();
	@BeforeClass
	public void init() {
		objinitializeEnvironment.init();
	}
	@Test(priority=1)
	public void searchNewFriend() throws InterruptedException {
		objinitializeEnvironment.login();
		//objinitializeEnvironment.searchAndSelectFriend("komal Shinde");
		//objinitializeEnvironment.logout();
	
	}
	@AfterClass
	public void tearDownEnv() {
		objinitializeEnvironment.quit();
	}
}
