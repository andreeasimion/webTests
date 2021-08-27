package shared;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class CommonPage extends PageObject {

    @Step
    public void navigateToNextTab() {
        ArrayList<String> tabs = new ArrayList<>(Serenity.getDriver().getWindowHandles());
        Serenity.getDriver().switchTo().window(tabs.get(1));
    }

    @Step
    public void setText(WebElementFacade element, String strUserName) {
        element.waitUntilVisible();
        element.click();
        element.sendKeys(strUserName);
    }

    @Step
    public void click(WebElementFacade element) {
        element.waitUntilVisible();
        element.click();
    }

    @Step
    public String getCurrentUrl() {
        return Serenity.getDriver().getCurrentUrl();
    }

    public String createUniqueEmail() {
        String generatedString = RandomStringUtils.randomAlphanumeric(5);
        return String.format("miro+%s@gmail.com", generatedString);
    }
}
