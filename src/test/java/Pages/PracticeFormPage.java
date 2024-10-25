package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PracticeFormPage extends BaseTest {

    public PracticeFormPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "gender-radio-1")
    public WebElement maleButton;

    @FindBy(id = "gender-radio-2")
    public WebElement femaleButton;

    @FindBy(id = "gender-radio-3")
    public WebElement otherButton;

    @FindBy(id = "userNumber")
    public WebElement mobileField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirth;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthDropdown;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearDropdown;

    @FindBy(className = "react-datepicker__day")
    public List<WebElement> days;

    @FindBy(id = "subjectsInput")
    public WebElement subject;

    @FindBy(id = "hobbies-checkbox-1")
    public WebElement sportCheckBox;

    @FindBy(id = "hobbies-checkbox-2")
    public WebElement readingCheckBox;

    @FindBy(id = "hobbies-checkbox-3")
    public WebElement musicCheckBox;

    @FindBy(id = "uploadPicture")
    public WebElement chooseFile;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(css = "div[id='state'] div")
    public List<WebElement> stateOptions;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(css = "div[id='city'] div")
    public List<WebElement> cityOptions;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(className = "modal-content")
    public WebElement thanksForm;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement thanksMessage;

    @FindBy(tagName = "td")
    public List<WebElement> vTableCells;

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void chooseGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            jsClick(maleButton);
        } else if (gender.equalsIgnoreCase("Female")) {
            jsClick(femaleButton);
        } else if (gender.equalsIgnoreCase("Other")) {
            jsClick(otherButton);
        } else {
            System.out.println("Gender: Invalid input");
        }
    }

    public void inputMobile(String mobile) {
        mobileField.clear();
        mobileField.sendKeys(mobile);
    }

    public void selectDateOfBirth(String year, String month, String day) {
        dateOfBirth.click();

        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);

        for (WebElement d : days) {
            if (d.getText().equals(day) && d.getAttribute("aria-disabled").equals("false")) {
                d.click();
                break;
            }
        }
    }

    public void inputSubject(String inputSubject) {
        subject.click();
        subject.sendKeys(inputSubject);
        subject.sendKeys(Keys.ENTER);
    }

    public void chooseHobbies(String hobby) {
        if (hobby.equalsIgnoreCase("Sports")) {
            jsClick(sportCheckBox);
        } else if (hobby.equalsIgnoreCase("Reading")) {
            jsClick(readingCheckBox);
        } else if (hobby.equalsIgnoreCase("Music")) {
            jsClick(musicCheckBox);
        } else {
            System.out.println("Hobby: Invalid input");
        }
    }

    public void uploadPicture(String imageName) {
        String imageLocation = System.getProperty("user.dir");
        chooseFile.sendKeys(imageLocation + "\\" + imageName);
    }

    public void inputCurrentAddress(String currAddress) {
        currentAddress.clear();
        currentAddress.sendKeys(currAddress);
    }

    public void selectState(String stateName) throws InterruptedException {
        state.click();
        Thread.sleep(300);

        for (WebElement so : stateOptions) {
            if (so.getText().equals(stateName)) {
                so.click();
                break;
            }
        }
    }

    public void selectCity(String cityName) throws InterruptedException {
        city.click();
        Thread.sleep(300);

        for (WebElement co : cityOptions) {
            if (co.getText().equals(cityName)) {
                co.click();
                break;
            }
        }
    }

    public void clickOnSubmitButton() {
        jsClick(submitButton);
    }
}
