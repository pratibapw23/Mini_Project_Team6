package com.compatibilityTests;

import org.testng.annotations.Test;

import Utils.ExcelUtils_Urls;
import Utils.WebDriverProperties;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


public class Home_03 {
	WebDriver driver;
  @Test
  public void urlInDifferentBrowers() throws IOException {
	  String ExceptedURL[]=ExcelUtils_Urls.getURLs();
	  
	 //Chrome
	  driver = WebDriverProperties.setChromeDriverProperties();
	  String URL_Chrome = driver.getCurrentUrl();
	  assertEquals(ExceptedURL[0],URL_Chrome);
	  System.out.println("URL verified on Chrome browser");
	  driver.close();
	  
	//MicrosoftEdge
	  driver = WebDriverProperties.setEdgeDriverProperties();
	  String URL_Edge= driver.getCurrentUrl();
	  assertEquals(ExceptedURL[0],URL_Edge);
	  System.out.println("URL verified on Edge browser");
	  driver.close();
	 

	  
  }

}
