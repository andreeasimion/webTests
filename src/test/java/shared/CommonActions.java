package shared;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;

public class CommonActions extends PageObject {

    public void navigateToNextTab() {
        ArrayList<String> tabs = new ArrayList<>(Serenity.getDriver().getWindowHandles());
        Serenity.getDriver().switchTo().window(tabs.get(1));
    }

    @Step
    public String getCurrentUrl(){
        return Serenity.getDriver().getCurrentUrl();
    }
}
