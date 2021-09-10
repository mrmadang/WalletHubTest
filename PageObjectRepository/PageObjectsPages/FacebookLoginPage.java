package PageObjectsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import CommonsUtility.BaseSetup;

public class FacebookLoginPage extends BaseSetup 
{
	@FindBy(how = How.CSS, using = "input#email")
	public WebElement inputUser;
	
	@FindBy(how = How.CSS, using = "input#pass")
	public WebElement inputPass;
	
	@FindBy(how = How.CSS, using = "button[name='login']")
	public WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'What's on your mind,')]")
	public WebElement inputPost;
	
	
	
	public FacebookLoginPage()
	{
		// PageFactory.InitElements(this, new RetryingElementLocator(ncuDriver, TimeSpan.FromSeconds(60)));
		PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(),90), this);
	}
	
	
	
	public void Login(String userName,String password)
	{
		inputUser.clear();
		inputUser.sendKeys(userName);
		inputPass.clear();
		inputPass.sendKeys(password);
		btnLogin.click();
		
	}
	public void PostInFacebook(String postContent) 
	{
		inputPost.sendKeys(postContent);
	}
	
	
	
	
}
