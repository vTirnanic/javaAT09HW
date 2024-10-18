package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "text")
    public List<WebElement> button;

    public void clickOnButton(String buttonName) {
        for (int i = 0; i < button.size(); i++) {
            if (button.get(i).getText().equals(buttonName)) {
                button.get(i).click();
                break;
            }
        }
    }
}