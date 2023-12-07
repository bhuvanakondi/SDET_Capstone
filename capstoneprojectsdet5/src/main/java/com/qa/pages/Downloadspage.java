package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Downloadspage {
	WebDriver driver;

	@FindBy(xpath = "//h1[@class='wp-block-heading has-text-align-center has-heading-1-font-size']")
	WebElement text;
    public String getText() {
		String actual = text.getText();
		return actual;

	}

	@FindBy(xpath = "(//button[@class='wp-block-navigation-item__content wp-block-navigation-submenu__toggle'])[3]")
	WebElement communityButton;
    public void communityButtonClick() {
		communityButton.click();
	}

	@FindBy(xpath = "(//span[@class='wp-block-navigation-item__label'])[18]")
	WebElement photoDirectory;
    public void photoDirectoryOption() {
		photoDirectory.click();
	}

	public Downloadspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
