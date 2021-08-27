package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

@DefaultUrl("page:signUpPage")
public class SignUpPage extends CommonPage {
    public final By usernameInput = By.cssSelector("input#name");
    public final By nameError = By.cssSelector("label#nameError");
    public final By emailError = By.cssSelector("label#emailError");
    public final By passwordError = By.cssSelector("#signup-form-password.signup__error-wrap-login");
    public final By termsError = By.cssSelector("label#termsError");
    public final By termsLink = By.cssSelector("span#signup-error-emptyTerms a:nth-child(1) > span");
    public final By submit = By.cssSelector("form > button[type='submit']");
    By emailInput = By.cssSelector("input#email");
    By passwordInput = By.cssSelector("input#password");
    By termsCheckBox = By.cssSelector("label.mr-checkbox-1__check");


    @Step
    public void signUp(String userName, String email, String password) {
        fillInSignUpInputFields(userName, email, password);
        click($(termsCheckBox));
        click($(submit));
    }

    @Step
    public void fillInSignUpInputFields(String userName, String email, String password) {
        setText($(usernameInput), userName);
        setText($(emailInput), email);
        setText($(passwordInput), password);
    }

    @Step
    public void clickSubmit() {
        click($(submit));
    }
}
