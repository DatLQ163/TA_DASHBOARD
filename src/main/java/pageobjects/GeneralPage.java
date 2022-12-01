package pageobjects;

import common.Constant;
import common.DriverManager;
import enumData.GlobalSettingOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralPage {
    // Locators
    String pageParentName = "//a[.='%s']";
//    String pageChildrenName ="//a[.='%s']/..//a[.='%s']";
    String pageChildrenName ="//a[.='%s']/..//a[contains(text(),'Child')]";
    private static final By tabPageBesideOverview = By.xpath("//a[.='Overview']/..//following::li[1]//a");
    private static final By tabOverview = By.linkText("Overview");
    private static final By tabExecution = By.xpath("//a[@href='/TADashboard/2f9njff6y9.page']");
    private static final By tabChoosePanel = By.id("btnChoosepanel");
    private static final By tabSetting = By.xpath("//li[@class='mn-setting']//a[@href='javascript:void(0);']");
    String btnSettingOption = "//li[@class='mn-setting']//a[.='%s']";
    private static By txtNameNewPage = By.name("name");
    private static By ddlParent = By.id("parent");
    private static By ddlColumnNumber = By.id("columnnumber");
    private static By ddlAfterPage = By.id("afterpage");
    private static By btnOkNewPage = By.id("OK");
    //Elements
    private WebElement getPageParentNew(String pageNew){
        return  Constant.WEBDRIVER.findElement(By.xpath(String.format(pageParentName,pageNew)));
    }

//    private WebElement getPageChildren(String parent, String children){
//        return Constant.WEBDRIVER.findElement(By.xpath(String.format(pageChildrenName,parent,children)));
//    }

    private WebElement getPageChildren(String parent){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(pageChildrenName,parent)));
    }

    private WebElement getPageBesideOverview(){
        return Constant.WEBDRIVER.findElement(tabPageBesideOverview);
    }


    private WebElement getTabExecution(){
        return Constant.WEBDRIVER.findElement(tabExecution);
    }

    private WebElement getTabChoosePanel(){
        return Constant.WEBDRIVER.findElement(tabChoosePanel);
    }

    private WebElement getTabSetting(){
        return Constant.WEBDRIVER.findElement(tabSetting);
    }

    private WebElement getBtnSettingOption(String option){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnSettingOption,option)));
    }

    private WebElement getTxtNameNewPage(){
        return Constant.WEBDRIVER.findElement(txtNameNewPage);
    }

    private WebElement getBtnOkNewPage(){
        return Constant.WEBDRIVER.findElement(btnOkNewPage);
    }

    private WebElement getDdlParent(){
        return Constant.WEBDRIVER.findElement(ddlParent);
    }

    private WebElement getDdlColumnNumber(){
        return Constant.WEBDRIVER.findElement(ddlColumnNumber);
    }

    private WebElement getDdlAfterPage(){
        return Constant.WEBDRIVER.findElement(ddlAfterPage);
    }

    //Methods
    public void gotoParentPage(String parentName) throws InterruptedException {
        DriverManager.waitSleep();
        getPageParentNew(parentName).click();
    }

    public void gotoChildrenPage(String parentName) throws InterruptedException {
        DriverManager.waitSleep();
        DriverManager.hover(getPageParentNew(parentName));
//        getPageChildren(parentName,childrenName).click();
        getPageChildren(parentName).click();
    }

    public boolean checkParentPageDisplay(String pageName){
        try{
            getPageParentNew(pageName);
            return false;
        }catch (Exception e){
            return true;
        }
    }

    public boolean checkChildrenPageDisplay(String parentName){
        try{
//            getPageChildren(parentName,childrenName).isDisplayed();
            getPageChildren(parentName);
            return false;
        }catch (Exception e){
            return true;
        }
    }

    public boolean checkSettingOptionDisplay(String optionName){
        try{
            getBtnSettingOption(optionName);
            return false;
        }catch (Exception e){
            return true;
        }
    }

    public String getNamePageBesideOverview() throws InterruptedException {
        Thread.sleep(3000);
        DriverManager.waitForElement();
        return getPageBesideOverview().getText();
    }

    public void addPage(String pageName, String parent,String number, String afterPage) throws InterruptedException {
        DriverManager.waitSleep();
        DriverManager.hover(getTabSetting());
        getBtnSettingOption(GlobalSettingOptions.ADD_PAGE.getSettingOption()).click();
        DriverManager.waitSleep();
        Select selectParent = new Select(getDdlParent());
        Select selectColumnNumber = new Select(getDdlColumnNumber());
        Select selectAfterPage = new Select(getDdlAfterPage());
        getTxtNameNewPage().sendKeys(pageName);
        selectParent.selectByVisibleText(parent);
        selectColumnNumber.selectByVisibleText(number);
        selectAfterPage.selectByVisibleText(afterPage);
        DriverManager.waitSleep();
        getBtnOkNewPage().click();
    }

    public void deleteNewlyAddedPage() throws InterruptedException {
        DriverManager.waitSleep();
        DriverManager.hover(getTabSetting());
        getBtnSettingOption(GlobalSettingOptions.DELETE.getSettingOption()).click();
    }

    public String getPageTitle(String pageName){
        return getPageParentNew(pageName).getText();
    }
}
