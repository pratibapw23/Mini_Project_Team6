package com.registerTests;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.RegisterPage;
import Utils.DeleteUser;

public class TC_Register_Userid_1 {

	WebDriver driver;
	
	@Test
	public void Userid_001() throws IOException, InterruptedException
	{
		System.out.println("hello");
		RegisterPage.registerButton(driver).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		RegisterPage.username(driver).sendKeys("temp09");
		RegisterPage.firstName(driver).sendKeys("temp");
		RegisterPage.lastName(driver).sendKeys("lasttemp");
		RegisterPage.email(driver).sendKeys("temp@gmail.com");
		RegisterPage.passwordTextbox(driver).sendKeys("Tem@p123");
		RegisterPage.passwordTextbox2(driver).sendKeys("Tem@p123");
		RegisterPage.mobileNumber(driver).sendKeys("8787878787");
		Select genderUi = new Select(RegisterPage.gender(driver));
		genderUi.selectByValue("Female");
		Thread.sleep(100);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		RegisterPage.registerSubmit(driver).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		assertEquals(driver.getTitle(), "Login to iDrive");
		
		String email="temp@gmail.com";
		DeleteUser.deleteUser(email, driver);
		
	}
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver=WebDriverProperties.setChromeDriverProperties();
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
