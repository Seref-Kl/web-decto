package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class ProductDetailPage {
    ElementHelper elementHelper;

    By checkDetailPage = By.cssSelector(".product-card__code");
    By sepeteEkle = By.cssSelector(".product-card__action--addToCart");
    By selectBeden = By.cssSelector(".product-size-selector__buttons button");
    By urunAdi = By.cssSelector(".product-card__name");
    By fiyat = By.cssSelector(".product-card__price--new.d-inline-flex.align-items-baseline");
    By sepeteGit = By.cssSelector("a[href='/shopping']");
    By sepetim = By.id("flycartBtn");

    public ProductDetailPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkDetailPage() {
        elementHelper.checkElement(checkDetailPage);
        elementHelper.saveValue("urunAdi",urunAdi);
        System.out.println(elementHelper.getSavedValue("urunAdi"));
        elementHelper.saveValue("fiyat",fiyat);
        System.out.println(elementHelper.getSavedValue("fiyat"));
    }
    public void selectBedenRandom(){
        elementHelper.selectBedenRandom(selectBeden);
    }

    public void addToCard() {
        elementHelper.clickElement(sepeteEkle);
        elementHelper.waitBySecond(3);
        elementHelper.waitDissapear(sepeteGit);
    }

    public void clickCart() {
        elementHelper.clickElement(sepetim);
    }
}
