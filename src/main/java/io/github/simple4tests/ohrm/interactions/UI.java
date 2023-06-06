package io.github.simple4tests.ohrm.interactions;

import io.github.simple4tests.webdriver.interactions.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static io.github.simple4tests.ohrm.locators.CommonLocators.LISTBOX_X;
import static io.github.simple4tests.ohrm.locators.CommonLocators.LOADER;

public class UI extends Interactions {

    public UI(WebDriver driver) {
        super(driver);
//        setImplicitWaits(200);
    }

    public void waitForPageToLoad() {
//        sleep(200);
        waitToBeAbsent(LOADER);
    }

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
        click(String.format(LISTBOX_X, value));
        return this;
    }
}
