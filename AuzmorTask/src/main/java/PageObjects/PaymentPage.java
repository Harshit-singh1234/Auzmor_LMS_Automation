package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reusableComponent.PropertiesOperation;
import testBase.TestBase;

import java.io.IOException;

public class PaymentPage extends TestBase {
    public  PaymentPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='line1']")
    WebElement txt_adress;

    @FindBy(xpath = "//*[@id='city']")
    WebElement txt_city;

    @FindBy(xpath = "//*[@id='state']")
    WebElement txt_state;

    @FindBy(xpath = "//*[@id='postal_code']")
    WebElement txt_postal;

    @FindBy(xpath = "//*[@id= 'email']")
    WebElement txt_email;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[3]/div/div/div/div/form")
    WebElement html_frame;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[3]/div/div/div/div/form/fieldset[2]/div/div/div/iframe")
    WebElement i_Frame;
    @FindBy(xpath = "//*[@name='cardnumber']")
    WebElement txt_cardNumber;

    @FindBy(xpath = "//*[@name='exp-date']")
    WebElement txt_exp;

    @FindBy(xpath = "//*[@name='cvc']")
    WebElement txt_cvc;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[3]/div/div/div/div/form/button")
    WebElement but_submit;

    public void stripePayment() throws IOException {


        txt_adress.sendKeys("aditya educational");
        txt_city.sendKeys("suramplaem");
        txt_state.sendKeys("andhrapradesh");
        txt_postal.sendKeys("533437");
        txt_email.clear();
        txt_email.sendKeys("harshitsr1234@gmail.com");
        driver.switchTo().frame(i_Frame);
        txt_cardNumber.sendKeys("4242424242424242");
        txt_exp.sendKeys("04-24");
        txt_cvc.sendKeys("242");
        driver.switchTo().defaultContent();
        but_submit.click();

//        String[] testData=  PropertiesOperation.PaymentDetails();
//        txt_adress.sendKeys(testData[0]);
//        txt_city.sendKeys(testData[1]);
//        txt_state.sendKeys(testData[2]);
//        txt_postal.sendKeys(testData[3]);
//        txt_email.clear();
//        txt_email.sendKeys(testData[4]);
//        driver.switchTo().frame(i_Frame);
//        txt_cardNumber.sendKeys(testData[5]);
//        txt_exp.sendKeys(testData[6]);
//        txt_cvc.sendKeys(testData[7]);
//        driver.switchTo().defaultContent();
//        but_submit.click();


    }
}
