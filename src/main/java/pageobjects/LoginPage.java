package pageobjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage{
    // Locators
    private static By ddlRepository = By.id("repository");
    private static By txtUsername = By.id("username");
    private static By txtPassword = By.id("password");
    private static By btnLogin = By.className("btn-login");

    // Elements
    private WebElement getDdlRepository(){
        return Constant.WEBDRIVER.findElement(ddlRepository);
    }

    private WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    private WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    // Methods

    public void login(String username){
        Select selectRepo = new Select(getDdlRepository());
        selectRepo.selectByVisibleText("SampleRepository");
        getTxtUsername().sendKeys(username);
        getBtnLogin().click();
    }
}
