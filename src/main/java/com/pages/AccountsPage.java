package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By sectionList = By.cssSelector(".row.addresses-lists>div>ul>li");
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public List<String> accountSectionList(){
		List<WebElement> elementsList = driver.findElements(sectionList);
		List<String> accountSectionList = new ArrayList<>();
		for(WebElement e : elementsList) {
			accountSectionList.add(e.getText());
		}
		return accountSectionList;
	}
	
	public int getAccountSectionListCount() {
		int count = driver.findElements(sectionList).size();
		return count;
	}

}
