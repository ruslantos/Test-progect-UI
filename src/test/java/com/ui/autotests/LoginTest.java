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

    @Epic("Почтовый сервис")
    @Feature("Авторизация")
    @Test(description = "Логин с валидными параметрами")
    public void loginTest() {
        loginPage.waitPageVisible()
                .setUsername(username)
                .clickEnterPasswordButton()
                .setPassword(password);
        mailHomePage = loginPage.clickLoginToMailButton()
                .waitPageVisible();

        assertEquals(mailHomePage.getUserEmail(), username, "Название почты неверно");
        mailHomePage.clickLogOutButton();
    }
}