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

public class UserStory7 extends BaseDriver {

    public UserStory7() {
        TestYanlisSifre();
        TestDogruSifre();
    }

    @Test
    public void TestYanlisSifre() {
        Hesabim();

        WebElement delAccountBtn = driver.findElement(By.xpath("//ul[@id='AL']/li[4]/a[4]"));
        delAccountBtn.click();

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='p']"));
        passwordInput.sendKeys("asdasd");

        WebElement delConfirmBtn = driver.findElement(By.xpath("//input[@id='u']"));
        delConfirmBtn.click();

        Myfunc.wait(1);

        WebElement response = driver.findElement(By.xpath("//div[@class='alertX t2']//p"));
        Assert.assertTrue("Şifre doğru girildiği için hesap silindi !!!",response.getText().equals("Mevcut şifrenizi doğru girdiğinizden emin olun."));

        Myfunc.wait(1);

        WebElement responseModal = driver.findElement(By.xpath("//button[@onclick='Modal_v8.close()']"));
        responseModal.click();

        Myfunc.wait(3);
    }

    @Test
    public void TestDogruSifre() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement hesabim= driver.findElement(By.cssSelector("#HM_v8 > i > a"));
        hesabim.click();
        Myfunc.wait(2);

        WebElement delAccountBtn = driver.findElement(By.xpath("//ul[@id='AL']/li[4]/a[4]"));
        delAccountBtn.click();

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='p']"));
        passwordInput.sendKeys(UserData.password);

        WebElement delConfirmBtn = driver.findElement(By.xpath("//input[@id='u']"));
        delConfirmBtn.click();

        WebElement response = driver.findElement(By.xpath("//i[text()='Hesabın silindi.']"));
        Assert.assertTrue("Yanlış şifre girildiği için hesap silinemedi !!!",response.getText().contains("Hesabın silindi."));

        Myfunc.wait(3);

        DriverQuit();
    }

    public void Hesabim() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement loginBtn = driver.findElement(By.xpath("//div[@id='H_rl_v8']/a[2]"));
        loginBtn.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='life']"));
        email.sendKeys(UserData.email);

        WebElement password = driver.findElement(By.xpath("//input[@id='lifp']"));
        password.sendKeys(UserData.password);

        WebElement submitBtn = driver.findElement(By.xpath("//input[@id='lfb']"));
        submitBtn.click();

        WebElement myAccount = driver.findElement(By.xpath("//div[@id='HM_v8']//a"));
        new Actions(driver).moveToElement(myAccount).perform();

        WebElement myAccountBtn = driver.findElement(By.xpath("//li[@id='HM_p_v8']//following::li[3]//a"));
        myAccountBtn.click();
    }
}
