package stepdefs;

import com.github.romankh3.image.comparison.model.ImageComparisonState;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import net.serenitybdd.core.steps.UIInteractionSteps;
import pages.SignUpPage;
import shared.CommonPage;
import utils.ScreenshotUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpSteps extends UIInteractionSteps {
    SignUpPage register;
    CommonPage action;
    private String email;

    @BeforeScenario
    public void generateEmail() {
        email = register.createUniqueEmail();
    }

    @Given("Sign up page is open")
    public void signUpPageIsOpen() {
        register.open();
    }

    @When("I submit mandatory data")
    public void createUser() {
        register.signUp("Andreea", email, "M78B&!!%h%@o");
    }

    @Then("I'm redirected to Check email page")
    public void checkEmailPage() {
        String checkEmailUrl = action.getCurrentUrl();
        assertThat(checkEmailUrl).contains("email-confirm");
    }

    @When("I submit {string}, {string} and {string} values for registration fields")
    public void iSubmitNameValueForFieldName(String nameValue, String emailValue, String passwordValue) {
        register.signUp(nameValue, emailValue, passwordValue);
    }

    @Then("I receive an error message for field {string}")
    public void iReceiveAnErrorMessageForFieldFieldToValidate(String field) {

        switch (field) {
            case "name":
                $(register.nameError).shouldBeCurrentlyVisible();
                break;
            case "email":
                $(register.emailError).shouldBeCurrentlyVisible();
                break;
            case "password":
                $(register.passwordError).shouldBeCurrentlyVisible();
                break;
        }
    }

    @When("I take a screenshot")
    public void iTakeAScreenshot() {
        $(register.usernameInput).waitUntilVisible();
        ScreenshotUtil.takeScreenshotOfThePage();
    }

    @Then("Register screen is as expected")
    public void registerScreenIsAsExpected() {
        assertThat(ImageComparisonState.MATCH).isEqualTo(ScreenshotUtil.compareImages());
    }

    @When("I submit registration form without accepting terms")
    public void iSubmitRegistrationFormWithoutAcceptingTerms() {
        register.fillInSignUpInputFields("Andreea", email, "M78B&!!%h%@o");
        register.clickSubmit();
    }

    @Then("Terms and conditioning checkbox returns an error")
    public void termsAndConditioningCheckboxReturnsAnError() {
        $(register.termsError).shouldBeCurrentlyVisible();
    }

    @When("I click terms link")
    public void iClickTerms() {
        register.click($(register.termsLink));
    }

    @Then("The Terms and Conditions page is open")
    public void thePageIsOpen() {
        action.navigateToNextTab();
        String checkEmailUrl = action.getCurrentUrl();
        assertThat(checkEmailUrl).contains("terms-of-service");
    }
}
