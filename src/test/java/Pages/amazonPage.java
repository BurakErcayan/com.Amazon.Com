package Pages;

import Utilitis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class amazonPage {

    public amazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement SearchBox;

    @FindBy(xpath = "//span[@class='a-button-inner']//*[text()='Reddet']")
    public WebElement popUpDissmisButton;

    @FindBy(xpath = "//*[text()='\"samsung\"']")
    public WebElement serchResultText;

    @FindBy(xpath = "//div[@role='navigation']//*[text()='2']")
    public WebElement pageNumber;

    @FindBy(xpath = "//div[@class='a-section a-spacing-base']")
    public List<WebElement> productList;

    @FindBy(xpath = "(//div[@class='a-section a-spacing-base'])[17]")
    public WebElement productText;

    @FindBy(xpath = "//div[@class='a-button-stack']//input[@id='add-to-cart-button']")
    public WebElement addToCardButton;

    @FindBy(xpath = "//div[@class='a-section a-padding-medium sw-atc-message-section']//h1")
    public WebElement addToCardText;

    @FindBy(xpath = "//div[@id='navbar']//div[@id='nav-logo']")
    public WebElement logoButton;

    @FindBy(xpath = "//*[@id='title']")
    public WebElement productDetailText;




}
