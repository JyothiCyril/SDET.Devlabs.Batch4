package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffPages {
	WebDriver driver;
	@FindBy(linkText="terms and conditions")
	WebElement TandCLink;
	
	public WebElement getTandCLink() {
		return TandCLink;
	}
	
	@FindBy(linkText="privacy policy")
	WebElement PrivacyLink;
	
	public WebElement getPrivacyLink() {
		return PrivacyLink;
	}
	
	
	
	@FindBy(linkText="Create Account")
	WebElement CreateAccountLink;
	
	public WebElement getCreateAccountLink() {
		return CreateAccountLink;
	}
	
	@FindBy(linkText="Sign in")
	WebElement SigninLink;
	
	public WebElement getSigninLink() {
		return SigninLink;
	}
	
	@FindBy(id="login1")
	WebElement UserNameTextField;
	
	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}
	
	@FindBy(id="password")
	WebElement PasswordTextField;
	
	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}
	
	@FindBy(id="remember")
	WebElement StaySignInChkbox;
	
	public WebElement getStaySignInChkbox() {
		return StaySignInChkbox;
	}
	
	@FindBy(name="proceed")
	WebElement SignInBtn;
	
	public WebElement getSignInBtn() {
		return SignInBtn;
	}
	
	@FindBy(xpath="//tbody/tr[3]/td[3]/input[1]")
	WebElement FullNameTextField;
		
	public WebElement getFullNameTextField() {
		return FullNameTextField;
	}
	
	@FindBy(xpath="//tbody/tr[7]/td[3]/input[1]")
	WebElement EmailIDTextField;
	
	public WebElement getEmailIDTextField() {
		return EmailIDTextField;
	}
	
	
	@FindBy(className="btn_checkavail")
	WebElement CheckAvailablityButton;
	
	public WebElement getCheckAvailablityButton() {
		return CheckAvailablityButton;
	}
	
	

	public RediffPages(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
