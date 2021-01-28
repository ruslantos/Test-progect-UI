package com.ui.autotests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pages.onlineStore.AccountCreationPage;
import qa.pages.onlineStore.AccountHomePage;
import qa.pages.onlineStore.MainStorePage;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseTest {
    MainStorePage mainStorePage;
    AccountCreationPage accountCreationPage;
    AccountHomePage accountHomePage;
    Random random = new Random();
    protected String email = random.nextInt(1000 - 1) + "test@mail.ru";
    protected String firstname = "Ivan";
    protected String lastname = "Ivanov";
    protected String password = "testPwd";
    protected String city = "Kazan";
    protected String address = "adress";
    protected String phone = "123456789";
    protected String postcode = "00000";
    protected String state = "Alabama";

    @BeforeMethod
    public void setUp() {
        webDriver.get(onlineStoreUrl);
        mainStorePage = new MainStorePage(webDriver);
    }

    @Epic("Магазин")
    @Feature("Регистрация")
    @Test(description = "Регистрация аккаунта с валидными параметрами")
    public void registration() {
        mainStorePage.waitPageVisible()
                .clickSignInButton()
                .waitPageVisible()
                .setEmail(email);
                accountCreationPage = mainStorePage.submitCreateButton().waitPageVisible();
        accountCreationPage.setFirstname(firstname)
                .setLastname(lastname)
                .setPassword(password)
                .setAdress(address)
                .setCity(city)
                .setPostcode(postcode)
                .setPhone(phone)
                .selectState(state);
        accountHomePage = accountCreationPage.clickRegisterButton();
        assertEquals(accountHomePage.getAccountName(),"Ivan Ivanov","Имя аккаунта неверно.");
    }
}