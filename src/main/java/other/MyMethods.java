package other;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyMethods {
    public static void waitElementVisAndClickable(WebElement webElement){
        new WebDriverWait(Init.getDriver(), 15).until(ExpectedConditions.visibilityOf(webElement));
        new WebDriverWait(Init.getDriver(), 15).until(ExpectedConditions.elementToBeClickable(webElement));

    }
    public static void waitElementVis(WebElement webElement){
        new WebDriverWait(Init.getDriver(), 15).until(ExpectedConditions.visibilityOf(webElement));

    }

    public static void scroll (WebElement webElement) {
            ((JavascriptExecutor) Init.getDriver()).executeScript("arguments[0].scrollIntoView();"
                    , webElement);
    }

    public static void scrollClickInsertTextPressKey (WebElement webElement, String text, String...button){
        scroll(webElement);
        webElement.click();
        webElement.sendKeys(text);
        if(button.length>0){
            for (String s : button) {
                webElement.sendKeys(Keys.valueOf(s));
            }
        }
    }

    public static void scrollAndClick (WebElement webElement){
        scroll(webElement);
        webElement.click();
    }

}
