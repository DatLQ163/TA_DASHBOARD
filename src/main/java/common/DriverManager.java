package common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static void chooseBrowser(String browser) {
        browser.equalsIgnoreCase(browser);
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "executables/chromedriver.exe");
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "executables/geckodriver.exe");
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", Utilities.getProjectPath() + "executables/msedgedriver.exe");
                Constant.WEBDRIVER = new EdgeDriver();
                break;
            default:
                throw new NullPointerException("no browser type is found");
        }
        Constant.WEBDRIVER.navigate().to(Constant.TADASHBOARD_URL);
    }
    public static void maximizeBrowser(){
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void hover(WebElement elementToHover){
        Actions action = new Actions(Constant.WEBDRIVER);
        action.moveToElement(elementToHover).perform();
        action.moveToElement(elementToHover).perform();
        action.moveToElement(elementToHover).perform();
    }

    public static void waitForElement(){
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static void waitSleep() throws InterruptedException {
        Thread.sleep(3000);
    }

    public static void clickOkAlert(){
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public static String getAlertMessage() throws InterruptedException {
        waitSleep();
        return Constant.WEBDRIVER.switchTo().alert().getText();
    }

    public static void refreshCurrentPage() {
        Constant.WEBDRIVER.navigate().refresh();
    }
}
