package TestCases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import CommonsUtility.BaseSetup;
import PageObjects.FacebookLoginPage;

public class FacebookTest extends FacebookLoginPage 
{
FacebookLoginPage login;	
@Test
public void PostFacebook() throws InterruptedException
{
	login=new FacebookLoginPage();	
	Test=Extent.createTest("PostFacebook");
	login.Login(prop.getProperty("username"), prop.getProperty("password"));	
	login.PostInFacebook("Testing Purpose Only"+Keys.ENTER);	
}
}
