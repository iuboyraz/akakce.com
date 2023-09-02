package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;

    static {
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE); //

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

    }

    public static void DriverQuit()
    {
        Myfunc.wait(5);
        driver.quit();
    }

    public static void Cookies(String element){

        List<WebElement> list = driver.findElements(By.xpath(element));
        if(list.size()>0)
            list.get(0).click();

    }

}
