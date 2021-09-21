package com.functionalityTests;

import org.testng.annotations.Test;

import Utils.WebDriverProperties;
import Utils.WindowScroll;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import Utils.ExcelUtils_Urls;

import Utils.ExcelUtils;

public class Home_01 {
	WebDriver driver;
	
  @Test
  public void verify_allPagesConnected() throws IOException {
	  String urls[]=ExcelUtils_Urls.getURLs();
	  
	  //Homepage
	  String ActualHomeURL = driver.getCurrentUrl();
	  assertEquals(urls[0],ActualHomeURL);
	  System.out.println("Homepage link verified");
	  
	  //Register page url
	  HomePage.registerButton(driver).click();
	  String ActualRegistedURL = driver.getCurrentUrl();
	  assertEquals(urls[1],ActualRegistedURL);
	  System.out.println("Register link verified");
	  
	  //Login page url
	  HomePage.loginOnRegisterPage(driver).click();
	  String ActualLoginURL = driver.getCurrentUrl();
	  assertEquals(urls[2],ActualLoginURL);
	  System.out.println("Login page link verified after clicking login option from register page");
	  
	  //SignUp
	  LoginPage.signUP(driver).click();
	  String ActualRegistedURL1 = driver.getCurrentUrl();
	  assertEquals(urls[1],ActualRegistedURL1);
	  System.out.println("Register link verified after clicking on SignUp option on Login page");
	  
	  //LoginPage
	  HomePage.loginOnRegisterPage(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
	  LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
	  LoginPage.SignInButton(driver).click();
	  String ActualDashboardURL= driver.getCurrentUrl();
	  assertEquals(urls[3],ActualDashboardURL);
	  System.out.println("Dashboard link verified after clicking on Signin option on Login page");
	  
	  //Upload
	  DashboardPage.uploadFileLink(driver).click();
	  String ActualUploadURL= driver.getCurrentUrl();
	  assertEquals(urls[4],ActualUploadURL);
	  System.out.println("Upload page verified");
	  
	  //Dashboard
	  DashboardPage.backButton(driver).click();
	  String ActualDashboardURL1= driver.getCurrentUrl();
	  assertEquals(urls[3],ActualDashboardURL1);
	  System.out.println("Dashboard link verified after clicking on Back button on file upload page");
	  
	  //Profile
	  DashboardPage.profileLink(driver).click();
	  String ActualProfileURL= driver.getCurrentUrl();
	  assertEquals(urls[5],ActualProfileURL);
	  System.out.println("Profile link verified");
	  
	  //updateprofile
	  ProfilePage.updateProfileButton(driver).click();
	  String ActualUpdateProfileURL= driver.getCurrentUrl();
	  assertEquals(urls[6],ActualUpdateProfileURL);
	  System.out.println("Update Profile link verified");
	  
	  //again to profile page
	  ProfilePage.backBtn_updateProfileButton(driver).click();
	  String ActualProfileURL1= driver.getCurrentUrl();
	  assertEquals(urls[5],ActualProfileURL1);
	  System.out.println("Profile link verified after clicking on back button on update profile page");
	  
	  //UpdateProfilePicture
	  ProfilePage.updateProfilePicture(driver).click();
	  String ActualUpdatePicURL= driver.getCurrentUrl();
	  assertEquals(urls[7],ActualUpdatePicURL);
	  System.out.println("Update Profile picture link verified");
	  
	  //again to profile page
	  ProfilePage.backBtn_updatePictureButton(driver).click();
	  String ActualProfileURL2= driver.getCurrentUrl();
	  assertEquals(urls[5],ActualProfileURL2);
	  System.out.println("Profile link verified after clicking on back button on update picture page");
	  WindowScroll.scrollWindow(driver);
	  
	  //change password
	  ProfilePage.changePass_Button(driver).click();
	  String ActualPasswordURL = driver.getCurrentUrl();
	  assertEquals(urls[8],ActualPasswordURL);
	  System.out.println("Change password link verified");
	  
	  //back to profile page
	  ProfilePage.backBtn_changePasswordButton(driver).click();
	  String ActualProfileURL3= driver.getCurrentUrl();
	  assertEquals(urls[5],ActualProfileURL3);
	  System.out.println("Profile link verified after clicking on back button on update picture page");
	  
	  //logout
	  ProfilePage.logout_Button(driver).click();
	  String ActualLoginURL1 = driver.getCurrentUrl();
	  assertEquals(urls[2],ActualLoginURL1);
	  System.out.println("Login page link verified after clicking logout option from profile page");
	  
	  
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
