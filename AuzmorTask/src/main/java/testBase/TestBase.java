package testBase;

import PageObjects.Company;
import PageObjects.HomePage;
import PageObjects.InvitePeopleToOrg;
import PageObjects.SigninPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import reusableComponent.PropertiesOperation;

public class TestBase {

    public  static WebDriver driver;

    public void launchBrowserAndNavigate() throws Exception {
        String browser = PropertiesOperation.getPropertyy("browser");
        String url= PropertiesOperation.getPropertyy("url");
        //   String browser="chrome";
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        //Thread.sleep(1000);
        driver.get(url);


    }

    public JavascriptExecutor js = (JavascriptExecutor) driver;
}
