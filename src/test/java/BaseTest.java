
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WebDriver driver;
   public static TrackerPage trackerPage;


    @Before
    public static void setUp()  {

    }

    public static void openApplication(String _browser){

        String browserName = _browser;
        if(browserName.equals("chrome")){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.navigate().to("https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start");
        trackerPage=new TrackerPage(driver);
    }

    public static void waitForPageLoad(){
        driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
    }

    public static void waitFor(long millisec) throws InterruptedException {
        Thread.sleep(millisec);
    }

    @After
    public static void tearDown()
    {

        driver.close();
    }

}
