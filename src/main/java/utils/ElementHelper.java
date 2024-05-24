package utils;

import com.beust.jcommander.internal.Lists;
import org.bson.assertions.Assertions;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ElementHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    public String productName;
    public String price;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public void clickElement(By locator) {
        waitDisplayed(locator);
        waitToBeClickable(findElement(locator));
        findElement(locator).click();
    }

    public void clickElementList(By locator, int index) {
        waitToBeClickable(findElements(locator).get(index));
        findElements(locator).get(index).click();
    }
    public void clickElementListRand(By locator) {
        WebElement element = findElements(locator).get(randomInt(locator));
        scrollToElement(element);
        waitBySecond(2);
        element.click();
    }

    public void selectBedenRandom(By by){
        List<WebElement> webElementlist = findElements(by);
        WebElement element = findElements(by).get(randomInt(by));
        for (int i = 0;i<webElementlist.size();i++){
            element.click();
            if (findElement(By.cssSelector(".product-card__action--addToCart"))!=null)
                break;
            else{
                element = findElements(by).get(randomInt(by));
                element.click();
            }
            i++;
        }
    }

    public void sendKeys(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementDislayed(By locator){
        return findElement(locator).isDisplayed();
    }

    public boolean isElementEnabled(By locator){
        return findElement(locator).isEnabled();
    }
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                element);
    }

    public boolean waitDisplayed(By by) {
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            assertFail(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean waitToBeClickable(WebElement by) {
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            assertFail(e.getMessage());
            return false;
        }
        return true;
    }

    public void assertFail(String message) {
        fail(message);
    }


    public void assertionTrue(String message, boolean condition) {
        assertTrue(message, condition);
    }

    public void assertionTrue(boolean condition) {
        assertTrue(condition);
    }

    public void assertionFalse(String message, boolean condition) {
        assertFalse(message, condition);
    }

    public void assertionFalse(boolean condition) {
        assertFalse(condition);
    }

    public void assertionEquals(String message, Object expected, Object actual) {
        assertEquals(message, expected, actual);
    }

    public void assertionNotEquals(String message, Object expected, Object actual) {
        assertNotEquals(message, expected, actual);
    }
    public void hoverElement(By by){
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).perform();
    }

    public void checkElement(By deFactoIcon) {
        assertTrue("Element görünür değil!!",isElementDislayed(deFactoIcon));
    }

    public String getText(By by){
        return findElement(by).getText();
    }

    public int randomInt(By by){
        Random rand = new Random();
        int random;
        List<WebElement> webElements = findElements(by);
        if (!webElements.isEmpty()){
            random =  rand.nextInt(webElements.size());
            return random;
        }
        else
            return -1;
    }
    public void compareText(By by, String text){
        assertionEquals("Textler eşit değil!!",text,getText(by));
    }
    public void waitBySecond(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saveValue(String key, By by){
        ConfigReader.saveProperty(key,findElement(by).getText());
    }
    public String getSavedValue(String key){
        return ConfigReader.getProperty(key);
    }

    public boolean waitDissapear(By by) {
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            fail(e.getMessage());
            return false;
        }
        return true;
    }

    public void comparePriceAndProductName(By priceCart, By productNameCart) {
        String detailPrice = getSavedValue("fiyat").replace("TL","").trim();
        assertTrue(detailPrice.contains(getText(priceCart).replace("TL","").trim()));
        String detailProductName = getSavedValue("urunAdi").trim();
        assertTrue(detailProductName.contains(getText(productNameCart).trim()));
    }
}
