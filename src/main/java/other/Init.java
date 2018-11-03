package other;

import helpers.ReportHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Init {
    static WebDriver driver;

    public static WebDriver getDriver (){
        return driver;
    }

    public static void begin(boolean maximaze){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        if (maximaze) driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get((String) SingletonForProperties.getInstance().getProperties().get("base.url"));


    }

    public static void end (boolean close){

        if (close) driver.close();


    }

}
