package com.fileUploadTests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import Utils.DeleteUser;
import Utils.ExcelUtils;
import Utils.ExcelUtils_Registration;
import Utils.WebDriverProperties;
import Utils.WindowScroll;
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
	String email;

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
		RegisterPage.mobileNumber(driver).sendKeys(ExcelUtils_Registration.getMobileNo());
		
		WindowScroll.scrollWindow(driver);
		Select genderUi = new Select(RegisterPage.gender(driver));
		genderUi.selectByValue("Female");
		WebElement element = RegisterPage.profileImage(driver);
		
		element.sendKeys(file.getAbsolutePath());
		String actualTitlebefore_register=driver.getCurrentUrl();
		RegisterPage.registerSubmit(driver).click();
		String actualTitleafter_register=driver.getCurrentUrl();
		boolean urlChanges=actualTitlebefore_register.equalsIgnoreCase(actualTitleafter_register);
		assertFalse(urlChanges);

		email=RegistrationDetails[3];
		DeleteUser.deleteUser(email, driver);
		System.out.println("Verified registration successfult by uploading profile image");

		
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
