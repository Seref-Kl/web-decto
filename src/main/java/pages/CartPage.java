package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class CartPage {

    ElementHelper elementHelper;
    By checkSepet = By.cssSelector(".shopping__card");
    By priceCart = By.cssSelector(".shopping-product-card__info--price-new");
    By productNameCart = By.cssSelector(".shopping-product-card__info--title span");
    By deleteProduct = By.cssSelector("a[class = 'product-delete-item mr-2']");
    By delete = By.cssSelector(".delete-button");
    By checkEmptySepet = By.cssSelector(".shopping__empty--title");
    public CartPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);

    }

    public void checkCartPage() {
        elementHelper.checkElement(checkSepet);
        System.out.println(elementHelper.getText(priceCart));
        System.out.println(elementHelper.getText(productNameCart));
        elementHelper.comparePriceAndProductName(priceCart,productNameCart);
    }

    public void deleteButton() {
        elementHelper.waitBySecond(2);
        elementHelper.clickElement(deleteProduct);
        elementHelper.clickElement(delete);
    }

    public void checkEmptyCart() {
        elementHelper.checkElement(checkEmptySepet);
        elementHelper.compareText(checkEmptySepet,"Sepetinizde ürün yok.");
    }
}
