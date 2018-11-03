import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import other.Init;
import pages.AbstractBasePage;
import pages.OzonBasePage;
import pages.OzonCart;
import pages.OzonResultSearch;

public class OzonTestCart extends AbstractBasePage{
    @Before
    public void begin(){
        Init.begin(true);
    }
    @After
    public void end(){
        Init.end(false);
    }

    @Test
    public void test (){
        //Init.getDriver().get((String) SingletonForProperties.getInstance().getProperties().get("base.url"));
        OzonBasePage ozon = new OzonBasePage();
        ozon.searchTextInputLine("iphone");
        OzonResultSearch ozonResultSearch = new OzonResultSearch();
        //можем добавлять элемент по номеру вручную
        ozonResultSearch.clickEItemButtonInCart(1);
        //можем добавлять определенное количество
        ozonResultSearch.radomItemToCart(2);
        //а можем вообще случайное число в пределах от до
        ozonResultSearch.radomItemToCart(3,5);
        OzonCart ozonCart = new OzonCart();
        ozonCart.clickCart();
        ozonCart.checkEquals();

        //System.out.println(ozonResultSearch.getRandomElement());


    }
}
