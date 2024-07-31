package com.election;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class UserDelete {

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
	void testUserDelete() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("uname")).sendKeys("gowthams");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.id("logbtn")).submit();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
//		driver.get("http://localhost:3000/Home");
		Thread.sleep(500);
		driver.findElement(By.id("ucrud")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("uview")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"viewall\"]/div[2]/table/tbody/tr[3]/td[6]/button")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		driver.switchTo().alert().accept();		
		System.out.println("Delete Test Success!!!");
	}

}
