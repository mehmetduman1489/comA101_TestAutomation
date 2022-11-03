package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US001_Tc02 {
    /*
US001    Kulanici girisi yapılmadan ürün sepete eklenmeli
TC02    Kullanici girisi yapılmadan belirtilen ürünü sepete ekleme

Steps
Kullanici, Arama sonucunda ekrana gelen urun listesinden (veya tek bir sonuc da donmus olabilir) urun secer.
Secilen urun icin 2 tane farkli saticidan urun secilip sepete eklenir.
Secilen urunun dogru olarak eklendigi ‘Sepetim’ sayfasinda dogrulanmalidir.


*/
    private static Logger logger = LogManager.getLogger(US001_Tc01.class.getName());
    HepsiBuradaPage page= new HepsiBuradaPage();


    @Test
    public void us01_Tc02() {
        page = new HepsiBuradaPage();
        Driver.getDriver().get(ConfigReader.getProperty("hepsiUrl"));
        logger.info("Hepsi Burada ana sayfasina gidilir");
        ReusableMethods.waitForClickablility(page.acceptButton, 10);
        page.acceptButton.click();
        page.searcButton.sendKeys("lenova ideapad 3", Keys.ENTER);
        logger.info("ürün araması yapılır");
        List<WebElement> products = page.productList;
        products.get(0).click();
        logger.info("ilk ürüne tıklanır");
        List<String> handles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(handles.get(1));
        page.sepeteEkleButton.click();
        logger.info("ürün birinci satıcı için sepete eklenir");
        page.sepeteGitButton.click();
        Assert.assertTrue(page.birinciSaticiVerificition.isDisplayed());
        logger.info("ürün sepetim sayfasında doğrulanır");
        Driver.getDriver().switchTo().window(handles.get(0));
        products.get(0).click();
        logger.info("ürüne tekrar tıklanır");
        List<String> newHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(newHandles.get(2));
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        logger.info("ürün ikinci satıcı için sepete eklenir");
        List<WebElement> ikinciSaticiList = page.ikinciSaticiList;
        ikinciSaticiList.get(0).click();
        page.sepeteGitButton.click();
        Assert.assertTrue(page.ikinciSaticiVerificition.isDisplayed());
        logger.info("ikinci satici için sepete eklendiği doğrulanır.");
        Driver.quitDriver();
    }
}
