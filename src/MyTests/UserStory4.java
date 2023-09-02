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
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class UserStory4 extends BaseDriver {

    public UserStory4() {
        NegativeScenario1();
        NegativeScenario2();
        NegativeScenario3();
        PositiveScenario();
    }

    @Test
    public void NegativeScenario1() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement loginLink = driver.findElement(By.xpath("//div[@id='H_rl_v8']/a[2]"));
        loginLink.click();
        Myfunc.wait(3);

        WebElement email = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='lifp']"));

        email.sendKeys(UserData.email);
        password.sendKeys("ayse123");

        WebElement loginBtn = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        loginBtn.click();
        Myfunc.wait(3);

        WebElement response = driver.findElement(By.xpath("//p[text()='Şifre doğru değil. Lütfen kontrol edip yeniden deneyin.']"));
        Assert.assertTrue(response.getText().contains("doğru değil"));

        Myfunc.wait(3);
    }

    @Test
    public void NegativeScenario2() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement loginLink = driver.findElement(By.xpath("//div[@id='H_rl_v8']/a[2]"));
        loginLink.click();
        Myfunc.wait(3);

        WebElement email = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='lifp']"));

        email.sendKeys(UserData.email);

        WebElement loginBtn = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        loginBtn.click();
        Myfunc.wait(3);

        WebElement response = driver.findElement(By.xpath("//p[text()='Lütfen şifrenizi yazın.']"));
        Assert.assertTrue(response.getText().contains("şifrenizi yazın."));

        Myfunc.wait(3);
    }

    @Test
    public void NegativeScenario3() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement loginLink = driver.findElement(By.xpath("//div[@id='H_rl_v8']/a[2]"));
        loginLink.click();
        Myfunc.wait(3);

        WebElement email = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='lifp']"));

        email.sendKeys("qqq@qq.com");
        password.sendKeys("asdasd");

        WebElement loginBtn = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        loginBtn.click();
        Myfunc.wait(3);

        WebElement response = driver.findElement(By.xpath("//p[text()='Böyle bir kullanıcı yok.']"));
        Assert.assertTrue(response.getText().contains("kullanıcı yok."));

        Myfunc.wait(3);
    }

    @Test
    public void PositiveScenario() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement loginLink = driver.findElement(By.xpath("//div[@id='H_rl_v8']/a[2]"));
        loginLink.click();

        Myfunc.wait(3);

        WebElement email = driver.findElement(By.xpath("//input[@name='life']"));
        email.sendKeys(UserData.email);

        WebElement password = driver.findElement(By.xpath("//input[@name='lifp']"));
        password.sendKeys(UserData.password);

        WebElement loginBtn = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        loginBtn.click();
        Myfunc.wait(3);

        Assert.assertTrue("Giriş Başarısız", driver.getCurrentUrl().equals(UserData.url));

        Myfunc.wait(3);
    }
}
