package pages.signin;

import org.openqa.selenium.By;
import utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BasePage;

public class SignInPage extends BasePage {

    @Test(priority = 1)
    public void validatePage() {
        driver.get("https://www.vicarius.io/sign/in");
        Assert.assertEquals(driver.getTitle(), "Login to TOPIA Cloud 📨 - Vicarius");
        Utils.validateLeftSide(driver);
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

    @Test(priority = 4)
    public void FreeTrialButtonTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/sign/in");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("div.right > div.option > a > span")).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.vicarius.io/sign/up");
    }
}
