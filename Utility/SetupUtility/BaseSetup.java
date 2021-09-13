package SetupUtility;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;//WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseSetup extends ExtentReporter 
{
	public WebDriver Webdriver;
	public DriverSetup DriverSetup;
	public Properties prop;
	
	
	/*
	@AfterTest
	public void EndTest()
	{		
		EndReport();
		if(Webdriver!=null)
		{
		Webdriver.quit();
		}
		//Webdriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
	}
	*/
	@AfterMethod
	public void TearDown(ITestResult Result)
	{
		TearDownTest(Result);
		EndReport();
		if(Webdriver!=null)
		{
		Webdriver.quit();
		}
	}

}
