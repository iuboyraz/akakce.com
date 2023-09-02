package MyTests;

import Db.UserData;
import Helpers.BaseDriver;
import Helpers.Myfunc;
import org.junit.Test;
import java.util.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserStory5 extends BaseDriver {
    public UserStory5() {
        PositiveScenario();
    }

    @Test
    public void PositiveScenario() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        /*
        WebElement girisClick = driver.findElement(By.xpath("//*[contains(text(), 'Giriş Yap')]"));
        girisClick.click();
        Myfunc.wait(2);

        WebElement enterToAccount= driver.findElement(By.xpath("//*[@id='life']"));
        enterToAccount.sendKeys(UserData.email);
        Myfunc.wait(2);

        WebElement enterPassword= driver.findElement(By.xpath("//*[@id='lifp']"));
        enterPassword.sendKeys(UserData.password);
        Myfunc.wait(2);

        WebElement enterGiris= driver.findElement(By.xpath("//*[@id='lfb']"));
        enterGiris.click();
        Myfunc.wait(2);*/

        WebElement hesabim= driver.findElement(By.cssSelector("#HM_v8 > i > a"));
        hesabim.click();
        Myfunc.wait(2);

        WebElement siparislerim= driver.findElement(By.cssSelector("#AL > li.order.first > a:nth-child(2)"));
        siparislerim.click();
        Myfunc.wait(2);

        WebElement mesajKutusu= driver.findElement(By.xpath("//*[@id=\"user-order-info\"]/div"));

        Assert.assertTrue("Mesaj kutusu boş değil", mesajKutusu.getText().contains("Kayıtlı siparişiniz bulunmuyor."));
    }
}
