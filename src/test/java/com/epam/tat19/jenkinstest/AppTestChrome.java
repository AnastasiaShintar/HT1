package com.epam.tat19.jenkinstest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.tat19.jenkinstest.steps.Steps;

public class AppTestChrome {
	private Steps steps;
	private final String ADMIN_NAME = "UserUser";
	private final String ADMIN_PASSWORD = "user12345qwerty";
	private final String TEST_USER_NAME = "UserTest";
	private final String TEST_USER_PASSWORD = "usertestusertest";
	private final String TEST_USER_CONFIRM_PASSWORD = "usertestusertest";
	private final String TEST_USER_FULL_NAME = "User Test";
	private final String TEST_USER_EMAIL_ADDRESS = "reygsxbsb@emltmp.com";
	private final String BUTTON_COLOR = "#4b758b";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initChromeBrowser();
	}

	@Test(description = "Create New User in Jenkins", enabled = false)
	public void createNewUser() {
		steps.openLoginPage(ADMIN_NAME, ADMIN_PASSWORD);
		Assert.assertEquals(steps.getLogInbuttonColor(), BUTTON_COLOR);
		steps.openManageJenkinsPage();
		steps.openManageUser();
		steps.createUser(TEST_USER_NAME, TEST_USER_PASSWORD, TEST_USER_CONFIRM_PASSWORD, TEST_USER_FULL_NAME, TEST_USER_EMAIL_ADDRESS);
		Assert.assertEquals(steps.getCreateUserButtonСolor(), BUTTON_COLOR);
		steps.createUserButtonClick();
		steps.deleteUser();
		Assert.assertEquals(steps.getacceptDeleteUserButtonColor(), BUTTON_COLOR);
		steps.acceptDeleteUserButtonClick();
		steps.checkDeletedUser();
	}

	@Test(description = "Delete Admin") //не работает тест!
	public void tryDeleteAdmin() {
		steps.openLoginPage(ADMIN_NAME, ADMIN_PASSWORD);
		steps.openManageJenkinsPage();
		steps.openManageUser();
		steps.deleteAdmin();
	}

	@AfterMethod(description = "Stop Browser")
	public void closeDriver() {
		steps.closeDriver();
	}

}
