package com.billr.tradesysv1.selenium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeleniumTests {
	
	private WebDriver driver;
	
	@Autowired
	public SeleniumTests(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test
	void testLoginPage() {
		driver.get("http://localhost:8080/");
		assertEquals("Login", driver.getTitle());
	}
	
	@Test
	void testLoginInput() throws InterruptedException {
		driver.get("http://localhost:8080/");
		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys("test123");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("test123");
		WebElement loginButton = driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=submit]"));
		loginButton.click();
		assertEquals("Position", driver.getTitle());

	}
	
	@Test
	void testPageVisits() throws InterruptedException {
		driver.get("http://localhost:8080/");
		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys("test123");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("test123");
		WebElement loginButton = driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=submit]"));
		loginButton.click();
		System.out.println("CURRENT URL="+driver.getCurrentUrl());
		
		driver.navigate().to("http://localhost:8080/trade");
		assertEquals("Trade History", driver.getTitle());
		
		driver.navigate().to("http://localhost:8080/orderstatus");
		assertEquals("Order Status", driver.getTitle());
		
		// Enter a trade
		
		driver.navigate().to("http://localhost:8080/tradeform/AA");
		assertEquals("Trade Entry", driver.getTitle());
		WebElement sideField = driver.findElement(By.name("side"));
		sideField.sendKeys("buy");

		WebElement qtyField = driver.findElement(By.name("qty"));
		qtyField.sendKeys("99");
		WebElement typeField = driver.findElement(By.name("type"));
		typeField.sendKeys("market");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.submit();
	}
	
}
