package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HepsiBuradaPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class us001Test {


    private static Logger logger = LogManager.getLogger(us001Test.class.getName());
    HepsiBuradaPage page;



    @Test(priority = 1)

    public void us01_Tc01() {
        page = new HepsiBuradaPage();
        Driver.getDriver().get(ConfigReader.getProperty("hepsiUrl"));
        logger.info("Hepsi Burada ana sayfasina gidilir");
        ReusableMethods.waitForClickablility(page.acceptButton, 10);
        page.acceptButton.click();
        ReusableMethods.getActions().moveToElement(page.girisActionButton).perform();
        page.girisYapButton.click();
        page.emailSend.sendKeys("mehmetduman8914@hotmail.com", Keys.ENTER);
        page.sifreSend.sendKeys("Test12345.", Keys.ENTER);
        logger.info("User girisi yapilir");
        Assert.assertTrue(page.userVerification.isDisplayed());
        logger.info("User giris dogrulamasi yapilir");
        page.searcButton.sendKeys("laptop", Keys.ENTER);
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
        List<String> newHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(newHandles.get(2));
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        logger.info("ilk ürüne tekrar tıklanır");
        List<WebElement> ikinciSaticiList = page.ikinciSaticiList;
        ikinciSaticiList.get(0).click();
        page.sepeteGitButton.click();
        Assert.assertTrue(page.ikinciSaticiVerificition.isDisplayed());



    }
    @Test(priority = 2)
    public void us01_Tc02() {

    }
}