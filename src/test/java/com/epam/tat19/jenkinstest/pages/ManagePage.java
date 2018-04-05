package com.epam.tat19.jenkinstest.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagePage extends AbstractPage {
	
	private final Logger logger = LogManager.getRootLogger();
	
	public ManagePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[16]/a")
	private WebElement manageUsersLink;

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUserLink;

	public void clickManageUsersLink() {//переход по ссылке "Manage Users"
		manageUsersLink.click();
		logger.info("Users page opened");
	}

	public void clickCreateUserLink() {//переход по ссылке "Create User"
		createUserLink.click();
		logger.info("Create User page opened");
	}

	@Override
	public void openPage() {
	}

}
