package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import SetupUtility.*;

public class WalletPage extends BaseSetup
{
	
	// Sign up and Sign In Section 
	
	@FindBy(how = How.CSS, using = "#viewport > header > div > nav > div.login-join > a.joinforfree")
	public WebElement btnSignUp;
	
	@FindBy(how = How.CSS, using = "input#first-name")
	public WebElement inputFName;
	
	@FindBy(how = How.CSS, using = "input#last-name")
	public WebElement inputLName;
	
	@FindBy(how = How.CSS, using = "#join > div > div > div > form > div.btns > button")
	public WebElement btnJoinContinue;	
	
	@FindBy(how = How.CSS, using = "input[aria-label='email address']")
	public WebElement inputEMailAdd;
	
	@FindBy(how = How.CSS, using = "#join-email > form > div.btns.dual > button[data-hm-tap='next($event);'].btn.blue.touch-element-cl > span")
	public WebElement btnEmailContinue;	
	
	//End Sign up and Sign In Section
	
	@FindBy(how = How.XPATH, using="(//button[text()='Write a Review'])[1]")
	public WebElement btnWriteReview;
	
	@FindBy(how = How.CSS, using = "#reviews-section > modal-dialog > div > div > write-review > review-star > div > svg")
	public List<WebElement> starIcon;
	
	
	
	public void ClickSignUpButton()
	{
		btnSignUp.click();
	}
	
	public void EnterFirstName()
	{
		
	}

}
