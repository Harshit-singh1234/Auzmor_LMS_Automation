package automateAuzmor;

import PageObjects.HomePage;
import PageObjects.LearnerPage;
import PageObjects.PaymentPage;
import PageObjects.SigninPage;
import org.testng.annotations.Test;
import reusableComponent.PropertiesOperation;
import testBase.TestBase;

import java.time.Duration;

public class PaymentFlow extends TestBase {
    @Test
    public void PurchaseCourse() throws Exception {
        launchBrowserAndNavigate();
        SigninPage signinPage= new SigninPage();
        signinPage.SignInLearnerView();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        LearnerPage learnerPage= new LearnerPage();
        learnerPage.ClickTrainig();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        learnerPage.Chossecourse();
       learnerPage.buynoww();
        learnerPage.Checkout();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        learnerPage.ConfirmPayment();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        learnerPage.ConfirmPayment();
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.stripePayment();

//        String[] testData=  PropertiesOperation.PaymentDetails();
//       System.out.println(testData[0]);







    }
}
