package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class HomePage  extends TestBase {

   @FindBy(xpath="//*[@data-testid='filter-by-company']")
    WebElement dd_comapnytag;

 @FindBy(xpath = "//*[@data-testid='peoples-menu']")
 WebElement bu_clickcompany;

 @FindBy(xpath = "//*[@data-testid='nav-profile-icon']")
 WebElement bu_iconn;
 @FindBy(xpath = "//*[@data-testid='profile-dropdown-switch-option']")
 WebElement hover_learner;

  public HomePage()
  {
      PageFactory.initElements(driver,this);
  }

   public    void CompanyHover() throws InterruptedException {
       Actions a=new Actions(driver);
       Thread.sleep(6000);
       a.moveToElement(dd_comapnytag).perform();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
   }
   public  void clickCompany()
   {
       bu_clickcompany.click();
   }

    public void ClickIcon()
    {
        bu_iconn.click();
    }
    public void setHover_learner()
    {
        hover_learner.click();
    }

}
