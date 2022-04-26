package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Mouse;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified()throws InterruptedException{
        // 1.1 Mouse Hover on “Electronics”Tab
        mouseHoverOnly(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //mouseHoverOnly(By.xpath("Electronics"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnly(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
       // mouseHoverOnly(By.xpath("Cell phones"));
       // 1.3 Verify the text “Cell phones”
        verifyTextNull("Cell phones", getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")), "Not Match");
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException{
       //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnly(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(2000);
        mouseHoverOnly(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //2.3 Verify the text “Cell phones”
        verifyTextNull("Cell phones", getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")), "Not Match");
        // 	2.4 Click on List View Tab
        Thread.sleep(2000);
        //clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        clickOnElement(By.xpath("viewmode-icon list"));
        //	2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));
        //	2.6 Verify the text “Nokia Lumia 1020”
        verifyTextNull("Nokia Lumia 1020",getTextFromElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]")),"Not Match");
        //	2.7 Verify the price “$349.00”
        verifyTextNull("$349.00",getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]")),"Not match");
       //2.8 Change quantity to 2
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), Keys.BACK_SPACE + "2");
      //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //	2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyTextNull("The product has been added to your shopping cart",getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]")),"Not Match");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //	2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnly(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //	2.12 Verify the message "Shopping cart"
        verifyTextNull("Shopping cart",getTextFromElement(By.xpath("//span[contains(text(),'Shopping cart')]")),"Not Match");
        //	2.13 Verify the quantity is 2
        verifyTextNull("2",getTextFromElement(By.xpath("")),"Not Match");
        //2.14 Verify the Total $698.00
        verifyTextNull("$698.00",getTextFromElement(By.xpath("//strong[contains(text(),'$698.00')]")),"Not Match");
       clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        //2.15 click on checkbox “I agree with the terms of service”
       setCheckBoxElement(By.xpath("//div[@class='terms-of-service']"));
        //2.16 Click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //“2.17 Verify the Text “Welcome, Please Sign In!”
        verifyTextNull("Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")),"Not Match");
        // 	2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //	2.19 Verify the text “Register”
        verifyTextNull("Register",getTextFromElement(By.xpath("//button[contains(text(),'Register')]")),"Not Match");
        //	2.20 Fill the mandatory fields
        setRadioElement(By.xpath("//input[@id='gender-female']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Nicks");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='Email']"),"prime123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"),"123456");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"123456");
        //	2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //	2.22 Verify the message “Your registration completed”
        verifyTextNull("Your registration completed",getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")),"Not Match");
        //	2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //	2.24 Verify the text “Shopping cart”
        verifyTextNull("",getTextFromElement(By.xpath("//a[contains(text(),'Continue')]")),"Not Match");
        //	2.25 click on checkbox “I agree with the terms of service”
       setCheckBoxElement(By.xpath("//a[contains(text(),'Continue')]"));
        //	2.26 Click on “CHECKOUT”
       clickOnElement(By.xpath("//button[@id='checkout']"));
        //	2.27 Fill the Mandatory fields
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Nicks");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"prime123@gmail.com");
        selectBydropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"UnitedKingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"153,whithrone ave,b7 9ld");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"ub7 9ld");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07401234123");
        //	2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //	2.29 Click on Radio Button “2nd Day Air ($0.00)”
        setRadioElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        setRadioElement(By.xpath("//input[@id='paymentmethod_1']"));
        //2.32 Select “Visa” From Select credit card dropdown
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//select[@id='CreditCardType']"), "Visa");
        Thread.sleep(2000);
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Rosie Cross");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "321");
        //2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyTextNull("Credit card", getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")), "Invalid Payment Method");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyTextNull("2nd Day Air", getTextFromElement(By.xpath("li[class='shipping-method'] span[class='value']")), "Invalid Shipping Method");
        //	2.37 Verify Total is “$698.00”
        verifyTextNull("$698.00", getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]")), "Incorrect Total");
        //	2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //	2.39 Verify the Text “Thank You”
        verifyTextNull("Thank You", getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")), "Invalid Message");
        //	2.40 Verify the message “Your order has been successfully processed!”
        verifyTextNull("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")), "Invalid Message");
        //	2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        verifyTextNull("Welcome to our store", getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")), "Invalid Message");
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        verifyUrl("“https://demo.nopcommerce.com/”");
    }
}
