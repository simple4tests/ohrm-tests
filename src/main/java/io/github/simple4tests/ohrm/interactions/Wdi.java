package io.github.simple4tests.ohrm.interactions;

import io.github.simple4tests.webdriver.interactions.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import static io.github.simple4tests.wdicucumber.locators.CommonLocators.*;

public class Wdi extends Interactions {

    public Wdi(WebDriver driver) {
        super(driver);
    }

//    public void waitForPageToLoad() {
//        Sleeper.sleep(250);
//        wait.elementToBePresent(NO_LOADER);
//        wait.elementToBePresent(NO_TOGGL);
//    }

//    public void waitForSuccessToDisapear() {
//        wait.elementToBePresent(SUCCESS_MSG);
//        wait.until(input -> 0 == driver.findElements(SUCCESS_MSG).size());
//    }

    public Wdi setSelected(String xpath, boolean value) {
        if (element.locatedBy(By.xpath(xpath.concat("//input"))).getElement().isSelected() != value)
            element.locatedBy(By.xpath(xpath.concat("//span"))).click();
        return this;
    }

    @Override
    public Wdi selectByVisibleText(By by, String value) {
        element.locatedBy(by).click();
        element.locatedBy(By.xpath(String.format("//div[@role='listbox']/div[.='%s']", value))).click();
        return this;
    }
}
