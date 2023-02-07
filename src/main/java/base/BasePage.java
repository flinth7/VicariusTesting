package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
