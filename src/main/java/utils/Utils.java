package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Utils {
        public static void validateLeftSide(WebDriver driver, String expected) {

                driver.manage().window().maximize();
                String[] titles = {"Vuln Discovery", expected, "Vuln Remediation", "Automation"};
                String[] texts = {
                        "You can’t fix what you can’t find.",
                        "Focus on risks that have real potential for exploitation",
                        "Don’t just find your flaws, fix them.",
                        "Threats don’t take time off, but you can."
                };
                for (int i = 1; i < 5; i++) {
                        Assert.assertEquals(driver.findElement(By.xpath("//*/ul/li[" + i + "]/div[2]/h3")).getText(), titles[i - 1]);
                        Assert.assertEquals(driver.findElement(By.xpath("//*/ul/li[" + i + "]/div[2]/p")).getText(), texts[i - 1]);
                }
                Assert.assertEquals(driver.findElement(By.className("faq")).getText(), "Frequently Asked Questions →");
        }

        public static void LogoClick(WebDriver driver) throws InterruptedException {
//                driver.get(url);
                driver.manage().window().maximize();
                driver.findElement(By.cssSelector("div.sign > div.header > div.left")).click();
                Thread.sleep(10000);
                Assert.assertEquals(driver.getCurrentUrl(), "https://www.vicarius.io/");
                driver.close();
        }

        public static void FaqClick(WebDriver driver) throws InterruptedException {
//                driver.get(url);
                driver.manage().window().maximize();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
                Thread.sleep(1000);
//                driver.findElemenbt(By.className("faq")).click();
                driver.findElement(By.cssSelector("div.sign-inner > div > a")).click();
                Thread.sleep(5000);
                // get window handlers as list
                List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
                // switch to new tab
                driver.switchTo().window(browserTabs.get(1));
                Assert.assertEquals(driver.getCurrentUrl(), "https://customer-portal.vicarius.io/");
                driver.close();
                driver.switchTo().window(browserTabs.get(0));
                driver.close();
        }


}
