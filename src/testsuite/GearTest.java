package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

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
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        //Mouse Hover on Gear Menu
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("//span[normalize-space()='Gear']")))
                .build().perform();

        //Click on Bags
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("//span[normalize-space()='Bags']")))
                .click().build().perform();

        //Click on Product Name ‘Overnight Duffle’
        Thread.sleep(1000);
        actions().moveToElement(element(By.xpath("(//img[@alt='Overnight Duffle'])[1]")))
                .click().build().perform();
        Thread.sleep(5000);

        /**
         * Verify the text ‘Overnight Duffle’
         */
        String expectedText = "Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        verifyText("Expected text is not displayed", expectedText, actualText);

        //Change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");

        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));

        /**
         * Verify the text
         * ‘You added Overnight Duffle to your shopping cart.’
         */
        Thread.sleep(5000);
        expectedText = "You added Overnight Duffle to your shopping cart.";
        actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        verifyText("Expected text is not displayed", expectedText, actualText);

        //Click on ‘shopping cart’ Link into
        //message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        /**
         * Verify the product name ‘Overnight Duffle’
         */
        Thread.sleep(5000);
        expectedText = "Overnight Duffle";
        actualText = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        verifyText("Expected text is not displayed", expectedText, actualText);

        /**
         * Verify the product price ‘$135.00’
         */
        expectedText = "$135.00";
        actualText = getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
        verifyText("Expected text is not displayed", expectedText, actualText);

        //Change Qty to ‘5’
        sendTextToElement(By.xpath("(//input[@class='input-text qty'])[1]"), "5");

        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("(//span[normalize-space()='Update Shopping Cart'])[1]"));

        /**
         * Verify the product price ‘$225.00’
         */
        expectedText = "$225.00";
        actualText = getTextFromElement(By.xpath("(//span[@class='price'][normalize-space()='$225.00'])[3]"));
        verifyText("Expected text is not displayed", expectedText, actualText);


    }
}
