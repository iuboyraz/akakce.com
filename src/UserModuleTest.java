import Db.UserData;
import Helpers.BaseDriver;
import Helpers.Myfunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserModuleTest extends BaseDriver {
    @Test
    public void US1NegativeScenario1() {
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
        Myfunc.wait(5);

        List<WebElement> msg = driver.findElements(By.linkText("Şifreniz en az 8 karakter uzunluğunda olmalı. İçerisinde büyük harf, küçük harf ve rakam bulunmalı."));

        Myfunc.wait(2);

        Assert.assertTrue("Test Tamamlandı", msg.isEmpty());
    }

    @Test
    public void US1PositiveScenario() {
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

    @Test
    public void US2PositiveScenario1() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement accountHover = driver.findElement(By.xpath("//div[@id='HM_v8']/a"));
        new Actions(driver).moveToElement(accountHover).build().perform();

        Myfunc.wait(1);

        WebElement accountVerification = driver.findElement(By.xpath("//li[@id='HM_p_v8']//a"));
        Assert.assertTrue("Hesap Onaylanamadı !", accountVerification.getText().contains(UserData.name + " " + UserData.surname));
    }

    @Test
    public void US5PositiveScenario() {
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

    @Test
    public void US6PositiveScenario() {
        driver.get(UserData.url);
        Myfunc.wait(5);

        WebElement myMessages=driver.findElement(By.xpath("//a[text()='Mesajlarım']"));
        myMessages.click();

        WebElement control=driver.findElement(By.xpath("//p[text()='Listelenecek mesaj bulunamadı.']"));
        Assert.assertTrue("MESAJ EŞLEŞMEDİ",control.getText().contains("Listelenecek mesaj bulunamadı."));
    }

    @Test
    public void US3PositiveScenario() {
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

    @Test
    public void US4NegativeScenario1() {
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
    public void US4NegativeScenario2() {
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
    public void US4NegativeScenario3() {
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
    public void US4PositiveScenario() {
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

    public void US7Login() {
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

    @Test
    public void US7NegativeScenario() {
        US7Login();

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
    public void US7PositiveScenario() {
        US7Login();

        WebElement delAccountBtn = driver.findElement(By.xpath("//ul[@id='AL']/li[4]/a[4]"));
        delAccountBtn.click();

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='p']"));
        passwordInput.sendKeys(UserData.password);

        WebElement delConfirmBtn = driver.findElement(By.xpath("//input[@id='u']"));
        delConfirmBtn.click();

        WebElement response = driver.findElement(By.xpath("//i[text()='Hesabın silindi.']"));
        Assert.assertTrue("Yanlış şifre girildiği için hesap silinemedi !!!",response.getText().contains("Hesabın silindi."));

        Myfunc.wait(3);
    }
}
