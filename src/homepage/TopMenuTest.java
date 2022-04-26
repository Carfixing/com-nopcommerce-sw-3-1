package homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of  type string
    //1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu){
        clickOnElement(By.xpath("//u1[@class='top-menu notmobile']//a[normalize-space()='"+ menu+"]"));
    }
    //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
   @Test
    public void verifyPageNavigation() throws InterruptedException{
       ArrayList<String> menuList = new ArrayList<>();
       menuList.add("Computers");
       menuList.add("Electronics");
       menuList.add("Apparel");
       menuList.add("Digital downloads");
       menuList.add("Books");
       menuList.add("Jewelry");
       menuList.add("Gift Cards");
       for (String menu : menuList){
           clickOnElement(By.linkText(menu));
           Thread.sleep(2000);
       }
   }
   @After
    public void tearDown(){
        closeBrowser();
   }
}

