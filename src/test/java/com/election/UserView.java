package com.election;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class UserView {
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	void testUserView() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("uname")).sendKeys("gowthams");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.id("logbtn")).submit();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ucrud")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("uview")).click();
		Thread.sleep(2000);
		System.out.println("User View Page Test Success!!!");
	}

}
