package PageObjects;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import SetupUtility.*;

public class WalletPage extends BaseSetup
{
	
	// Sign up and Sign In Section 
	@FindBy(how=How.CSS,using ="#homepage > section:nth-child(2) > div > div:nth-child(2) > div")
	public List<WebElement> chkBox;
	
	
	@FindBy(how = How.CSS, using = "#viewport > header > div > nav > div.login-join > a.joinforfree")
	public WebElement btnSignUp;
	
	@FindBy(how = How.CSS, using = "#web-app > header > div > nav.burger-menu-right-menu.brgm-guest-user > span[class*='login']")
	public WebElement btnSign;
	
	
	@FindBy(how = How.CSS, using = "input#email")
	public WebElement inputUserID;
	
	@FindBy(how = How.CSS, using = "input#password")
	public WebElement inputPassword;
	
	@FindBy(how = How.CSS, using = "#join-login > form > div.btns > input[type='submit']")
	public WebElement btnLogin;	
	
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
	
	
	@FindBy(how = How.CSS, using = "input#password")
	public WebElement inputPass;	
	
	@FindBy(how = How.CSS, using = "#join-pass > form > div.btns.dual > button:nth-child(2)")
	public WebElement btnPassContinue;	
	
	@FindBy(how = How.CSS, using = "#join-secq > form > div > div[name='qs']")
	public WebElement selectSecQst;
	
	@FindBy(how = How.CSS, using = "#join-secq > form > div > input[name='an']")
	public WebElement secAns;
	
	@FindBy(how = How.CSS, using = "#join-secq > form > div.btns.dual > button:nth-child(2)")
	public WebElement btnSecContinue;	
	
	@FindBy(how = How.CSS, using = "#join-address > form > div > input[name='ac']:nth-child(2)")
	public WebElement inputAddress;	
	
	
	
	@FindBy(how = How.CSS, using = "div.list >ul >li")
	public List<WebElement> lstAdd;	
	
	@FindBy(how = How.CSS, using = "#join-address > form > div > input[name='zp']")
	public WebElement inputZipCode;	
	
	@FindBy(how = How.CSS, using = "#join-address > form > div.btns.dual > button:nth-child(2)")
	public WebElement btnAddressContniue;	
	
	@FindBy(how = How.CSS, using = "#join-address > form > div> div > div > div > span[hm-tap*='ByPass']")
	public WebElement lnkByPassAdd;
	
	@FindBy(how = How.CSS, using = "input[name='cp']")
	public WebElement inputCellPhone;
	
	@FindBy(how = How.CSS, using = "#scroller > main > div.profile-header-module.profile-comp-header > nav > div.right-content > button")
	public List<WebElement> rightContentButton;
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	//End Sign up and Sign In Section
	
	@FindBy(how = How.XPATH, using="(//button[text()='Write a Review'])[1]")
	public WebElement btnWriteReview;
	
	@FindBy(how = How.CSS, using = "#reviews-section > modal-dialog > div > div > write-review > review-star > div > svg")
	public List<WebElement> starIcon;
	
	@FindBy(how = How.CSS, using = "#reviews-section > modal-dialog > div > div > write-review > div > ng-dropdown > div")
	public WebElement selectReviewOpt;
	
	@FindBy(how = How.CSS, using = "#reviews-section > modal-dialog > div > div > write-review > div > div.android > textarea")
	public WebElement inputReview;
	
	@FindBy(how = How.CSS, using = "#reviews-section > modal-dialog > div > div > write-review > sub-navigation > div > div:nth-child(2)")
	public WebElement submitReview;
	
	
	
	
	
	
	public  WalletPage() 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(),90), this);
		// TODO Auto-generated constructor stub
	}
	
	public void ClickSignUpButton()
	{
		btnSignUp.click();
	}
	
	public void EnterFirstName(String fName)
	{
		inputFName.clear();
		inputFName.sendKeys(fName);
	}
	public void EnterLastName(String lName)
	{
		inputLName.clear();
		inputLName.sendKeys(lName);
	}
	
	public void EnterEmail(String eMailAdd)
	{
		inputEMailAdd.clear();
		inputEMailAdd.sendKeys(eMailAdd);
	}
	
	public void EnterPassword(String password)
	{
		inputFName.clear();
		inputFName.sendKeys(password);
	}
	
	public void UncheckFreeCredit()
	{
		int x=chkBox.size();		
		
		for(WebElement chk:chkBox)
		{
			if(chk.getText().contains("No credit card required. Sign up in two minutes."))
			{
				if(chk.findElement(By.tagName("h2")).getAttribute("aria-expanded")=="false")
				{
					chk.click();
				}
				
			}
		}
	}
	
	 public void SignUp(String fName,String lName,String eMailAdd,String password,String address,String zip,String cellPhone)
	 {
		 UncheckFreeCredit();
		 btnSignUp.click();
		 EnterFirstName(fName);
		 EnterFirstName(lName);
		 btnJoinContinue.click();
		 EnterEmail(eMailAdd);
		 btnEmailContinue.click();
		 EnterPassword(password);
		 btnPassContinue.click();
		 selectSecQst.click();
		 List<WebElement> opt=selectSecQst.findElements(By.cssSelector("ul>li"));
		 for(WebElement x:opt)
		 {
			 if(x.getText().contains("What was the name of your first pet?"))
			 {
				 x.click();
			 }
			 
		 }
		 secAns.sendKeys("Bruno");
		 btnSecContinue.click();
		 inputAddress.sendKeys(address);
		 lstAdd.get(0).click();
		 inputZipCode.sendKeys(zip);		 
		 btnAddressContniue.click();
		 lnkByPassAdd.click();
		 inputCellPhone.sendKeys(cellPhone);
		 
		 //Madan: Not able to proceed from there as it asking Cellphone, once have valid data we can proceed.
		 
	 }

	 
	 public void ClickWriteReviewBtn()
	 {
		 int btn=rightContentButton.size();
		 
		 for(int i=0;i<btn;i++)
		 {
			String btnText= rightContentButton.get(i).getText();
			
			if(btnText.contains("Write a Review"))
			{
				rightContentButton.get(i).click();
			}
		 }
	 }
	 
	 public void WriteReview()
	 {
		 ClickWriteReviewBtn();
		 Actions ac= new Actions(Webdriver);
		 
		 ac.moveToElement(starIcon.get(3)).click().build().perform();
		 selectReviewOpt.click();
		 List<WebElement> opt=selectReviewOpt.findElements(By.cssSelector("ul[role='listbox']>li[role='option']"));
		for(int i=0;i<opt.size();i++)
		{
			if(opt.get(i).getText().contains("Health Insurance"))
			{
				opt.get(i).click();
			}
		}
		 int lenghth=200;
		 inputReview.sendKeys(RandomReview(lenghth, true, true));
		 submitReview.click();
		
	 
	 }
	 
	 public String RandomReview(int length,boolean useLetters, boolean useNumbers)
	 {			
		    String randomString = RandomStringUtils.random(length, useLetters, useNumbers);
		    return randomString;
	 }
	 
	 
	 public void SignIn(String userName,String password)
	 {
		 btnSign.click();
		 inputUserID.sendKeys(userName);
		 inputPassword.sendKeys(userName);
		 btnLogin.click();
		 
		 
	 }
}
