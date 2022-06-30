package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private enum browserNames {
	    chrome, firefox, safari
	}
	
//	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser Name is : " + browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		
		else if (browser.equals("safari")) {
			tldriver.set(new SafariDriver());
		}
		else {
			System.out.println("Please enter the correct valye for browser : " + browser);
			System.out.println("The correct browser values are : " + browserNames.chrome.toString() + "/" + browserNames.firefox.toString() + "/" + browserNames.safari.toString()  );
			
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
		
	}

}
