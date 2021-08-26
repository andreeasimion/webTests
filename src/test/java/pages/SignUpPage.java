package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

@DefaultUrl("page:signUpPage")
public class SignUpPage extends PageObject {
    public final By usernameInput = By.cssSelector("input#name");
    By emailInput = By.cssSelector("input#email");
    By passwordInput = By.cssSelector("input#password");
    By termsCheckBox = By.cssSelector("label.mr-checkbox-1__check");
    By submit = By.cssSelector("form > button[type='submit']");
    public final By nameError = By.cssSelector("label#nameError");
    public final By emailError = By.cssSelector("label#emailError");
    public final By passwordError = By.cssSelector("form > div#signup-form-password");
    public final By termsError = By.cssSelector("label#termsError");
    public final By termsLink = By.cssSelector("span#signup-error-emptyTerms a:nth-child(1) > span");

    public void setText(WebElementFacade element,String strUserName){
        element.waitUntilVisible();
        element.click();
        element.sendKeys(strUserName);
    }

    public void click(WebElementFacade element){
        element.waitUntilVisible();
        element.click();
    }

    @Step
    public void signUp(String userName, String email, String password){
        fillInSignUpInputFields(userName, email, password);
        click($(termsCheckBox));
        click($(submit));
    }

    @Step
    public void fillInSignUpInputFields(String userName, String email, String password){
        setText($(usernameInput), userName);
        setText($(emailInput), email);
        setText($(passwordInput), password);
    }

    @Step
    public void clickSubmit(){
        click($(submit));
    }

    public String createUniqueEmail(){
        String generatedString = RandomStringUtils.randomAlphanumeric(5);
        return String.format("miro+%s@gmail.com", generatedString);
    }
}
