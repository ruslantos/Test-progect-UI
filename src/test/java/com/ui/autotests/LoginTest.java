package com.ui.autotests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pages.mailService.LoginPage;
import qa.pages.mailService.MailHomePage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    MailHomePage mailHomePage;

    @BeforeMethod
    public void setUp() {
        webDriver.get(websiteUrl);
        loginPage = new LoginPage(webDriver);
    }

    @Epic("Mail service")
    @Feature("Authorization")
    @Test(description = "Login with valid credentials")
    public void loginTest() {
        loginPage.waitPageVisible()
                .setUsername(username)
                .clickEnterPasswordButton()
                .setPassword(password);
        mailHomePage = loginPage.clickLoginToMailButton()
                .waitPageVisible();

        assertEquals(mailHomePage.getUserEmail(), username, "Email username wrong");
        mailHomePage.clickLogOutButton();
    }
}