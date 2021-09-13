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
	
		
	}
	@Test
	public void WalletHubT() throws InterruptedException
	{
		wPAge=new WalletPage();
		Test=Extent.createTest("WalletHubT");
		wPAge.ClickSignUpButton();
		

	}
	
}
