package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class WomanTshirtPage {
    ElementHelper elementHelper;
    By checkAltKatagoriPage = By.cssSelector("h1[title = 'Kadın Tişört']");
    By sBeden = By.xpath("//*[@id=\"catalog-filter__nav\"]//input[@id = 'fx_s-3']/parent::div");
    By checkedSBeden = By.xpath("//*[@id=\"product-container\"]//a[2]");
    By productList = By.cssSelector("div[class='product-card'] .image-box");
    public WomanTshirtPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkAltKatagoriPage() {
        elementHelper.checkElement(checkAltKatagoriPage);
    }
    public void clickSBeden(){
        elementHelper.waitBySecond(2);
        elementHelper.scrollToElement(elementHelper.findElement(sBeden));
        elementHelper.waitBySecond(2);
        elementHelper.clickElement(sBeden);
    }
    public void checkSelectSBeden() {
        elementHelper.waitBySecond(2);
        elementHelper.compareText(checkedSBeden, "S");
    }
    public void randomSelectProduct(){
        elementHelper.clickElementListRand(productList);
    }
}
