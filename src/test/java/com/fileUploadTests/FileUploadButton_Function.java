package com.fileUploadTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import junit.framework.Assert;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.UploadFilePage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.UpAction;
import org.testng.annotations.AfterMethod;

public class FileUploadButton_Function {
	WebDriver driver;
  @Test
  public void Verify_UploadButton_Present() throws Exception {
	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
	  LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
	  LoginPage.SignInButton(driver).submit();	  
	  DashboardPage.uploadFileLink(driver).click();
	  
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  
	  Assert.assertEquals( driver.getPageSource().contains("Upload File"),true);
	  Assert.assertEquals(UploadFilePage.uploadButton(driver).isDisplayed(),true);
	  Assert.assertEquals(UploadFilePage.uploadButton(driver).isEnabled(),true);
	
	  String method=UploadFilePage.getForm(driver).getAttribute("method");
	  String typecheck=UploadFilePage.uploadButton(driver).getAttribute("type");
	  Assert.assertEquals(typecheck, "submit");
	  Assert.assertEquals(method, "post");
	
	  System.out.println("Test Case Pass: Upload Button type:"+typecheck+ " method:"+method);
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
