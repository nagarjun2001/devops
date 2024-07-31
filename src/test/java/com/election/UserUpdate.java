package com.election;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class UserUpdate {
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
	void testUpdate() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("uname")).sendKeys("gowthams");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.id("logbtn")).submit();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
//		driver.get("http://localhost:3000/Home");
		driver.findElement(By.id("ucrud")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("uview")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"viewall\"]/div[2]/table/tbody/tr[1]/td[6]/a[1]/button")).click();
		driver.findElement(By.name("uname")).clear();
		driver.findElement(By.name("uname")).sendKeys("Kamal");
		driver.findElement(By.name("wardno")).clear();
		driver.findElement(By.name("wardno")).sendKeys("95");
		driver.findElement(By.name("voterid")).clear();
		driver.findElement(By.name("voterid")).sendKeys("CGFYUIJKNB987");
		driver.findElement(By.name("cid")).click();
		driver.findElement(By.xpath("//*[@id=\"viewall\"]/div/form/div[5]/select/option[4]")).click();
		driver.findElement(By.id("sub")).submit();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		System.out.println("Update Test Page Success!!!");
	}

}
