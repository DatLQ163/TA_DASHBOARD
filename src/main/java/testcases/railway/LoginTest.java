package testcases.railway;

import common.Constant;
import common.DriverManager;
import common.Log;
import enumData.GlobalSettingOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.GeneralPage;
import pageobjects.LoginPage;

public class LoginTest extends GeneralTest{
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();

    @Test
    public void TC12() throws InterruptedException {
        Log.info("TC12: Verify that user is able to add additional pages besides 'Overview' page successfully");
        String pageName = "PageOne";
        String parent = "Select parent";
        String number = "2";
        String afterPage = "Overview";
        Log.info("1. Navigate to Dashboard login page");
        Log.info("2.  Login with valid account");
        loginPage.login(Constant.ACCOUNT);
        Log.info("3.  Go to Global Setting -> Add page");
        Log.info("4.  Enter Page Name field");
        Log.info("5.  Click OK button");
        generalPage.addPage(pageName,parent,number,afterPage);
        String actualResult = generalPage.getNamePageBesideOverview();
        String expectedResult = pageName;
        Assert.assertEquals(actualResult,expectedResult,"New page is not displayed beside Overview page");
        generalPage.deleteNewlyAddedPage();
        DriverManager.clickOkAlert();
    }

    @Test
    public void TC17() throws InterruptedException {
        Log.info("TC17: Verify that user can remove any main parent page except 'Overview' page successfully and the order of pages stays persistent as long as there is not children page under it");
        String parentName = "Test";
        String childName = "Test Child";
        String parent = "Select parent";
        String number = "1";
        String afterPage = "Overview";
        String selectPage = "Select page";
        Log.info("1. Navigate to Dashboard login page");
        Log.info("2. Log in specific repository with valid account");
        loginPage.login(Constant.ACCOUNT);
        Log.info("3. Add a new parent page");
//        generalPage.addPage(parentName,parent,number,afterPage);
        DriverManager.refreshCurrentPage();
        Log.info("4.  Add a children page of newly added page");
//        generalPage.addPage(childName,parentName,number,selectPage);
        DriverManager.refreshCurrentPage();
        Log.info("5. Click on parent page");
        generalPage.gotoParentPage(parentName);
        Log.info("6. Click delete link");
        generalPage.deleteNewlyAddedPage();
        Log.info("7. Check confirm message 'Are you sure you want to remove this page?' appear");
        String actualMessage1 = DriverManager.getAlertMessage();
        String expectedMessage1 = "Are you sure you want to remove this page?";
        Assert.assertEquals(actualMessage1,expectedMessage1,"message on alert does not appear");
        Log.info("8. Click Ok button");
        DriverManager.clickOkAlert();
        Log.info("9. Check warning message 'Can not delete page 'Test' since it has children page(s)' appears");
        String actualMessage2 = DriverManager.getAlertMessage();
        String expectedMessage2 = "Cannot delete page 'Test' since it has child page(s).\n";
        Assert.assertEquals(actualMessage2,expectedMessage2,"message on alert does not appear");
        Log.info("10. Click Ok button");
        DriverManager.clickOkAlert();
        Log.info("11. Click on children page");
        generalPage.gotoChildrenPage(parentName);
        Log.info("12. Click Delete link");
        generalPage.deleteNewlyAddedPage();
        Log.info("13. Check confirm message 'Are you sure you want to remove this page?' appears");
        String actualMessage3 = DriverManager.getAlertMessage();
        String expectedMessage3 = "Are you sure you want to remove this page?";
        Assert.assertEquals(actualMessage3,expectedMessage3,"message on alert does not appear");
        Log.info("14. Click OK button");
        DriverManager.clickOkAlert();
        Log.info("15. Check children page is deleted");
        DriverManager.refreshCurrentPage();
        Boolean actualResult1 = generalPage.checkChildrenPageDisplay(parentName);
        Log.info(String.valueOf(actualResult1));
        Assert.assertTrue(actualResult1);
        Log.info("16. Click on Parent page");
        generalPage.gotoParentPage(parentName);
        Log.info("17. Click Delete link");
        generalPage.deleteNewlyAddedPage();
        Log.info("18. Check confirm message 'Are you sure you want to remove this page?' appears");
        String actualMessage4 = DriverManager.getAlertMessage();
        String expectedMessage4 = "Are you sure you want to remove this page?";
        Assert.assertEquals(actualMessage4,expectedMessage4,"message on alert does not appear");
        Log.info("19. Click OK button");
        DriverManager.clickOkAlert();
        Log.info("20. Check parent page is deleted");
        DriverManager.refreshCurrentPage();
        Boolean actualResult2 = generalPage.checkParentPageDisplay(parentName);
        Assert.assertTrue(actualResult2,"parent page still appear");
        Log.info("21. Click on 'Overview' page");
        generalPage.gotoParentPage("Overview");
        Log.info("22. Check 'Delete' link disappears");
        Boolean actualResult3 = generalPage.checkSettingOptionDisplay(GlobalSettingOptions.DELETE.getSettingOption());
        Assert.assertTrue(actualResult3,"Delete link still appear");
    }

}
