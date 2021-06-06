package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	WebDriver driver;
	
	// element description of search text box
	
	// methods that return the Search text box element.
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchTextField;
	
	public WebElement getSearchTextField() {
		return SearchTextField;
	}
	
	@FindBy(linkText="Start here.")
	WebElement RegistrationLink;
	
	public WebElement getRegistrationLink() {
		return RegistrationLink;
	}
	
	
	@FindBy(id="nav-link-accountList")
	WebElement AccountandLists;
	
	public WebElement getAccountandLists() {
		return AccountandLists;
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement SearchButton;
	
	public WebElement getSearchButton() {
		return SearchButton;
	}
		
	@FindAll(@FindBy(className="nav_a"))
	List<WebElement> FooterLinks;
	
	public List<WebElement> getFooterLinks(){
		return FooterLinks;
	}
	
	
	@FindBy(id="searchDropdownBox")
	WebElement Category;
	
	
	public Select getCategory() {
		Select selCategory = new Select(Category);
		return selCategory;
	}

	public AmazonPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
