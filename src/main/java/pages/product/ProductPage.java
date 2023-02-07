package pages.product;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductPage extends BasePage {

    @Test(priority = 1)
    public void validatePage() throws InterruptedException {
        driver.get("https://www.vicarius.io/product");
        int i = 0;
        Assert.assertEquals(driver.getTitle(), "Product - Vicarius");
        Assert.assertEquals(driver.findElement(By.cssSelector("div > div > h1")).getText(), "TOPIA Overview");
        String[] secondaryTitle = driver.findElement(By.cssSelector("h3.heading")).getText().split("\n");
        Assert.assertEquals(secondaryTitle[0], "TOPIA protects your installed operating");
        Assert.assertEquals(secondaryTitle[1], "systems and third-party");
        Assert.assertEquals(secondaryTitle[2], "software from vulnerabilities.");
        String[] thirdTitle = driver.findElement(By.xpath("//*/div[3]/div[1]/p")).getText().split("\n");
        Assert.assertEquals(thirdTitle[0], "Consolidate your software vulnerability assessment with one single TOPIA agent.");
        Assert.assertEquals(thirdTitle[1], "Let TOPIA do the work so you can focus on and remediate the threats that matter most.");
        List<WebElement> linkButtons = driver.findElements(By.className("link-button"));
        String[] buttons = {"+ Product", "+ Solution", "Pricing", "+ Community", "+ Company", "Contact", "Login"};
        for (WebElement we : linkButtons) {
            Assert.assertEquals(we.getText(), buttons[i++]);
        }
        Assert.assertEquals(driver.findElement(By.cssSelector(".animated-button")).getText(), "Start Free Trial");
        Assert.assertEquals(driver.findElement(By.xpath("//*/div[3]/div[2]/button")).getText(), "Watch Demo");
        driver.close();
    }


    @Test(priority = 2)
    public void LogoClickTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/product");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("div > a > svg")).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.vicarius.io/");
        driver.close();
    }

    @Test(priority = 3)
    public void LoginClickTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/product");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a.hidden-lg-down")).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.vicarius.io/sign/in");
        driver.close();
    }

    @Test(priority = 4)
    public void CveIconTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/product");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        // check that CVE label is not displayed
        Assert.assertEquals(driver.findElement(By.cssSelector("span.label")).isDisplayed(), false);
        // mouse over on the icon
        WebElement gameIcon = driver.findElement(By.cssSelector(".game-icon"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gameIcon).perform();
        // check that label appears
        Assert.assertEquals(driver.findElement(By.cssSelector("span.label")).isDisplayed(), true);
        // clicking on CVE icon
        gameIcon.click();
        Thread.sleep(10000);
        // check that link works
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.vicarius.io/cve-invaders");
        driver.close();
    }

    @Test(priority = 5)
    public void WatchDemoTest() throws InterruptedException {
        driver.get("https://www.vicarius.io/product");
        driver.manage().window().maximize();
        // check that youtube player is not displayed
        Assert.assertEquals(driver.findElements(By.cssSelector(".btn-close")).size(), 0);
        // clicking on the button
        driver.findElement(By.cssSelector(".hero-inner > div:nth-child(3) > button:nth-child(1)")).click();
        Thread.sleep(10000);
        // check that close button of player appears
        Assert.assertEquals(driver.findElement(By.cssSelector(".btn-close")).isDisplayed(), true);
        driver.close();
    }
}
