package PageEvent;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.RegisterVariables;

public class RegisterPage extends AbstractPage {
    WebDriver driver;

    public RegisterPage() {
        driver = Driver.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = RegisterVariables.LOGIN)
    private WebElement signInButton;

    public void signInClick() {
        clickFunction(signInButton);
    }

    @FindBy(className = RegisterVariables.SIGN_UP)
    private WebElement signUpButton;

    public void signUpClick() {
        clickFunction(signUpButton);
    }

    @FindBy(name = RegisterVariables.EMAIL_AREA)
    private WebElement emailText;

    public void setEmailText() {
        sendKeysFunction(emailText, RegisterVariables.EMAIL);
    }

    @FindBy(name = RegisterVariables.PASSWORD_AREA)
    private WebElement passwordText;

    public void setPasswordText() {
        sendKeysFunction(passwordText, RegisterVariables.PASSWORD);
    }

    @FindBy(id = RegisterVariables.CONTRACT_CHECKBOX)
    private WebElement contractCheckbox;

    public void setContractCheckbox() {
        if (!contractCheckbox.getAttribute("class").contains("checked")) {
            contractCheckbox.click();
        }
    }

    @FindBy(className = RegisterVariables.REGISTER_BUTTON)
    private WebElement registerButton;

    public void registerButtonClick() {
        clickFunction(registerButton);
    }

    public void isUserLogin() {
        waitSeconds(5);
        WebElement is_login = driver.findElement(RegisterVariables.MY_ACCOUNT_PATH);
        Assert.assertEquals(is_login,is_login);
        System.out.println("Üyelik Oluşturuldu");
    }
}