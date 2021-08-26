package pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class CheckEmailPage extends PageObject {
    By checkEmailTitlePage = By.cssSelector("div > h1");

    public void getText(WebElementFacade element){
        element.waitUntilVisible();
        element.getText();
    }
}
