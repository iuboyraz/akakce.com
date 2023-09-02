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

public class UserStory1 extends BaseDriver {

    public UserStory1() {
        NegativeScenario1();
        PositiveScenario();
    }

    @Test
    public void NegativeScenario1() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement NewAccount = driver.findElement(By.cssSelector("[href='/akakcem/giris/?m=1&s=1']"));
        NewAccount.click();
        Myfunc.wait(1);

        WebElement name = driver.findElement(By.xpath("//*[@id='rnufn']"));
        name.sendKeys(UserData.name);
        Myfunc.wait(1);

        WebElement surname = driver.findElement(By.xpath("//*[@id='rnufs']"));
        surname.sendKeys(UserData.surname);
        Myfunc.wait(1);

        WebElement email = driver.findElement(By.xpath("//*[@id='rnufe1']"));
        email.sendKeys(UserData.email);
        Myfunc.wait(1);

        WebElement emailAgain = driver.findElement(By.xpath("//*[@id='rnufe2']"));
        emailAgain.sendKeys(UserData.email);
        Myfunc.wait(1);

        WebElement gender = driver.findElement(By.xpath("//*[@id='rngm']"));
        gender.click();
        Myfunc.wait(1);

        WebElement city = driver.findElement(By.xpath("//*[@id='locpr']"));
        city.click();
        Myfunc.wait(2);

        Select cityDropbox = new Select(city);
        cityDropbox.selectByVisibleText(UserData.city);
        Myfunc.wait(2);

        WebElement country = driver.findElement(By.xpath("//*[@id='locds']"));
        country.click();
        Myfunc.wait(2);

        Select countryBox = new Select(country);
        countryBox.selectByVisibleText(UserData.country);
        Myfunc.wait(2);

        WebElement webDay   = driver.findElement(By.cssSelector("[id='bd']"));
        WebElement webMonth = driver.findElement(By.cssSelector("[id='bm']"));
        WebElement webYear  = driver.findElement(By.cssSelector("[id='by']"));

        Select Day   = new Select(webDay);
        Select Month = new Select(webMonth);
        Select Year  = new Select(webYear);

        Day.selectByVisibleText(UserData.birthday[0]);
        Month.selectByValue(UserData.birthday[1]);
        Year.selectByVisibleText(UserData.birthday[2]);
        Myfunc.wait(1);

        WebElement condition = driver.findElement(By.cssSelector("[id='rnufpca']"));
        condition.click();
        Myfunc.wait(1);

        WebElement openAccount = driver.findElement(By.cssSelector("[id='rfb']"));
        openAccount.click();
        Myfunc.wait(2);

        List<WebElement> msg = driver.findElements(By.linkText("Şifreniz en az 8 karakter uzunluğunda olmalı. İçerisinde büyük harf, küçük harf ve rakam bulunmalı."));

        Assert.assertTrue("Test Tamamlandı", msg.isEmpty());
    }

    @Test
    public void PositiveScenario() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement NewAccount = driver.findElement(By.cssSelector("[href='/akakcem/giris/?m=1&s=1']"));
        NewAccount.click();
        Myfunc.wait(1);

        WebElement name = driver.findElement(By.xpath("//*[@id='rnufn']"));
        name.sendKeys(UserData.name);
        Myfunc.wait(1);

        WebElement surname = driver.findElement(By.xpath("//*[@id='rnufs']"));
        surname.sendKeys(UserData.surname);
        Myfunc.wait(1);

        WebElement email = driver.findElement(By.xpath("//*[@id='rnufe1']"));
        email.sendKeys(UserData.email);
        Myfunc.wait(1);

        WebElement emailAgain = driver.findElement(By.xpath("//*[@id='rnufe2']"));
        emailAgain.sendKeys(UserData.email);
        Myfunc.wait(1);

        WebElement password = driver.findElement(By.xpath("//*[@id='rnufp1']"));
        password.sendKeys(UserData.password);
        Myfunc.wait(1);

        WebElement passwordAgain = driver.findElement(By.xpath("//*[@id='rnufp2']"));
        passwordAgain.sendKeys(UserData.password);
        Myfunc.wait(1);

        WebElement gender = driver.findElement(By.xpath("//*[@id='rngm']"));
        gender.click();
        Myfunc.wait(1);

        WebElement city = driver.findElement(By.xpath("//*[@id='locpr']"));
        city.click();
        Myfunc.wait(1);

        Select cityDropbox = new Select(city);
        cityDropbox.selectByVisibleText(UserData.city);
        Myfunc.wait(1);

        WebElement country = driver.findElement(By.xpath("//*[@id='locds']"));
        country.click();
        Myfunc.wait(1);

        Select countryBox = new Select(country);
        countryBox.selectByVisibleText(UserData.country);
        Myfunc.wait(1);

        WebElement webDay   = driver.findElement(By.cssSelector("[id='bd']"));
        WebElement webMonth = driver.findElement(By.cssSelector("[id='bm']"));
        WebElement webYear  = driver.findElement(By.cssSelector("[id='by']"));

        Select Day   = new Select(webDay);
        Select Month = new Select(webMonth);
        Select Year  = new Select(webYear);

        Day.selectByVisibleText(UserData.birthday[0]);
        Month.selectByValue(UserData.birthday[1]);
        Year.selectByVisibleText(UserData.birthday[2]);
        Myfunc.wait(1);

        WebElement condition = driver.findElement(By.cssSelector("[id='rnufpca']"));
        condition.click();

        WebElement openAccount = driver.findElement(By.cssSelector("[id='rfb']"));
        openAccount.click();

        Myfunc.wait(5);

        Assert.assertEquals(UserData.url, driver.getCurrentUrl());
    }
}
