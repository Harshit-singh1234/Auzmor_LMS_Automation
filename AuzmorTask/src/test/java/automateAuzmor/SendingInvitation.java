package automateAuzmor;

import PageObjects.Company;
import PageObjects.HomePage;
import PageObjects.InvitePeopleToOrg;
import PageObjects.SigninPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBase.TestBase;

public class SendingInvitation extends TestBase{

 @Test
 public void loginAdmin() throws Exception {
  launchBrowserAndNavigate();
  SigninPage obj=new SigninPage();
  obj.signInAdmin();
  HomePage homePage=new HomePage();
  homePage.CompanyHover();
  homePage.clickCompany();
  Company company=new Company();
  company.click_add();
  InvitePeopleToOrg invitePeopleToOrg=new InvitePeopleToOrg();
  invitePeopleToOrg.Filldetails();
 }


// @AfterMethod
// public void cleanUp()
// {
//    driver.quit();
// }

}