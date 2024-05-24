package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class WomanHomePage {
    ElementHelper elementHelper;

    By giyimKatagori = By.xpath("(//a[@name = 'giyim'])[1]");
    By tumAltKatagoriler = By.cssSelector("ul.menu__sub li.menu__main--item");
    By tisort = By.xpath("(//a[@name = 'tişört'])[1]");


    public WomanHomePage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void selectGiyim() {
        elementHelper.hoverElement(giyimKatagori);
    }

    public void checkAltKatagori() {
        elementHelper.checkElement(tumAltKatagoriler);
    }

    public void clickTisort() {
        elementHelper.clickElement(tisort);
    }
}
