package TestCases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.WalletPage;
import SetupUtility.*;

public class WalletHubTC extends BaseSetup
{ 
//	public WebDriver Webdriver;
//	public DriverSetup DriverSetup;
//	public Properties prop;
	WalletPage wPAge;
	
	@BeforeTest
	public void Setup()
	{
		DriverSetup=new DriverSetup();
		prop = DriverSetup.init_prop("qa2");
		Webdriver=DriverSetup.init_driver(prop);
		Webdriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Webdriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
		SetExtent();
		wPAge=new WalletPage();
		
	}
	@Test
	public void WalletHubSignUp() throws InterruptedException
	{
		Test=Extent.createTest("WalletHubSignUp");
		wPAge.ClickSignUpButton();
		
		wPAge.SignUp("FName", "LName", "FName_LName@mailinator.com","Password0!", "TestAddress", "25251", "phNumber");
		
			

	}
	
	@Test
	public void WalletHubReview() throws InterruptedException
	{
		Test=Extent.createTest("WalletHubReview");
		//wPAge.ClickSignUpButton();
		
		wPAge.SignIn("userName", "PAssword");
		Webdriver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
		wPAge.WriteReview();
			

	}
	
}
