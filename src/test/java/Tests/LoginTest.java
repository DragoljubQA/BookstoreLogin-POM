package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    String validUsername, validPassword;
    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage(driver);
        sidebarPage = new SidebarPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        homePage.clickOnCard("Book Store Application");
        sidebarPage.clickOnButton("Login");

        validUsername = "drbr";
        validPassword = "Qwerty123!@#";
    }

    @Test(priority = 1)
    public void userCanLogIn() {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(profilePage.profileNameText(), validUsername);
        Assert.assertTrue(profilePage.logOutButton().isDisplayed());
    }

    @Test(priority = 2)
    public void userCanLogOut() {
        userCanLogIn();
        profilePage.logOutButton().click();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
