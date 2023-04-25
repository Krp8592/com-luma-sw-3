package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

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
    public void verifyTheSortByPriceFilter() throws InterruptedException {

        //Mouse Hover on Men Menu
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("//span[normalize-space()='Men']")))
                .build().perform();

        //Mouse Hover on Bottoms
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//span[contains(text(),'Bottoms')])[2]"))).build().perform();

        //Click on Pants
        Thread.sleep(2000);
        actions().moveToElement(element(By.xpath("(//span[contains(text(),'Pants')])[2]"))).click().
                build().perform();


        //Mouse Hover on product name
        //‘Cronus Yoga Pant’ and click on size
        //32.
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//img[@alt='Cronus Yoga Pant '])[1]")))
                .build().perform();
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//div[@id='option-label-size-143-item-175'])[1]")))
                .click().build().perform();

        //Mouse Hover on product name
        //‘Cronus Yoga Pant’ and click on colour
        //Black.
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("//span[normalize-space()='Men']")))
                .build().perform();
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]")))
                .click().build().perform();

        //Mouse Hover on product name
        //‘Cronus Yoga Pant’ and click on colour
        //Black.
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("//a[normalize-space()='Cronus Yoga Pant']")))
                .build().perform();
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//span[contains(text(),'Add to Cart')])[1]")))
                .click().build().perform();

        //Mouse Hover on product name
        //‘Cronus Yoga Pant’ and click on
        //‘Add To Cart’ Button.
        Thread.sleep(5000);

        /**
         * Verify the text
         * ‘You added Cronus Yoga Pant to your shopping cart.’
         */
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        verifyText("Expected text is not displayed", expectedText, actualText);
        //Click on ‘shopping cart’ Link into
        //message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        /**#
         *Verify the text ‘Shopping Cart.’
         */
        expectedText = "Shopping Cart";
        actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        verifyText("Expected message is not displayed", expectedText, actualText);

        /**
         * Verify the product name ‘Cronus Yoga Pant’
         */
        expectedText = "Cronus Yoga Pant";
        actualText = getTextFromElement(By.xpath("//td[@class='col item']" +
                "//strong[@class='product-item-name']"));
        verifyText("Expected message is not displayed", expectedText, actualText);

        /**
         * Verify the product size ‘32’
         */
        expectedText = "32";
        actualText = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        verifyText("Expected text is not displayed", expectedText, actualText);

        /**
         * Verify the product colour ‘Black’
         */
        expectedText = "Black";
        actualText = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        verifyText("Expected message is not displayed", expectedText, actualText);
    }
}
