package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static other.MyMethods.*;

public class OzonCart extends AbstractBasePage {
    @FindBy(xpath = "//*[@class='eMyOzon_Item_Bottom' and contains(text(), 'Корзина')]")
    WebElement cart;
    @FindBy(xpath = "//*[@class ='eOzonPrice_main']")
    WebElement totalSum;

    public void clickCart (){
        waitElementVis(cart);
        scroll(cart);
        cart.click();
    }
    public void checkEquals (){
        waitElementVis(totalSum);
        if ((OzonResultSearch.summ == Float.valueOf(totalSum.getText().replaceAll("\\s+", ""))));
        else{
            System.out.println("Суммы не совпадают");
            System.out.println("Нарастающий итог: " + OzonResultSearch.summ);
            System.out.println("В корзине: " + Float.valueOf(totalSum.getText().replaceAll("\\s+", "")));
            System.exit(-1);
        }
    }

}
