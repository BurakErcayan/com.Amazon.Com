package Test;

import Pages.amazonPage;
import Utilitis.ConfigReader;
import Utilitis.Driver;
import Utilitis.ReusableMethods;

import org.apache.hc.core5.net.WWWFormCodec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.Random;

public class amazonTest {

    private static final Logger logger = LogManager.getLogger();


    amazonPage Apage = new amazonPage();

    @Test
    public void TC01() throws MalformedURLException {


        // Step 1: Open the browser and navigate to the URL
        logger.info("Amazon.com.tr sayfasına gidildi");
        Driver.getDriver().get(ConfigReader.getProperty("amazonBaseUrl"));
        ReusableMethods.waitForPageToLoad(5);

        //Step 2: .......
        logger.info("Çerezler reddedildi");
        ReusableMethods.highLightToElement(Apage.popUpDissmisButton);
        ReusableMethods.waitFor(2);
        Apage.popUpDissmisButton.click();

        //Step 3: .......
        logger.info("Arama Kutusuna Samsung Yazdırıp Aratıldı.");
        ReusableMethods.highLightToElement(Apage.SearchBox)
        .sendKeys("samsung");
        ReusableMethods.waitFor(3);
        Apage.SearchBox.sendKeys(Keys.ENTER);

        //Step 4: .....
        logger.info("Aranan Sayfanın Geldiği Doğrulandı");
        ReusableMethods.highLightToElement(Apage.serchResultText);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Apage.serchResultText.isDisplayed());

        //Step 5: ........
        logger.info("Slider da 2. Sayfaya Tıklandı");
        ReusableMethods.scrollToBottomOfPage(Driver.getDriver(), Apage.pageNumber);
        ReusableMethods.highLightToElement(Apage.pageNumber);
        ReusableMethods.waitFor(3);
        Apage.pageNumber.click();

        //Step 6: ......
        logger.info("2. Sayfada Olduğu Doğrulandı");
        ReusableMethods.scrollToBottomOfPage(Driver.getDriver(), Apage.pageNumber);
        ReusableMethods.highLightToElement(Apage.pageNumber);
        ReusableMethods.waitFor(2);

        //Step 7: .....
        logger.info("Ürün Listesinde 5. Satırın ilk ürünününe Tıklandı ve Tıklanan Ürünle Açılan Sayfa Karşılaştırıldı");
        if (Apage.productList.size() > 0) {
            int indexToClick = 16;
            if (Apage.productList.size() > indexToClick) {
                WebElement clickedProduct = Apage.productList.get(indexToClick);
                WebElement expectedElement = Apage.productText;
                String expectedText = expectedElement.getText();
                ReusableMethods.highLightToElement(clickedProduct);
                ReusableMethods.waitFor(5);
                clickedProduct.click();
                ReusableMethods.waitForPageToLoad(3);
                ReusableMethods.highLightToElement(Apage.productDetailText);
                WebElement actualElement = Apage.productDetailText;
                String actualText = actualElement.getText();
                if (actualText.equals(expectedText)) {
                    System.out.println("Sonuç beklenenle eşleşiyor.");
                }
            }
            //Step 8: ........
            logger.info("Sepete Ekle Butonuna Tıklandı");
            ReusableMethods.highLightToElement(Apage.addToCardButton);
            ReusableMethods.waitFor(2);
            Apage.addToCardButton.click();

            //Step 9: ......
            logger.info("Ürünün Sepete Eklendiği Doğrulandı");
            ReusableMethods.highLightToElement(Apage.addToCardText);
            ReusableMethods.waitFor(2);
            Assert.assertTrue(Apage.addToCardText.isDisplayed());

            //Step 10: ......
            logger.info("Amazon Logosuna Tıklandı");
            ReusableMethods.highLightToElement(Apage.logoButton);
            ReusableMethods.waitFor(2);
            Apage.logoButton.click();


        }
    }
}








