package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
// 1. Testirati login (Book Store Application/Login)
// 2. Na https://demoqa.com/ sajtu treba otvoriti Practice Form stranicu i testirajte ovu formu
public class BaseTest {

    public static WebDriver driver;
    public HomepagePage homepagePage;
    public LoginPage loginPage;
    public SidebarPage sidebarPage;
    public PracticeFormPage practiceFormPage;
    public BooksPage booksPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homepagePage = new HomepagePage();
        loginPage = new LoginPage();
        sidebarPage = new SidebarPage();
        practiceFormPage = new PracticeFormPage();
        booksPage = new BooksPage();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
