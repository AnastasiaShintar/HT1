package com.epam.tat19.jenkinstest.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{
	
	private final Logger logger = LogManager.getRootLogger();
	private static final String BASE_URL = "http://localhost:8080";

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageJenkinsLink;

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		if ((!driver.getTitle().equals("Dashboard [Jenkins]")) || (!driver.getCurrentUrl().equals(BASE_URL))) {
			throw new IllegalStateException("Wrong site page!");
		}
		logger.info("Login page opened");
	}
	
	public void clickManageJenkinsLink() {
		manageJenkinsLink.click();
		logger.info("Manage Jenkins page opened");
	}

}
