package com.fileUploadTests;

import org.testng.annotations.Test;

import Utils.DeleteUser;
import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.RegisterPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Verify_ImageUpload {
	WebDriver driver;
	String Path;
	File file;

	@Test
	public void verifyImageUpload() throws InterruptedException, IOException {
		String RegistrationDetails[] = ExcelUtils.getRegistrationDetails1();
		RegisterPage.registerButton(driver).click();
		RegisterPage.username(driver).sendKeys(RegistrationDetails[0]);
		RegisterPage.firstName(driver).sendKeys(RegistrationDetails[1]);
		RegisterPage.lastName(driver).sendKeys(RegistrationDetails[2]);
		RegisterPage.email(driver).sendKeys(RegistrationDetails[3]);
		RegisterPage.passwordTextbox(driver).sendKeys(RegistrationDetails[4]);
		RegisterPage.passwordTextbox2(driver).sendKeys(RegistrationDetails[5]);
		RegisterPage.mobileNumber(driver).sendKeys("8787878787");
		Select genderUi = new Select(RegisterPage.gender(driver));
		genderUi.selectByValue("Female");
		WebElement element = driver.findElement(By.name("image"));
		
		element.sendKeys(file.getAbsolutePath());
		
		RegisterPage.registerSubmit(driver).submit();
		System.out.println(driver.getTitle());

	}

	@BeforeClass
	public void beforeClass() throws IOException {
		driver = WebDriverProperties.setChromeDriverProperties();
		

	}
	@BeforeMethod
	public void beforeMethod() throws IOException
	{

		FileReader reader = new FileReader("Info.properties");
		Properties prop = new Properties();
		prop.load(reader);

		Path = prop.getProperty("imageScriptPath");
		
		file = new File(Path);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
