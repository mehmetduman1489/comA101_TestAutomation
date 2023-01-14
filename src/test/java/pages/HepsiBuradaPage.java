package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

import java.util.List;

public class HepsiBuradaPage {
    public HepsiBuradaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




    @FindBy(xpath = "//*[text()='Kabul Et']")
    public WebElement acceptButton;

    @FindBy(xpath = "//span[text()='Giriş Yap']")
    public WebElement girisActionButton;

    @FindBy(xpath = "//*[@id='login']")
    public WebElement girisYapButton;

    @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement emailSend;

    @FindBy(xpath = "//*[@id='txtPassword']")
    public WebElement sifreSend;

    @FindBy(xpath = "//*[text()='Mehmet Duman']")
    public WebElement userVerification;

    @FindBy(xpath = "//*[@placeholder='Ürün, kategori veya marka ara']")
    public WebElement searcButton;

    @FindBy(xpath = "//li[@class='productListContent-zAP0Y5msy8OHn5z7T_K_']")
    public List<WebElement> productList;

    @FindBy(xpath = "//*[@class='button big with-icon']")
    public WebElement sepeteEkleButton;

    @FindBy(xpath = "//*[text()='Sepete git']")
    public WebElement sepeteGitButton;
    @FindBy(xpath = "//*[text()='Lenovo IdeaPad 3 Intel Core i5 1135G7 8GB 512GB SSD Freedos 15.6\" FHD Taşınabilir Bilgisayar 82H8020BTX']")
    public WebElement birinciSaticiVerificition;

    @FindBy(xpath = "//*[@class='add-to-basket button small']")
    public List<WebElement>  ikinciSaticiList;

    @FindBy(xpath = "//*[text()='Lenovo IdeaPad 3 Intel Core i5 1135G7 8GB 512GB SSD Freedos 15.6\" FHD Taşınabilir Bilgisayar 82H8020BTX']")
    public WebElement ikinciSaticiVerificition;

    @FindBy(xpath = "//*[@id='btnLogin']")
    public WebElement login1Button;
}


