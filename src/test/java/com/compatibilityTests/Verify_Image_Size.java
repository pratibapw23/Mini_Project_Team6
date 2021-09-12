package com.compatibilityTests;
import Utils.*;
import pageObjects.HomePage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Verify_Image_Size {
	WebDriver driver;
	int sideImgwidthOnChrome,sideImghightOnChrome,logoHeightOnChrome,logoImgwidthOnChrome;
	int sideImgwidthOnEdge,sideImghightOnEdge,logoHeightOnEdge,logoImgwidthOnEdge;

  @Test
  public void verifySizeOnChromeAndEdge() throws IOException {
	  sideImgwidthOnChrome=HomePage.sideImage(driver).getSize().getWidth();
	  sideImghightOnChrome=HomePage.sideImage(driver).getSize().getHeight();
	  
	  logoImgwidthOnChrome=HomePage.logo(driver).getSize().getWidth();
	  logoHeightOnChrome=HomePage.logo(driver).getSize().getHeight();
	  
  }

  @BeforeMethod
  public void beforeMethod() throws IOException {
	  System.out.println("Getting the size of images on chrome browser..");
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	  driver.quit();
	  System.out.println("Getting the size of images of Edge browser..");

	  driver=WebDriverProperties.setEdgeDriverProperties();
	  sideImgwidthOnEdge=HomePage.sideImage(driver).getSize().getWidth();
	  sideImghightOnEdge=HomePage.sideImage(driver).getSize().getHeight();
	  
	  logoImgwidthOnEdge=HomePage.logo(driver).getSize().getWidth();
	  logoHeightOnEdge=HomePage.logo(driver).getSize().getHeight();
	  
	  System.out.println("Verifying width of side image on both the browsers..");
	  assertEquals(sideImgwidthOnChrome,sideImgwidthOnEdge);
	  System.out.println("Verified");
	  
	  System.out.println("Verifying height of side image on both the browsers..");
	  assertEquals(sideImghightOnChrome,sideImghightOnEdge);
	  System.out.println("Verified");

	  System.out.println("Verifying width of logo image on both the browsers..");
	  assertEquals(logoImgwidthOnChrome,logoImgwidthOnEdge);
	  System.out.println("Verified");
	  
	  System.out.println("Verifying Height of logo image on both the browsers..");
	  assertEquals(logoHeightOnChrome,logoHeightOnEdge);
	  System.out.println("Verified");
	  
	  driver.quit();


  }

}
