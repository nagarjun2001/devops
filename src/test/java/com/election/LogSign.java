package com.election;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
class LogSign {
 
	private WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
 
	}
 
	@AfterEach
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	void testSignUp()  throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.name("uname")).sendKeys("gowthams");
		driver.findElement(By.name("fname")).sendKeys("Gowtham");
		driver.findElement(By.name("lname")).sendKeys("Sridharan");
		driver.findElement(By.name("email")).sendKeys("gowtham@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.name("number")).sendKeys("8615154312");
		driver.findElement(By.id("regbtn")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//Login Code
		driver.findElement(By.name("uname")).sendKeys("gowthams");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.id("logbtn")).submit();
		Thread.sleep(2000);
		String txt = driver.switchTo().alert().getText();
		if(txt != driver.switchTo().alert().getText()) {
//			System.out.println("Negative Login Case Success");
			driver.switchTo().alert().accept();
		}
		else {
			driver.switchTo().alert().accept();
//			System.out.println("Positive Login Case Success");
			driver.navigate().to("http://www:localhost:3000/");			
		}
	}
}