package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import other.Init;

import java.util.ArrayList;
import java.util.Random;

import static other.MyMethods.*;

public class OzonResultSearch extends AbstractBasePage {
    private static final String itemsFormat = "//*[@class='item-view' and @data-key = '%s']";
    //private static final String itemButtonInCart = "//*[@class='item-view' and @data-key = '%s']//span[contains(text(),'корзин')]";
    private static final String itemButtonInCart = "//*[@class='item-view' and @data-key = '%s']//span[@class=contains(text(), 'buy-button')]";
//    private static final String itemButtonInCart = "//*[@class='item-view' and @data-key = '%s']/*/*/*/*" +
//            "[@class='buy-button blue-cream enlarged button flat-button tile-buy-button']/span[contains(text(),'')]";
//    private static final String itemPrice = "//*[@class='item-view' and @data-key = '%s']/*/*/*/*/*/span[@class='price-number']";
    private static final String itemPrice = "//*[@data-key='%s']//*[@class='price-number']/span";

    private static ArrayList<Integer> inCart = new ArrayList<Integer>();
    int count = 0;
    static float summ = 0;

    @FindBy(xpath = itemButtonInCart)
    WebElement eItemButtonInCart;

    @FindBy(xpath = itemPrice)
    WebElement eItemPrice;

    public void clickEItemButtonInCart(int i) {
        waitElementVisAndClickable(Init.getDriver().findElement(By.xpath(String.format(itemsFormat, Integer.toString(i)))));
        WebElement temp = (Init.getDriver().findElement(By.xpath(String.format(itemButtonInCart, Integer.toString(i)))));
        if (temp.getText().equals("В корзину")) {
            try {
                summ += Integer.valueOf((Init.getDriver().findElement(By.xpath(String
                        .format(itemPrice, Integer.toString(i))))).getText().replaceAll("\\s+", ""));
            } catch (NumberFormatException e){

            }
            scrollAndClick(temp);
        }
        System.out.println(summ);
        scrollAndClick(temp);

    }


    public void clickEItemButtonInCart() {
        int i = getRandomElement();
        waitElementVisAndClickable(Init.getDriver().findElement(By.xpath(String.format(itemsFormat, Integer.toString(i)))));
        WebElement temp = (Init.getDriver().findElement(By.xpath(String.format(itemButtonInCart, Integer.toString(i)))));
        if (temp.getText().equals("В корзину")) {
            try {
                summ += Float.valueOf((Init.getDriver().findElement(By.xpath(String
                        .format(itemPrice, Integer.toString(i))))).getText().replaceAll("\\s+", ""));
            } catch (NumberFormatException e){

            }
            scrollAndClick(temp);
        }
        System.out.println(summ);

//*[@class='item-view' and @data-key = '14']/*/*/*/*[@class='buy-button blue-cream enlarged button flat-button tile-buy-button']
    }

    public int getRandomElement() {
        int a;
        Random random = new Random();
        do {
            a = random.nextInt(elementCounter() + 1);
            //a = random.nextInt(5);
            System.out.println(a);
            if (!inCart.contains(a)) {
                inCart.add(a);
                break;
            }
        } while (true);

        return a;
    }

    public int getRandomItemSum(int from, int to) {
        Random random = new Random();
        int a = from + (random.nextInt(to));
        System.out.println(a);
        return a;
    }

    public void radomItemToCart(int from, int to) {
        int count = getRandomItemSum(from, to);
        for (int i = 0; i < count; i++) {
            clickEItemButtonInCart();
        }
    }

    public void radomItemToCart(int amt) {

        for (int i = 0; i < amt ; i++) {
            clickEItemButtonInCart();
        }
    }


    public int elementCounter() {
        boolean goOn = false;
        do {
            try {
                waitElementVisAndClickable(Init.getDriver().findElement(By.xpath((String.format(itemsFormat, Integer.toString(count))))));
                count++;
                goOn = true;
            } catch (NoSuchElementException e) {
                goOn = false;
            }
        } while (goOn || count == 0);

        return --count;
    }


}
