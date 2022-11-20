package elements;

import org.openqa.selenium.WebElement;

public class Select {
    void selectByValue(WebElement webElement, String value) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(webElement);
        select.selectByValue(value);
    }
}
