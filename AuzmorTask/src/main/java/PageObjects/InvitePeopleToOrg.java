package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testBase.TestBase;

import java.security.PublicKey;
import java.util.List;

public class InvitePeopleToOrg extends TestBase {

     @FindBy(xpath="//input[@placeholder='Full Name']")
      WebElement txt_name;
     @FindBy(xpath = "//*[@data-testid='invite-people-role-dropdown']")
    List<WebElement> dd_role;

     @FindBy(xpath = "//input[@placeholder='name@example.com']")
      WebElement txt_mail;

     @FindBy(xpath = "//*[@data-testid='banner-content-dropdown']")
      WebElement  dd_report;

     @FindBy(xpath = "//*[@title='Admin One']")
      WebElement choose_manager;

     @FindBy(xpath = "//button[@data-testid='normal-btn']")
      WebElement btn_add;
     @FindBy(xpath = "//button[@data-testid='invite-people-send-btn']")
      WebElement btn_send;

      public InvitePeopleToOrg()
     {
         PageFactory.initElements(driver,this );
     }


    public  void Filldetails() throws InterruptedException {
        txt_name.sendKeys("aditya college");
        txt_mail.sendKeys("adityacollege740@gmail.com");
        dd_report.click();
        choose_manager.click();
        btn_add.click();
        btn_send.click();
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //Thread.sleep(6000);
    }

}

