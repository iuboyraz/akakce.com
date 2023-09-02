package MyTests;

import Db.UserData;
import Helpers.BaseDriver;
import Helpers.Myfunc;
import org.junit.Test;
import java.util.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserStory2 extends BaseDriver {

    public UserStory2() {
        Scenario1();
    }

    @Test
    public void Scenario1() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement accountHover = driver.findElement(By.xpath("//div[@id='HM_v8']/a"));
        new Actions(driver).moveToElement(accountHover).build().perform();

        Myfunc.wait(1);

        WebElement accountVerification = driver.findElement(By.xpath("//li[@id='HM_p_v8']//a"));
        //Assert.assertTrue("Hesap Onaylanamadı !", accountVerification.getText().contains(UserData.name + " " + UserData.surname));
    }
}
