package com.mapp.obj.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BrowserLaunch extends Assert{
	
	public static WebDriver driver;
	public static String url="https://spec-challenge.herokuapp.com/";
	
	


	
	@Parameters({"browser"})
	@BeforeClass 
	public void setUp(@Optional String browser) throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", "Path");
		
		if(browser.equalsIgnoreCase("Firefox")){
			System.out.println("Running Firefox");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
			
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.out.println("Running Chrome");
			System.setProperty("webdriver.chrome.driver",".//src/main/resources/browser/chromedriver");
			driver=new ChromeDriver();
			
			
			
		}
		else if(browser.equalsIgnoreCase("Safari")){
			System.out.println("Running Safari");
			System.setProperty("webdriver.safari.driver","Path");
			driver=new SafariDriver();
			driver.manage().window().maximize();
			
		}
		driver.get(url);
	}
	
	@AfterClass
	public void close(){
		driver.close();
	}
}
