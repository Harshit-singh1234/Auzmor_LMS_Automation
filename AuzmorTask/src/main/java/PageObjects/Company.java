package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

import java.time.Duration;

public class Company extends TestBase {
    @FindBy(xpath = "//*[@data-testid='fab-btn']")
     WebElement sy_add;
    @FindBy(xpath = "//*[@data-testid='invite-people-section']")
     WebElement hover_invitepeople;
   @FindBy(xpath = "//*[@data-testid='invite-people-btn']")
    WebElement hover_add_people;
    public Company()
    {
        PageFactory.initElements(driver,this);
    }
    public   void click_add() throws InterruptedException {
        sy_add.click();
        Actions a=new Actions(driver);
        Thread.sleep(1000);
        a.moveToElement(hover_invitepeople).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        hover_add_people.click();
    }

}

