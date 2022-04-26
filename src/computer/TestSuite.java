package computer;

import com.google.common.base.Verify;
import homepage.TopMenuTest;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

import java.awt.*;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void Testname() {
        //1.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        //1.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //1.3 Select Sort By position "Name: Z to A"
        //selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']/child::option[3]"), "Name: Z to A");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        listDropDown(By.xpath("//select[@id='product-orderby']"), "Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        //2.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //2.4 Click on "Add To Cart"
        // clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        // clickOnElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']"));
        //  clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //clickOnElement(By.xpath("//button[@type='button'][normalize-space()='Add to cart'])[1]"));
        Thread.sleep(3000);
        mouseHoverClick(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));
        //2.5 Verify the Text "Build your own computer"
        verifyTextNull("Build your own computer", "Build your own computer", "Not Match");
        getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']\n"));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByIndex(By.xpath("//select[@id='product_attribute_1']"), 1);
        //2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(3000);
        selectByIndex(By.xpath("//select[@id='product_attribute_2']"), 3);
        Thread.sleep(3000);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        setRadioElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(3000);
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        setRadioElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        // setCheckBoxElement(By.xpath("//label[contains(text(),'Total Commander [+$5.00]"));
        setCheckBoxElement(By.xpath("//input[@id='product_attribute_5_12']"));

        //2.11 Verify the price "$1,365.00"
//        String expectedmsg = "$1,475.00";
//        String actualmsg = getTextFromElement(By.xpath();
//        verifyText("Display amount",getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]")), "$1,475.00");
//        verifyText("$1,475.00", getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]")), "Incorrect price!");
        verifyTextNull("$1,475.00", getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]")), "Incorrect price!");

        //	2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //	2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button
        verifyTextNull("The product has been added to your shopping cart", getTextFromElement(By.xpath("//div[@class='bar-notification success']")), "Incorrect Message");
        clickOnElement(By.className("close"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnly(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.15 Verify the message "Shopping cart"
        //verifyTextNull("Not Match", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")), "Shopping cart");
        verifyTextNull("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")), "Not match");

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        sendTextToElement(By.xpath("(//input[contains(@id, 'itemquantity')])"), Keys.BACK_SPACE + "2");
        //2.17 Verify the Total"$1,385.00"
        verifyTextNull("$1,475.00", getTextFromElement(By.xpath("//span[@class='product-subtotal']")), "Not Match");
        getTextFromElement(By.xpath("//span[@class='product-subtotal']"));

        //2.18 click on checkbox “I agree with the terms of service”
        setCheckBoxElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyTextNull("Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")), "Not Match");
        // 2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        // 2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Jaimin");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "Prime123@gmail.com");
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "ahmedabad");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "150,whithron ave");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "Ub7 10ld");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07405679567");
        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        // setRadioElement(By.xpath("//input[@id='product_attribute_3_7']"));
        setRadioElement(By.xpath("//input[@id='shippingoption_1']"));

        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        setRadioElement(By.xpath("//input[@id='paymentmethod_1']"));
        setRadioElement(By.xpath("//input[@id='paymentmethod_1']"));
        // 2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");

        ///2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Jaimin Patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555 5454 8787 9878\n");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "07");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "222");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //  2.30 Verify “Payment Method” is “Credit Card”
        verifyTextNull("Payment method", getTextFromElement(By.xpath("//h2[normalize-space()='Payment method']")), "Incorrect payment method");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyTextNull("", getTextFromElement(By.xpath("//label[normalize-space()='Next Day Air ($0.00)']")), "Incorrect payment method");
        //	2.33 Verify Total is “$2,950.00”
        verifyTextNull("$2,950.00", getTextFromElement(By.xpath("span[class='value-summary'] strong")), "Wrong total");
        //	2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //	2.35 Verify the Text “Thank You”
        verifyTextNull("Thank you", getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']")), "Not Match");
        //	2.36 Verify the message “Your order has been successfully processed!”
        verifyTextNull("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")), "Not Match");
        //	2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        verifyTextNull("Welcome to our store", getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")), "Not Match");

    }

}