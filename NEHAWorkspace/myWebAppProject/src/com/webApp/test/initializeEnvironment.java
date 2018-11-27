package com.webApp.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class initializeEnvironment {
	WebDriver driver;
	String username = "7448282860"; // Change to your username and passwrod
	String password = "nehafblogin";
	Alert a;

	public void init() {
		DesiredCapabilities dsr = new DesiredCapabilities();
		dsr.setJavascriptEnabled(true);
		 System.setProperty("webdriver.chrome.driver","F:\\NEHAWorkspace\\myWebAppProject\\drivers\\chromedriver.exe");
		 driver= new ChromeDriver(dsr);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://www.facebook.com/");
		driver.navigate().refresh();
		
		//*****************************
		
//		System.setProperty("webdriver.firefox.marionette",
//		"F:\\NEHAWorkspace\\myWebAppProject\\drivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.get("https://www.facebook.com/");

	}

	public void login() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//label[@id='loginbutton']//input")).click();
	}

	public void logout() {
		driver.findElement(By.xpath("//div[text()='Account Settings']")).click();
		driver.findElement(By.xpath("//ul//li//span[contains(text(),'Log Out')]")).click();
	}

	public void quit() {
		driver.close();
	}

	public void searchAndSelectFriend(String friendName) {
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys(friendName);
		// select the first item in the search results
		// driver.findElement(By.xpath("//div//ul[@id='facebar_typeahead_view_list']//li[@id='js_5e']"))
		// .click();
	}

	public void buyAndRemoveFromCart() {
		driver.findElement(By.cssSelector(".btn-express-checkout.btn-big.current")).click();
		driver.findElement(By.cssSelector(".remove.fk-inline-block")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public boolean isAlertPresent() throws InterruptedException {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			a = driver.switchTo().alert();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return flag;
	}

	public void dismissAlert() throws InterruptedException {
		if (isAlertPresent()) {
			System.out.println("asdfghj");
			a.dismiss();
		}
	}

}
