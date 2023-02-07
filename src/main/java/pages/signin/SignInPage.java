package pages.signin;

import utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BasePage;

public class SignInPage extends BasePage {

//    public WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
////        WebDriverManager.chromedriver().setup();
////        driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//    }

    @Test(priority = 1)
    public void validatePage() throws InterruptedException {
        driver.get("https://www.vicarius.io/sign/in");
        Assert.assertEquals(driver.getTitle(), "Login to TOPIA Cloud 📨 - Vicarius");
        Utils.validateLeftSide(driver, "Vuln Prioritisation");
        driver.close();
    }

    @Test(priority = 2)
    public void LogoClickTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/sign/in");
        Utils.LogoClick(driver);
    }

    @Test(priority = 3)
    public void FaqClickTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/sign/in");
        Utils.FaqClick(driver);
    }
}
