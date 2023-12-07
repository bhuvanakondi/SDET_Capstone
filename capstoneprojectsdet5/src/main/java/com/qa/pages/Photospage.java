package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Photospage {
	WebDriver driver;

	public Photospage (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id = "s")
	WebElement search;

	public void searchOption(String text) {
		search.sendKeys(text,Keys.ENTER);
	}
	
	@FindBy(xpath = "//*[@id=\"post-39607\"]/div/a/img")
	WebElement photo;

	public WebElement image() {
		return photo;
	}
	

}
