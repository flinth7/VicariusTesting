package pages.signup;

import base.BasePage;
import utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SignUpPage extends BasePage {

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
        driver.get("https://www.vicarius.io/sign/up");
        Assert.assertEquals(driver.getTitle(), "Start your 14-days Free Trial Now 🆓 - Vicarius");
        Utils.validateLeftSide(driver, "Vuln Prioritization");
        Assert.assertEquals(driver.findElement(By.id("input27")).getAttribute("placeholder"), "First Name");
        Assert.assertEquals(driver.findElement(By.id("input29")).getAttribute("placeholder"), "Last Name");
        Assert.assertEquals(driver.findElement(By.id("input31")).getAttribute("placeholder"), "Work e-mail");
        Assert.assertEquals(driver.findElement(By.id("input33")).getAttribute("placeholder"), "Company");
        Assert.assertEquals(driver.findElement(By.cssSelector("#__layout > div > div:nth-child(1) > div.sign > div.container > div > div.col.col-lg-6.sign-right > div.content > div > div > div > form > div > div > button")).getText(), "Continue");
        String[] optionClassText = driver.findElement(By.className("option")).getText().split("\n");
        Assert.assertEquals(optionClassText[0], "Already have an account?");
        Assert.assertEquals(optionClassText[1], "Login");
        String[] rightTitleText = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/h2")).getText().split("\n");
        Assert.assertEquals(rightTitleText[0], "Start Your 14-day");
        Assert.assertEquals(rightTitleText[1], "Free Trial");
        Assert.assertEquals(driver.findElement(By.className("subtitle")).getText(), "Deploy in minutes. No credit card. No commitment.");
        Assert.assertEquals(driver.findElement(By.className("consent-text")).getText(), "By submitting this form, you consent to be contacted about Vicarius product.");
        driver.close();
    }

    @Test(priority = 2)
    public void LogoClickTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/sign/up");
        Utils.LogoClick(driver);
    }

    @Test(priority = 3)
    public void FaqClickTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/sign/up");
        Utils.FaqClick(driver);
    }

    @Test(priority = 4)
    public void ContinueEmptyInputsTest() {
        driver.get("https://www.vicarius.io/sign/up");
        driver.findElement(By.cssSelector("form > div > div > button")).click();
        List<WebElement> elements = driver.findElements(By.className("error"));
        Assert.assertEquals(elements.size(), 3);
        for (WebElement element : elements) {
            Assert.assertEquals(element.getText(), "Field is required.");
        }
        driver.close();
    }

    @Test(priority = 5)
    public void ContinueValidValuesTest() throws InterruptedException {
        String name = "hillel";
        driver.get("https://www.vicarius.io/sign/up");
        driver.findElement(By.id("input27")).sendKeys(name);
        driver.findElement(By.id("input29")).sendKeys(name);
        driver.findElement(By.id("input31")).sendKeys(name + "@vicarius.com");
        driver.findElement(By.id("input33")).sendKeys("Vicarius");
        driver.findElement(By.cssSelector("form > div > div > button")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"input63\"]")).getAttribute("type"), "password");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"input65\"]")).getAttribute("type"), "password");
        Assert.assertEquals(driver.findElement(By.className("subtitle")).getText(), "Deploy in minutes. No credit card. No commitment.");
        driver.close();
    }

    @Test(priority = 6)
    public void ContinueNotValidEmailTest() {
        String name = "hillel";
        driver.get("https://www.vicarius.io/sign/up");
        driver.findElement(By.id("input27")).sendKeys(name);
        driver.findElement(By.id("input29")).sendKeys(name);
        driver.findElement(By.id("input31")).sendKeys(name);
        driver.findElement(By.id("input33")).sendKeys("Vicarius");
        driver.findElement(By.cssSelector("form > div > div > button")).click();
        List<WebElement> elements = driver.findElements(By.className("error"));
        Assert.assertEquals(elements.size(), 1);
        Assert.assertEquals(elements.get(0).getText(), "Must be valid email address.");
        driver.close();
    }

    @Test(priority = 7)
    public void LoginClickTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/sign/up");
        driver.findElement(By.cssSelector("div.header > div.right > div.option > a > span")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.vicarius.io/sign/in");
        driver.close();
    }
}
