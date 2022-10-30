package page;

import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class HepsiBuradaPage {
    public HepsiBuradaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

