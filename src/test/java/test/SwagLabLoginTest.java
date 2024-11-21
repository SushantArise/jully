package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.Reports;
import org.testng.annotations.Listeners;
@Listeners(test.Listeners.class)
public class SwagLabLoginTest extends BaseTest {
	

	@BeforeMethod
	public void launchApplication() {
	     driver=Browser.openBrowser();
	}
	
	@Test
	public void verifyIfUserIsAbleToLoginWithValidCredentials() throws IOException{
		test=reports.createTest("verifyIfUserIsAbleToLoginWithValidCredentials");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	
	}
	
	@Test
	public void verifyIfWarningMessageIsDisplayedForLockedUser()  throws IOException{
		test=reports.createTest("verifyIfWarningMessageIsDisplayedForLockedUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("locked_out_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
	    Assert.assertTrue(swagLabLoginPage.isWarningLabelDisplayed());
	    Assert.assertEquals(swagLabLoginPage.getWarnigMessage(), "Epic sadface:Sorry");
}
}
