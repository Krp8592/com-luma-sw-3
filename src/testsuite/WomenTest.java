package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {

        //Mouse Hover on Women Menu
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//span[normalize-space()='Women'])[1]")))
                .build().perform();
        Thread.sleep(1000);
        //Mouse Hover on Tops
        actions().moveToElement(element(By.xpath("(//span[contains(text(),'Tops')])[1]"))).build().perform();
        Thread.sleep(2000);
        //Click on Jackets
        actions().moveToElement(element(By.xpath("(//span[contains(text(),'Jackets')])[1]"))).click().
                build().perform();

        /**
         * Verify the products name display in alphabetical order
         */
        List<WebElement> productsBeforeSorting = driver.findElements(By.xpath("//strong[@class = " +
                "'product name product-item-name']"));
        List<String> expectedProductsNames = new ArrayList<>();

        for (WebElement element : productsBeforeSorting) {
            expectedProductsNames.add(element.getText());
        }

        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//select[@id='sorter'])[1]"))).click()
                .build().perform();
        Thread.sleep(1000);
        selectByVisibleText(By.xpath("(//select[@id='sorter'])[1]"), "Product Name");

        List<WebElement> productsAfterSorting = driver.findElements(By.xpath("//strong[@class = " +
                "'product name product-item-name']"));
        List<String> actualProductsNames1 = new ArrayList<>();

        for (WebElement element1 : productsAfterSorting) {
            actualProductsNames1.add(element1.getText());
        }

        expectedProductsNames.sort(String.CASE_INSENSITIVE_ORDER);

        verifyText("Products are not sorted to alphabetical order",
                expectedProductsNames.toString(), actualProductsNames1.toString());

    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {

        //Mouse Hover on Women Menu
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//span[normalize-space()='Women'])[1]")))
                .build().perform();
        Thread.sleep(1000);
        //Mouse Hover on Tops
        actions().moveToElement(element(By.xpath("(//span[contains(text(),'Tops')])[1]"))).build().perform();
        Thread.sleep(2000);
        //Click on Jackets
        actions().moveToElement(element(By.xpath("(//span[contains(text(),'Jackets')])[1]"))).click().
                build().perform();

        /**
         * Verify the products name display in alphabetical order
         */
        List<WebElement> priceBeforeSorting = driver.findElements(By.xpath("//span[@class='price']" +
                "/parent::span[@class = 'price-wrapper ']"));
        List<Double> expectedPrice = new ArrayList<>();

        for (WebElement element : priceBeforeSorting) {
            expectedPrice.add(Double.valueOf(element.getText().replace("$", "")));
        }

        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//select[@id='sorter'])[1]"))).click()
                .build().perform();
        Thread.sleep(1000);
        selectByVisibleText(By.xpath("(//select[@id='sorter'])[1]"), "Price");

        List<WebElement> priceAfterSorting = driver.findElements(By.xpath("//span[@class='price']" +
                "/parent::span[@class = 'price-wrapper ']"));
        List<Double> actualPrice = new ArrayList<>();

        for (WebElement element : priceAfterSorting) {

            actualPrice.add(Double.parseDouble(element.getText().replace("$", "")));
        }

        Collections.sort(expectedPrice);

        Assert.assertEquals("Prices are not displayed as per sorting order", expectedPrice, actualPrice);
    }


}
