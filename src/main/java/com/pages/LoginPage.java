package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?111");
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExists() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUsername(String Username) {
		driver.findElement(emailId).sendKeys(Username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin( ) {
		driver.findElement(signInButton).click();
	}
	
	public AccountsPage login(String username, String pwd) {
		System.out.println("Logging In With Username : " + username + " Password :" + pwd);
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}

}
