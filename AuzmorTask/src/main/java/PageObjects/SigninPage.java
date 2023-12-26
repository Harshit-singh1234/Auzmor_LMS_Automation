package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reusableComponent.PropertiesOperation;
import testBase.TestBase;

import java.io.IOException;
import java.util.Properties;

import static testBase.TestBase.driver;

public class SigninPage extends TestBase {


    @FindBy(xpath = "//*[@type='text']")
     WebElement txt_username;
    @FindBy(xpath = "//*[@type='password']")
     WebElement txt_password;

    @FindBy(xpath = "//*[@data-testid='login-submit-btn']")
     WebElement signinButoon;

 public SigninPage()
 {
     PageFactory.initElements(driver,this);
 }


  public   void signInAdmin() throws IOException {
     String[] testData=  PropertiesOperation.ReadTestDataAdmin();
    txt_username.sendKeys(testData[0]);
    txt_password.sendKeys(testData[1]);
    signinButoon.click();

  }
    public   void SignInLearnerView() throws IOException {
        String[] testData=  PropertiesOperation.ReadTestDataLearner();
        txt_username.sendKeys(testData[0]);
        txt_password.sendKeys(testData[1]);
//        txt_username.sendKeys("adityacollege740@gmail.com");
//        txt_password.sendKeys("Test@123");
        signinButoon.click();

    }



}
