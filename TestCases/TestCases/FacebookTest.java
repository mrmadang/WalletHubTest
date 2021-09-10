package TestCases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SetupUtility.*;
import PageObjects.FacebookLoginPage;

public class FacebookTest extends BaseSetup 
{
	
FacebookLoginPage login;	

@BeforeTest
public void Setup()
{
	DriverSetup=new DriverSetup();
	prop = DriverSetup.init_prop("qa1");
	Webdriver=DriverSetup.init_driver(prop);
	Webdriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	Webdriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
	SetExtent();
	
}
@Test
public void PostFacebook() throws InterruptedException
{
	login=new FacebookLoginPage();	
	Test=Extent.createTest("PostFacebook");
	login.Login(prop.getProperty("username"), prop.getProperty("password"));	
	login.PostInFacebook("Testing Purpose Only"+Keys.ENTER);	
}
}
