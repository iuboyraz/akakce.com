package MyTests;

import Helpers.BaseDriver;
import Helpers.Myfunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FullStories extends BaseDriver {
    @Test
    public void full()
    {
        driver.get("https://www.akakce.com");
        Myfunc.wait(1);
        WebElement hesapAc = driver.findElement(By.xpath("(//a[text()='Hesap Aç'])[1]"));
        hesapAc.click();
        Myfunc.wait(1);

        WebElement hesapAcdogrulama = driver.findElement(By.xpath("(//h2[text()='Devam etmek için hesap aç'])"));
        System.out.println(hesapAcdogrulama.getText());

        Myfunc.wait(1);
        Assert.assertTrue("Hesap Ac dogrulamamadi !", hesapAcdogrulama.getText().contains("hesap"));

        WebElement ad = driver.findElement(By.cssSelector("[id='rnufn'][name='rnufn']"));
        ad.sendKeys("Ayse");
        Myfunc.wait(1);

        WebElement soyad = driver.findElement(By.cssSelector("[id='rnufs'][name='rnufs']"));
        soyad.sendKeys("Simsek");
        Myfunc.wait(1);

        WebElement eposta = driver.findElement(By.cssSelector("[id='rnufe1'][name='rnufe1']"));
        eposta.sendKeys("Ayse_aysee2@gmail.com");
        Myfunc.wait(1);

        WebElement etekrar = driver.findElement(By.cssSelector("[id='rnufe2'][name='rnufe2']"));
        etekrar.sendKeys("Ayse_aysee2@gmail.com");
        Myfunc.wait(1);

        WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
        password.sendKeys("Ayse12345");
        Myfunc.wait(1);

        WebElement pass_tekrar = driver.findElement(By.xpath("(//input[@type='password'])[3]"));
        pass_tekrar.sendKeys("Ayse12345");
        Myfunc.wait(1);

        WebElement secimGenderK = driver.findElement(By.xpath("//input[@type='radio' and @id='rngf']"));
        secimGenderK.click();
        Myfunc.wait(1);

        WebElement secimGenderE = driver.findElement(By.xpath("//input[@type='radio' and @id='rngm']"));
        Myfunc.wait(1);

        Assert.assertTrue(secimGenderK.isSelected());
        Assert.assertFalse(secimGenderE.isSelected());

        WebElement city = driver.findElement(By.xpath("//select[@id='locpr' and @name='locpr']"));
        Select select = new Select(city);
        select.selectByValue("1");
        Myfunc.wait(2);
        Assert.assertTrue(city.isDisplayed());
        Assert.assertTrue(city.getText().contains("Ada"));

        WebElement district = driver.findElement(By.xpath("//select[@id='locds' and @name='locds']"));
        Select select2 = new Select(district);
        select2.selectByVisibleText("Karataş");
        Myfunc.wait(2);
        Assert.assertTrue(district.isDisplayed());
        Assert.assertTrue(district.getText().contains("taş"));

        WebElement gunler = driver.findElement(By.cssSelector("select[id='bd'][name='bd']"));
        Select select3 = new Select(gunler);
        select3.selectByIndex(18);
        Myfunc.wait(2);
        Assert.assertTrue(gunler.isDisplayed());

        WebElement aylar = driver.findElement(By.cssSelector("select[id='bm'][name='bm']"));
        Select select4 = new Select(aylar);
        select4.selectByIndex(4);
        Myfunc.wait(2);

        Assert.assertTrue(aylar.isDisplayed());
        Assert.assertTrue(aylar.getText().contains("4"));

        WebElement yillar = driver.findElement(By.cssSelector("select[id='by'][name='by']"));
        Select select5 = new Select(yillar);
        select5.selectByVisibleText("2000");
        Myfunc.wait(2);
        Assert.assertTrue(aylar.isDisplayed());

        WebElement kk = driver.findElement(By.xpath("//input[@name='rnufpca']"));
        kk.click();
        Myfunc.wait(2);

        WebElement hesapAcildi = driver.findElement(By.xpath("//input[@id='rfb']"));
        hesapAcildi.click();
        Myfunc.wait(2);

        Actions actionss = new Actions(driver);

        WebElement logout1 = driver.findElement(By.xpath("//*[@id=\"HM_v8\"]/i/a")); //  //a[text()='Çık']
        actionss.moveToElement(logout1).build().perform();
        Myfunc.wait(2);
        WebElement logcikis = driver.findElement(By.xpath("//*[@id=\"HM_v8\"]/ul/li[5]/a")); // //a[@id='H_a_v8']
        logcikis.click();

        WebElement girisyap1=driver.findElement(By.xpath("//*[@id=\"H_rl_v8\"]/a[2]"));
        girisyap1.click();
        Myfunc.wait(2);

        WebElement girismail=driver.findElement(By.cssSelector("input[class='t'][id='life'][type='email']"));
        girismail.sendKeys("Ayse_aysee2@gmail.com");
        WebElement girissifre=driver.findElement(By.cssSelector("input[class='t'][id='lifp'][type='password']"));
        girissifre.sendKeys("Ayse12345");
        Myfunc.wait(2);
        WebElement submitf=driver.findElement(By.cssSelector("input[value='Giriş yap'][id='lfb'][type='submit']"));
        submitf.click();
        Myfunc.wait(2);

        //Hesap Dogrulama---

        WebElement hesapVerify = driver.findElement(By.xpath("//a[@rel='nofollow']"));
        hesapVerify.click();
        Myfunc.wait(2);

        WebElement hesapD = driver.findElement(By.xpath("//span[@class='welcome_user']"));
        Myfunc.wait(2);
        System.out.println(hesapD.getText());
        Assert.assertTrue(hesapD.getText().contains("Ay"));

        WebElement hesapD2 = driver.findElement(By.xpath("//i[@title='Ayse S.']"));
        Myfunc.wait(2);
        System.out.println(hesapD2.getText());
        Assert.assertTrue(hesapD2.getText().contains("AS"));

        Myfunc.wait(2);

        Actions actions = new Actions(driver);
        WebElement logout = driver.findElement(By.cssSelector("a[title='Hesabım'][id='H_a_v8']"));
        actions.moveToElement(logout).build().perform();
        Myfunc.wait(2);
        WebElement log = driver.findElement(By.xpath("//a[text()='Çık']"));
        log.click();
        Myfunc.wait(2);

        //Giris sayfasinda miyiz?

        Assert.assertTrue(driver.getCurrentUrl().contains("giris"));
        System.out.println("Giris sayfasindayiz !");

        //Giris yap butonu gozukuyor mu ?
        WebElement girisYapButton = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        Assert.assertTrue(girisYapButton.isDisplayed());

        //Giris yap butonu tiklanabilir mi?
        Assert.assertTrue(girisYapButton.isEnabled());

        //Sifremi unuttum linki tiklanabiliyor mu ?
        WebElement sifremiUnuttum = driver.findElement(By.xpath("//a[text()='Şifremi unuttum']"));
        Assert.assertTrue(sifremiUnuttum.isDisplayed());
        Assert.assertTrue(sifremiUnuttum.isEnabled());

        //Test1 :  dogru e-mail dogru password
        WebElement mail = driver.findElement(By.xpath("//input[@name='life']"));

        mail.sendKeys("Ayse_aysee2@gmail.com");

        WebElement sifre = driver.findElement(By.xpath("//input[@name='lifp']"));
        sifre.sendKeys("Ayse12345");

        girisYapButton.click();
        Myfunc.wait(2);

        WebElement log1 = driver.findElement(By.xpath("//a[text()='Çık']"));
        WebElement logout2 = driver.findElement(By.cssSelector("a[title='Hesabım'][id='H_a_v8']"));
        actions.moveToElement(logout2).build().perform();
        Myfunc.wait(2);
        log1.click();

        //Test2 : bos e-mail bos password
        WebElement mail1 = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement sifre1 = driver.findElement(By.xpath("//input[@name='lifp']"));
        mail1.sendKeys("");
        sifre1.sendKeys("");


        WebElement girisYapButton2 = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        girisYapButton2.click();

        Myfunc.wait(1);

        WebElement uyari = driver.findElement(By.xpath("//p[text()='Lütfen e-posta adresinizi yazın.']"));
        Assert.assertTrue(uyari.getText().contains("e-posta adresinizi yazın"));
        Assert.assertTrue(uyari.isDisplayed());

        WebElement tamam = driver.findElement(By.xpath("//*[@id=\"m-w\"]/div/div[2]/div/div/button/b"));
        tamam.click();
        mail1.clear();
        sifre1.clear();

        Myfunc.wait(1);

        //Test3 : yanlis e-mail yanlis password
        WebElement mail2 = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement sifre2 = driver.findElement(By.xpath("//input[@name='lifp']"));
        mail2.sendKeys("Ayse@gmail.com");
        sifre2.sendKeys("ayse123");

        WebElement girisYapButton3 = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        girisYapButton3.click();

        Myfunc.wait(2);
        WebElement uyari2 = driver.findElement(By.xpath("//p[text()='Şifre doğru değil. Lütfen kontrol edip yeniden deneyin.']"));
        Myfunc.wait(2);
        Assert.assertTrue(uyari2.isDisplayed());
        Assert.assertTrue(uyari2.getText().contains("doğru değil"));

        WebElement tamam1 = driver.findElement(By.xpath("//*[@id=\"m-w\"]/div/div[2]/div/div/button/b"));
        tamam1.click();
        mail2.clear();
        sifre2.clear();

        Myfunc.wait(1);

        //Test 4 : dogru e-mail yanlis password
        WebElement mail3 = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement sifre3 = driver.findElement(By.xpath("//input[@name='lifp']"));

        mail3.sendKeys("Ayse_aysee2@gmail.com");
        sifre3.sendKeys("ayse");

        WebElement girisYapButton4 = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        girisYapButton4.click();

        Myfunc.wait(2);
        WebElement uyari3 = driver.findElement(By.xpath("//p[text()='Şifre doğru değil. Lütfen kontrol edip yeniden deneyin.']"));
        Myfunc.wait(2);
        Assert.assertTrue(uyari3.isDisplayed());
        Assert.assertTrue(uyari3.getText().contains("Şifre doğru değil."));
        WebElement tamam2 = driver.findElement(By.xpath("//*[@id=\"m-w\"]/div/div[2]/div/div/button/b"));
        tamam2.click();
        mail3.clear();
        sifre3.clear();

        Myfunc.wait(1);

        // Test 5 : yanlis e-mail dogru password
        WebElement mail4 = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement sifre4 = driver.findElement(By.xpath("//input[@name='lifp']"));
        mail4.sendKeys("Ayse_simsek@gmail.com");
        sifre4.sendKeys("Ayse12345");

        Myfunc.wait(2);

        WebElement girisYapButton5 = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        girisYapButton5.click();

        Myfunc.wait(2);
        WebElement uyari4 = driver.findElement(By.xpath("//p[text()='Böyle bir kullanıcı yok.']"));
        Myfunc.wait(2);
        Assert.assertTrue(uyari4.isDisplayed());
        Assert.assertTrue(uyari4.getText().contains("kullanıcı yok"));

        WebElement tamam3 = driver.findElement(By.xpath("//*[@id=\"m-w\"]/div/div[2]/div/div/button/b"));
        tamam3.click();
        mail4.clear();
        sifre4.clear();

        Myfunc.wait(1);

        //Test 6 : dogru e-mail dogru password fakat Giris Yap a tiklanmadi
        WebElement mail5 = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement sifre5 = driver.findElement(By.xpath("//input[@name='lifp']"));

        mail5.sendKeys("Ayse_aysee2@gmail.com");
        sifre5.sendKeys("Ayse12345");

        Myfunc.wait(1);
        mail5.clear();
        sifre5.clear();

        Myfunc.wait(1);

        //Test 7 : e-mail bos password bos fakat Giris Yap a tiklandi.
        WebElement mail6 = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement sifre6 = driver.findElement(By.xpath("//input[@name='lifp']"));

        mail6.sendKeys("");
        sifre6.sendKeys("");

        WebElement girisYapButton6 = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        girisYapButton6.click();

        Myfunc.wait(2);

        WebElement uyari5 = driver.findElement(By.xpath("//p[text()='Lütfen e-posta adresinizi yazın.']"));
        Myfunc.wait(2);
        Assert.assertTrue(uyari5.isDisplayed());
        Assert.assertTrue(uyari5.getText().contains("e-posta adresinizi yazın."));
        Myfunc.wait(2);

        WebElement tamam4 = driver.findElement(By.xpath("//*[@id=\"m-w\"]/div/div[2]/div/div/button/b"));
        tamam4.click();

        mail6.clear();
        sifre6.clear();

        Myfunc.wait(1);

        //Test 8 : email bos password bos giris yap a tiklanmadi
        WebElement mail7 = driver.findElement(By.xpath("//input[@name='life']"));
        WebElement sifre7 = driver.findElement(By.xpath("//input[@name='lifp']"));

        mail7.sendKeys("");
        sifre7.sendKeys("");
        Myfunc.wait(2);

        mail7.clear();
        sifre7.clear();

        Assert.assertTrue("Giris yapildi", driver.getCurrentUrl().contains("giris"));

        //Test1 :  dogru e-mail dogru password
        WebElement maildogru = driver.findElement(By.xpath("//input[@name='life']"));

        maildogru.sendKeys("Ayse_aysee2@gmail.com");

        String pass="Ayse12345";
        WebElement sifredogru = driver.findElement(By.xpath("//input[@name='lifp']"));
        sifredogru.sendKeys(pass);

        WebElement girisYapButton7 = driver.findElement(By.xpath("(//input[@class='s'])[3]"));
        girisYapButton7.click();

        Myfunc.wait(2);

        WebElement logout3 = driver.findElement(By.cssSelector("a[title='Hesabım'][id='H_a_v8']"));
        actions.moveToElement(logout3).build().perform();
        Myfunc.wait(2);

        WebElement hesabm = driver.findElement(By.xpath("//a[text()='Hesabım']"));
        hesabm.click();

        Myfunc.wait(1);

        //Siparişlerim
        WebElement sipL = driver.findElement(By.xpath("//a[text()='Siparişlerim']"));
        sipL.click();
        Myfunc.wait(1);

        WebElement kayitliSip = driver.findElement(By.xpath("//div[text()='Kayıtlı siparişiniz bulunmuyor.']"));
        Myfunc.wait(1);
        Assert.assertTrue("Siparis vardir", kayitliSip.getText().contains("bulunmuyor"));

        driver.navigate().back();
        Myfunc.wait(1);

        WebElement mesajlarım = driver.findElement(By.xpath("//a[text()='Mesajlarım']"));
        mesajlarım.click();
        Myfunc.wait(1);

        WebElement mesjList = driver.findElement(By.xpath("//p[text()='Listelenecek mesaj bulunamadı.']"));
        Myfunc.wait(1);
        Assert.assertTrue("Siparis vardir", mesjList.getText().contains("bulunamadı."));

        Myfunc.wait(1);

        driver.navigate().back();
        WebElement delete = driver.findElement(By.xpath("//a[text()='Hesabımı Sil']"));
        delete.click();
        Myfunc.wait(1);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.akakce.com/akakcem/kullanici-bilgilerim/uyelik-iptali/"));
        Myfunc.wait(1);

        WebElement deleteAccount=driver.findElement(By.cssSelector("input[class='t'][id='p'][type='password']"));
        deleteAccount.sendKeys(pass);
        Myfunc.wait(1);

        WebElement hesabiSil=driver.findElement(By.cssSelector("input[class='s save button'][id='u'][type='submit']"));
        hesabiSil.click();
        Myfunc.wait(3);

        Assert.assertTrue(driver.getCurrentUrl().contains("iptal-tamamlandi"));

        String message = "Hesabın silindi.";

        //NOT : HESAP SILINIRSE YENI MAILLER VE YENI HESAP TEKRSR TANITILMALI YOKSA HATA VERIR!

        Assert.assertTrue(driver.getTitle().contains("Akakçe"));

        Myfunc.wait(2);

    }
}
