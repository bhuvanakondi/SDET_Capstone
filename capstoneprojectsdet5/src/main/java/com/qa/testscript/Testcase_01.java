package com.qa.testscript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.Downloadspage;
import com.qa.pages.Homepage;
import com.qa.pages.Photospage;

public class Testcase_01 extends TestBase{
	Homepage hp;
	Downloadspage dp;
	Photospage pp;

	@Test
	public void case1() {

		hp = new Homepage(driver);
		driver.get("https://wordpress.org/");
		hp.getWordPressButton();
		dp = new Downloadspage(driver);
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(dp.getText(), prop.getProperty("expected"));
		dp.communityButtonClick();
		dp.photoDirectoryOption();
		pp = new Photospage(driver);
		pp.searchOption(prop.getProperty("search"));
		if (pp.image().isDisplayed()) {
			System.out.println("Image is displayed");
		} else {
			System.out.println("Image is not displayed");
		}
		
		soft.assertAll();

	}

}
