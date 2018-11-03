package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import other.Init;

public abstract class AbstractBasePage {
    WebDriver driver;
    public AbstractBasePage(){
        driver = Init.getDriver();
        PageFactory.initElements(driver, this);
    }
}
