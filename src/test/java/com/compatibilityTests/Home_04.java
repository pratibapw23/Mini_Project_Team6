package com.compatibilityTests;

import org.testng.annotations.Test;

import Utils.WebDriverProperties;
import pageObjects.HomePage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_04 {
	WebDriver driver;
  @Test
  public void verify_FontStyleSize() throws IOException {
	  
	//Chrome
	  driver = WebDriverProperties.setChromeDriverProperties();
	  String URL_Chrome = driver.getCurrentUrl();
	  WebElement element_ch1= HomePage.home_title(driver);
	  String size_chrome1=element_ch1.getCssValue("font-size");
	  String style_chrome1=element_ch1.getCssValue("font-family");
	  WebElement element_ch2= HomePage.home_text(driver);
	  String size_chrome2=element_ch2.getCssValue("font-size");
	  String style_chrome2=element_ch2.getCssValue("font-family");
	  driver.close();
	  
	//MicrosoftEdge
	  driver = WebDriverProperties.setEdgeDriverProperties();
	  String URL_Edge= driver.getCurrentUrl();
	  WebElement element_E1= HomePage.home_title(driver);
	  String size_edge1=element_E1.getCssValue("font-size");
	  String style_edge1=element_E1.getCssValue("font-family");
	  WebElement element_E2= HomePage.home_text(driver);
	  String size_edge2=element_E2.getCssValue("font-size");
	  String style_edge2=element_E2.getCssValue("font-family");
	  driver.close();
	  
	  if(size_chrome1.equalsIgnoreCase(size_edge1)&&size_chrome2.equalsIgnoreCase(size_edge2))
		  System.out.println("Size of Home page title and text is same in different browser");
	  else
		  System.out.println("Size of Home page title and text is not same in different browser");
	  if(style_chrome1.equalsIgnoreCase(style_edge1)&&style_chrome2.equalsIgnoreCase(style_edge2))
		  System.out.println("Style of Home page title and text is same in different browser");
	  else
		  System.out.println("Style of Home page title and text is not same in different browser");
	 
  }
  

}
