package Utilitis;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ReusableMethods {


    public static WebElement highLightToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        return element;
    }

    public static void waitFor(int sec) {
       try {
           Thread.sleep(sec * 1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

   public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = driver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
        }
    }

    public static void scrollToBottomOfPage(WebDriver driver, WebElement element) {
        waitFor(2);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = "arguments[0].scrollIntoView(false);";
        jsExecutor.executeScript(script, element);
    }


}



