package testcases.railway;

import common.Constant;
import common.DriverManager;
import common.Log;
import common.PropertiesFile;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class GeneralTest {
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser){
        Log.info("Pre-condition");
        DriverManager.chooseBrowser(browser);
        PropertiesFile.setPropertiesFile();
        DOMConfigurator.configure("src/main/resources/log4j.xml");
        DriverManager.maximizeBrowser();
    }

    @AfterMethod
    public void afterMethod(){
        Log.info("Post-condition");
//        Constant.WEBDRIVER.quit();
    }
}
