package Test;

import Base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SubmitTest extends BaseTest {

    String firstName = "Pera";
    String lastName = "Peric";
    String validEmail = "pera@peris.com";
    String invalidEmail = "pera@com";
    String gender = "Male";
    String mobile = "0123456789";
    String subject1 = "English";
    String subject2 = "Maths";
    String hobby = "Music";
    String imageName = "1714226434917.png";
    String currentAddress = "Perin Sokak 5";
    String stateName = "NCR";
    String cityName = "Delhi";
    String submitMessage = "Thanks for submitting the form";


    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        scrollToElement(homepagePage.cardButton.get(0));
    }

    @Test
    public void userCanSubmit() throws InterruptedException {
        homepagePage.clickOnCard("Forms");
        sidebarPage.clickOnButton("Practice Form");
        practiceFormPage.inputFirstName(firstName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputEmail(validEmail);
        practiceFormPage.chooseGender(gender);
        practiceFormPage.inputMobile(mobile);
        scrollToElement(practiceFormPage.dateOfBirth);
        practiceFormPage.selectDateOfBirth("2001", "March", "15");
        practiceFormPage.inputSubject(subject1);
        practiceFormPage.inputSubject(subject2);
        practiceFormPage.chooseHobbies(hobby);
        practiceFormPage.uploadPicture(imageName);
        practiceFormPage.inputCurrentAddress(currentAddress);
        practiceFormPage.selectState(stateName);
        practiceFormPage.selectCity(cityName);
        practiceFormPage.clickOnSubmitButton();
        Assert.assertTrue(practiceFormPage.thanksForm.isDisplayed());
        Assert.assertEquals(practiceFormPage.thanksMessage.getText(), submitMessage);
        Assert.assertEquals(practiceFormPage.vTableCells.get(1).getText(), firstName + " " + lastName);
        Assert.assertEquals(practiceFormPage.vTableCells.get(3).getText(), validEmail);
        Assert.assertEquals(practiceFormPage.vTableCells.get(5).getText(), gender);
        Assert.assertEquals(practiceFormPage.vTableCells.get(7).getText(), mobile);
        Assert.assertEquals(practiceFormPage.vTableCells.get(9).getText(), "15 March,2001");
        Assert.assertEquals(practiceFormPage.vTableCells.get(11).getText(), subject1 + ", " + subject2);
        Assert.assertEquals(practiceFormPage.vTableCells.get(13).getText(), hobby);
        Assert.assertEquals(practiceFormPage.vTableCells.get(15).getText(), imageName);
        Assert.assertEquals(practiceFormPage.vTableCells.get(17).getText(), currentAddress);
        Assert.assertEquals(practiceFormPage.vTableCells.get(19).getText(), stateName + " " + cityName);
    }

    @Test
    public void userCannotSubmitWithInvalidEmail() throws InterruptedException {
        homepagePage.clickOnCard("Forms");
        sidebarPage.clickOnButton("Practice Form");
        practiceFormPage.inputFirstName(firstName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputEmail(invalidEmail);
        practiceFormPage.chooseGender(gender);
        practiceFormPage.inputMobile(mobile);
        scrollToElement(practiceFormPage.dateOfBirth);
        practiceFormPage.selectDateOfBirth("2001", "March", "15");
        practiceFormPage.inputSubject(subject1);
        practiceFormPage.inputSubject(subject2);
        practiceFormPage.chooseHobbies(hobby);
        practiceFormPage.uploadPicture(imageName);
        practiceFormPage.inputCurrentAddress(currentAddress);
        practiceFormPage.selectState(stateName);
        practiceFormPage.selectCity(cityName);
        practiceFormPage.clickOnSubmitButton();

        boolean isPresent = false;

        try {
            isPresent = practiceFormPage.thanksForm.isDisplayed();
        } catch (Exception e) {
            System.out.println(e);
        }

        Assert.assertFalse(isPresent);
        String actualBorderColor = practiceFormPage.emailField.getCssValue("border-color");
        Assert.assertEquals(actualBorderColor, "rgb(220, 53, 69)");
    }

    @Test
    public void userCannotSubmitWithoutInputs() throws InterruptedException {
        homepagePage.clickOnCard("Forms");
        sidebarPage.clickOnButton("Practice Form");
        practiceFormPage.clickOnSubmitButton();

        boolean isPresent = false;

        try {
            isPresent = practiceFormPage.thanksForm.isDisplayed();
        } catch (Exception e) {
            System.out.println(e);
        }

        Assert.assertFalse(isPresent);
    }
}
