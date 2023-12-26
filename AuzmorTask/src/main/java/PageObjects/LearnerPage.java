package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

import java.nio.file.Watchable;

public class LearnerPage extends TestBase {

    @FindBy(xpath = "//*[@data-testid='trainings-menu']")
    WebElement icon_training;
    @FindBy(xpath = "//*[@data-testid='price-tag']")
    WebElement card_course;

    @FindBy(xpath = "//button[@data-testid='buy-now']")
    WebElement btn_buy;

    @FindBy(xpath = "//*[@data-testid='add-cart-btn']")
    WebElement btn_addcart;

    @FindBy(xpath = "//*[@data-testid='remove-cart-btn]")
    WebElement btn_removecart;
    @FindBy(xpath = "//*[@data-testid='confirm-payment-btn']")
    WebElement getBtn_confirmPayment;
    @FindBy(xpath = "//*[@data-testid='checkout-btn']")
    WebElement btn_checkout;
    @FindBy(xpath = "//*[@data-testid='confirm-payment-btn']")
    WebElement btn_confirmPayment;

    public  LearnerPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void ClickTrainig()
    {
        icon_training.click();
    }
    public void Chossecourse()
    {
          card_course.click();
    }
    public void buynoww()
    {
        btn_buy.click();
      //  btn_buy.click();

    }
    public void Checkout()
    {
        btn_checkout.click();
    }
    public void ConfirmPayment()
    {
        getBtn_confirmPayment.click();
    }



}
