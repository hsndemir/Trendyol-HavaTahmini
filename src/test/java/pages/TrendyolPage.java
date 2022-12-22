package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TrendyolPage {

    public TrendyolPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//div[@title='Kapat']")
    public WebElement anaSayfaGelenEkraniKapat;
    @FindBy(xpath = "//a[@href='https://www.trendyol.com/sr?fl=sepetteurunler']")
    public WebElement sepeteEnCokEklenenlerButton;

    @FindBy(xpath = "//h1")
    public WebElement sepeteEnCokEklenenlerPageTitle;

    @FindBy(xpath = "//div[@class='p-card-wrppr with-campaign-view add-to-bs-card']")
    public List<WebElement> sepeteEnCokEklenenlerPageList;

    @FindBy(xpath = "//button[@class='add-to-basket']")
    public WebElement productPageSepeteEkleButton;

    @FindBy(xpath = "//div[@class='add-to-basket-button-text-success']")
    public WebElement productPageSepeteEklendiSuccessText;

    @FindBy(xpath = "//p[text()='Sepetim']")
    public WebElement productPageSepetimButton;

    @FindBy(xpath = "//div[@class='pb-header']")
    public WebElement sepetimPageTitle;

    @FindBy(xpath = "//div[@class='pb-basket-item']")
    public WebElement sepetimPageItem;


}
