package stepDefinitions;


import enums.ClientEnum;
import enums.Enum_Fy;
import enums.USER_INFO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.DB_utilities;
import utilities.Driver;
import utilities.ReusableMethods;



import static base_url.BaseUrlQuestionner.therapistSetup;
import java.util.HashMap;
import java.util.Map;

import static base_url.baseUrl_fy.hypnotesSetUp1;

import static base_url.HypnotesBaseUrl.hypnotesSetUpFormData;
import static base_url.HypnotesBaseUrl.hypnotesSetUpFormDataForGroupSession;

import static base_url.baseUrl_fy.hypnotesSetUp1;

import static base_url.baseUrl_fy.hypnotesSetUp1;
import static base_url.couponURL.therapistLogin;
import static io.restassured.RestAssured.given;

//import static utilities.Authentication.generatePhpSessid;


public class Hooks {
    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Actions actions;

    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;
    public static Response response;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before(order = 1, value = "@UI")
    public void setup() {

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();

    }


    @Before("@DB")
    public void setupDatabase() {
        DB_utilities dbUtilities=new DB_utilities();
        dbUtilities.getConnection();

    }

    @After("@DB")
    public void closeDatabase() {
        DB_utilities dbUtilities=new DB_utilities();
        dbUtilities.tearDatabase();

    }

    @Before("@user1")
    public void denemeLogin() {
        System.out.println(
                "email : " + ConfigurationReader.getProperty("user1_email") +
                        " password : " + ConfigurationReader.getProperty("user1_password")
        );


    }

    @After("@user1")
    public void denemeLogout() {
        System.out.println("log out");
    }



    @Before("@TherapistLoginUSA")
    public void ThrerapistLogInUSA(){
        commonPage.getLoginPage().ThrerapistLogIn(
                ConfigurationReader.getProperty("therapistEmailUSA"),
                ConfigurationReader.getProperty("therapistPasswordUSA")
        );
    }

    @Before("@Therapist")
    public void ThrerapistLogIn(){
//       commonPage.getLoginPage().ThrerapistLogIn(
//               ConfigurationReader.getProperty("therapistEmail"),
//               ConfigurationReader.getProperty("therapistPassword")
//       );
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
       // commonPage.getLoginPage().ThrerapistLogIn(USER_INFO.THERAPIST_CREDENTIALS.getTherapist_email(), USER_INFO.THERAPIST_CREDENTIALS.getTherapist_password());

        try{
          //  ReusableMethods.waitForVisibility(commonPage.getDashboardPage().timeZonePopUp_yesButton,10);
       //     commonPage.getDashboardPage().timeZonePopUp_yesButton.click();
        }catch (Exception e){
            System.out.println("Not found timezone pop up");
        }
   }

    

    @Before("@Client")
    public void ClientLogInUSA() {
        commonPage.getLoginPage().ThrerapistLogIn(
                ConfigurationReader.getProperty("clientEmailUSA"),
                ConfigurationReader.getProperty("clientPasswordUSA")
        );
    }

    @Before("@Profile")
    public void therapisteLogin() {
        driver.get(ConfigurationReader.getProperty("hypnotes"));
        commonPage.getLoginPage().Login.click();
        commonPage.getLoginPage().ButtonEMAILFORLOGIN.sendKeys(Enum_Fy.THERAPIST.getUsername());
        commonPage.getLoginPage().PasswordButton.sendKeys(Enum_Fy.THERAPIST.getPassword());
        commonPage.getLoginPage().LoginButtonforSignIn.click();

    }

    @Before("@ProfileGeneral")
        public void therapisteGeneralLogin() {
            driver.get(ConfigurationReader.getProperty("hypnotes"));
            commonPage.getLoginPage().Login.click();
            commonPage.getLoginPage().ButtonEMAILFORLOGIN.sendKeys(Enum_Fy.THERAPISTGENERAL.getUsername());
            commonPage.getLoginPage().PasswordButton.sendKeys(Enum_Fy.THERAPISTGENERAL.getPassword());
            commonPage.getLoginPage().LoginButtonforSignIn.click();

    }


      @Before("@API_F")
      public void setUpToken() {
          hypnotesSetUpFormData();
          hypnotesSetUpFormDataForGroupSession();
      }
    @Before("@fatma")
    public void fatmaSetupApi() {

    }
    @Before("@ApiClientLogin")
    public void loginAsClient(){
        apiLoginAsClient(ClientEnum.CLIENT_CREDENTIALS);
    }

    @Before("@TherapistQuick")
    public void therapistLogIn() {
        commonPage.getLoginPage().ThrerapistLogIn(USER_INFO.THERAPIST_CREDENTIALS.getTherapist_email(), USER_INFO.THERAPIST_CREDENTIALS.getTherapist_password());
        if (driver.getCurrentUrl().toLowerCase().endsWith("dashboard")) {
            try {
                ReusableMethods.waitForVisibility(commonPage.getDashboardPage().timeZonePopUp_yesButton, 10);
                commonPage.getDashboardPage().timeZonePopUp_yesButton.click();
            } catch (Exception e) {
                System.out.println("Not found timezone pop up");
            }
        }
    }
    @Before(value = "@API")//API tag'ina sahip feature file'larda bu methodu (hypnotesSetUp) calistir
    public  void setUpAPI(){
        hypnotesSetUp1();//cagirdigimiz methodu import ettik
    }
    @Before("@TherapistFtm")
    public void therapistLoginFtm(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        commonPage.getLoginPage().ThrerapistLogIn(Enum_Fy.THERAPISTLOGIN.getUsername(),Enum_Fy.THERAPISTLOGIN.getPassword());
        /*try {
            ReusableMethods.waitForVisibility(commonPage.getDashboardPage().timeZonePopUp_yesButton,10);
            commonPage.getDashboardPage().timeZonePopUp_yesButton.click();
        }catch (Exception e){
            System.out.println("Not found timezone pop up");
        }*/

    }

    @Before("@TherapistQuestionnaire")
    public void therapistLoginGul(){
        therapistSetup();
        System.out.println("Api before cookie  ");
    }
    @Before("@TherapistCoupon")
    public void therapistSet(){
        therapistLogin();

    }


    public void apiLoginAsClient(ClientEnum clientInfo){
        Map<String,Object> requestBody =new HashMap<>();
        requestBody.put("username", clientInfo.getEmail());
        requestBody.put("password", clientInfo.getPassword());

        response=given()
                .header("content-type", "application/json")
                .body(requestBody)
                .post("https://test.hypnotes.net/api/login");

        response.prettyPrint();

    }

}