package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utilities {
    public static String getProjectPath() {
        return "src/main/java/";
    }
    public static void scrollToFindElement(WebElement element){
        Actions actions = new Actions(Constant.WEBDRIVER);
        actions.moveToElement(element);
        actions.perform();
    }

    public static void scrollByJavaScript(){
        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeScript("scrollBy(0, 400)");
    }
}
