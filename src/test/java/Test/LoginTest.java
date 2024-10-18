package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    String validUsername = "peroslav";
    String invalidUsername = "perslav";
    String password = "Perinasifra1!";
    String invalidPassword = "Pernasifra1!";

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        scrollToElement(homepagePage.cardButton.get(0));
    }

    @Test
    public void userCanLogin() throws InterruptedException {
        homepagePage.clickOnCard("Book Store Application");
        booksPage.clickOnLoginButton2();
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(password);
        scrollToElement(loginPage.loginButton2);
        loginPage.clickOnLoginButton2();
        Assert.assertTrue(booksPage.logoutButton.isDisplayed());
        Assert.assertEquals(booksPage.usernameValue.getText(), validUsername);
    }

    @Test
    public void userCannotLoginWithInvalidUsername() {
        homepagePage.clickOnCard("Book Store Application");
        booksPage.clickOnLoginButton2();
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(password);
        scrollToElement(loginPage.loginButton2);
        loginPage.clickOnLoginButton2();
        Assert.assertTrue(booksPage.loginButton2.isDisplayed());
        Assert.assertEquals(booksPage.errorMessage.getText(), "Invalid username or password!");
    }

    @Test
    public void userCannotLoginWithInvalidPassword() {
        homepagePage.clickOnCard("Book Store Application");
        booksPage.clickOnLoginButton2();
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidPassword);
        scrollToElement(loginPage.loginButton2);
        loginPage.clickOnLoginButton2();
        Assert.assertTrue(booksPage.loginButton2.isDisplayed());
        Assert.assertEquals(booksPage.errorMessage.getText(), "Invalid username or password!");
    }

    @Test
    public void userCannotLoginWithInvalidCredentials() {
        homepagePage.clickOnCard("Book Store Application");
        booksPage.clickOnLoginButton2();
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(invalidPassword);
        scrollToElement(loginPage.loginButton2);
        loginPage.clickOnLoginButton2();
        Assert.assertTrue(booksPage.loginButton2.isDisplayed());
        Assert.assertEquals(booksPage.errorMessage.getText(), "Invalid username or password!");
    }

    @Test
    public void userCannotLoginWithoutCredentials() {
        homepagePage.clickOnCard("Book Store Application");
        booksPage.clickOnLoginButton2();
        scrollToElement(loginPage.loginButton2);
        loginPage.clickOnLoginButton2();
        Assert.assertTrue(booksPage.loginButton2.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/login");
    }
}
