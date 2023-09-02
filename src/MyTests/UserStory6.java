package MyTests;

import Db.UserData;
import Helpers.BaseDriver;
import Helpers.Myfunc;
import org.junit.Test;
import java.util.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserStory6 extends BaseDriver {

    public UserStory6() {
        Test1();
    }

    @Test
    public void Test1() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement hesabim= driver.findElement(By.cssSelector("#HM_v8 > i > a"));
        hesabim.click();
        Myfunc.wait(2);

        WebElement myMessages=driver.findElement(By.xpath("//a[text()='Mesajlarım']"));
        myMessages.click();

        WebElement control=driver.findElement(By.xpath("//p[text()='Listelenecek mesaj bulunamadı.']"));
        Assert.assertTrue("MESAJ EŞLEŞMEDİ",control.getText().contains("Listelenecek mesaj bulunamadı."));
    }
}
