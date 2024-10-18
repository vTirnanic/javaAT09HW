package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends BaseTest {

    public BooksPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "login")
    public WebElement loginButton2;

    @FindBy(id = "submit")
    public WebElement logoutButton;

    @FindBy(id = "userName-value")
    public WebElement usernameValue;

    @FindBy(id = "name")
    public WebElement errorMessage;

    public void clickOnLoginButton2() {
        loginButton2.click();
    }
}
