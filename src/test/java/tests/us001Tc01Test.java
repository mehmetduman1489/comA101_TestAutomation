package tests;



import org.testng.annotations.Test;
import page.HepsiBuradaPage;
import utulities.ConfigReader;
import utulities.Driver;

public class us001Tc01Test {



    @Test

    public void test01(){
        HepsiBuradaPage page= new HepsiBuradaPage();
        Driver.getDriver().get(ConfigReader.getProperty("hepsiUrl"));
    }

}