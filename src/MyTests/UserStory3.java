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

public class UserStory3 extends BaseDriver {

    public UserStory3() {
        PositiveScenario();
    }

    @Test
    public void PositiveScenario() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        Myfunc.wait(1);

        Actions actions = new Actions(driver);

        WebElement logout = driver.findElement(By.cssSelector("a[title='Hesabım'][id='H_a_v8']"));
        actions.moveToElement(logout).build().perform();
        Myfunc.wait(2);

        WebElement logoutBtn = driver.findElement(By.xpath("//a[text()='Çık']"));
        logoutBtn.click();
        Myfunc.wait(5);

        Assert.assertTrue("Çıkış Yapılamadı!", driver.getCurrentUrl().contains("https://www.akakce.com"));

        Myfunc.wait(5);
    }
}
