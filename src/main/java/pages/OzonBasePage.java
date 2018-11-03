package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static other.MyMethods.*;

public class OzonBasePage extends AbstractBasePage {

    @FindBy (xpath = "//*[@class='bSearchBoxTxt']")
    WebElement searchInputLine;


    public void searchTextInputLine(String text){
        waitElementVisAndClickable(searchInputLine);
        scrollClickInsertTextPressKey(searchInputLine, text, "ENTER");
    }

}
