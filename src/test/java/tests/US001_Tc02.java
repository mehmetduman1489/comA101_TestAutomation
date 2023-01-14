package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethods;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static utulities.ReusableMethods.*;


public class US001_Tc02 {
    /*
US001    Kulanici girisi yapılmadan ürün sepete eklenmeli
TC02    Kullanici girisi yapılmadan belirtilen ürünü sepete ekleme

Steps
Kullanici, Arama sonucunda ekrana gelen urun listesinden (veya tek bir sonuc da donmus olabilir) urun secer.
Secilen urun icin 2 tane farkli saticidan urun secilip sepete eklenir.
Secilen urunun dogru olarak eklendigi ‘Sepetim’ sayfasinda dogrulanmalidir.


*/
    private static Logger logger = LogManager.getLogger(US001_Tc02.class.getName());
    HepsiBuradaPage page= new HepsiBuradaPage();


    @Test (groups = {"e2e",""})
    public void us01_Tc02() throws IOException {
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
        getSoftAssert().assertTrue(page.birinciSaticiVerificition.isDisplayed());
        waitFor(5);
        getScreenshot("first_product_screenshot");
        logger.info("ürün sepetim sayfasında doğrulanır");
        Driver.getDriver().switchTo().window(handles.get(0));
        products.get(0).click();
        logger.info("ürüne tekrar tıklanır");
        List<String> newHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(newHandles.get(2));
        getActions().sendKeys(Keys.PAGE_DOWN).perform();
        logger.info("ürün ikinci satıcı için sepete eklenir");
        List<WebElement> ikinciSaticiList = page.ikinciSaticiList;
        ikinciSaticiList.get(0).click();
        page.sepeteGitButton.click();
        getSoftAssert().assertTrue(page.ikinciSaticiVerificition.isDisplayed());
        waitFor(5);
        getScreenshot("second_product_screenshot");
        getSoftAssert().assertAll();
        logger.info("ikinci satici için sepete eklendiği doğrulanır.");
        Driver.quitDriver();
    }
}
