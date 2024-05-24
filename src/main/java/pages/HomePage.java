package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class HomePage {

    ElementHelper elementHelper;

    By deFactoIcon = By.name("DeFacto");
    By kadinButton = By.cssSelector("a[href = '/kadin'] div");


    public HomePage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }


    public void checkDeFactoIcon() {
        elementHelper.checkElement(deFactoIcon);
    }

    public void checkKadinButton() {
        elementHelper.checkElement(kadinButton);
    }

    public void clickKadinButton() {
        elementHelper.clickElement(kadinButton);
    }
}
