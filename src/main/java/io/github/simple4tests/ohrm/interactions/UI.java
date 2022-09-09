package io.github.simple4tests.ohrm.interactions;

import io.github.simple4tests.webdriver.interactions.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UI extends Interactions {

    public UI(WebDriver driver) {
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

    @Override
    public UI setSelected(Object locator, boolean value) {
        WebElement input = getElement(locator).findElement(By.xpath(".//input"));
        WebElement span = getElement(locator).findElement(By.xpath(".//span"));
        if (getElement(input).isSelected() != value)
            click(span);
        return this;
    }

    @Override
    public UI selectByVisibleText(Object locator, String value) {
        click(locator);
        click(String.format("//div[@role='listbox']/div[.='%s']", value));
        return this;
    }
}
