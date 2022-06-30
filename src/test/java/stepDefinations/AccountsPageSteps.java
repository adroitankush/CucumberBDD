package stepDefinations;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	ConfigReader configReader;
	Properties prop;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String,String>> credList = credTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		DriverFactory.getDriver()
		.get(prop.getProperty("url"));
		accountsPage = loginPage.login(username, password);

	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page Title is : " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		List<String> expectedList = sectionTable.asList();
		System.out.println("Expected Accounts Section List : " + expectedList);
		List<String> actualList = accountsPage.accountSectionList();
		System.out.println("Actual Accounts Section List : " + actualList);
		
		Assert.assertTrue(expectedList.containsAll(actualList));
		

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
		int actualCount = accountsPage.getAccountSectionListCount();
		Assert.assertTrue(expectedCount == actualCount);

	}


}
