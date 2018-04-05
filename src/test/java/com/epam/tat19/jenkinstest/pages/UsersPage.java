package com.epam.tat19.jenkinstest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UsersPage extends AbstractPage {

	public UsersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[2]/td[4]/a[2]")
	private WebElement deleteUserButton;

	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[2]/td[4]/a[2]")
	private WebElement deleteAdmin;

	public void clickDeleteUserButton() {
		deleteUserButton.click();
	}

	public boolean findDeletedUser() {
		try {
			driver.findElement(By.linkText("UserTest"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean findDeleteButton() {

		try {
			deleteUserButton.getAttribute("href").equals("user/usertest/delete");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean findDeleteAdminHref() {
		try {
			deleteAdmin.getAttribute("href").equals("user/useruser/delete");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void checkDeletedUser() {
		Assert.assertFalse(findDeletedUser());
	}

	public void checkDeleteHref() {
		Assert.assertFalse(findDeleteButton());
	}

	public void checkDeleteAdminHref() {
		Assert.assertFalse(findDeleteAdminHref());
	}

	@Override
	public void openPage() {
	}

}
