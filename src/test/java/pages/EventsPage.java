package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Events;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventsPage extends CommonPage{

@FindBy(xpath = "//div[@class='Navbar_linkContainer__2jWIM']//a[.='Login']")
    public WebElement loginModule;
@FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;
@FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;
@FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
@FindBy(xpath = "//a[.='Events']")
    public WebElement eventModule;
@FindBy(xpath = "//button[.='Scheduled Events']")
    public WebElement scheduledEventsButton;
@FindBy(xpath = "//button[.='Registered Events']")
    public WebElement registeredEventsButton;
@FindBy(xpath = "(//div[contains(@class,'Scheduled')])[1]//h6[contains(text(),'Date:')]")
    public WebElement date;
@FindBy(xpath = "//button[.='Attended Events']")
    public WebElement attendedEventsButton;
@FindBy(xpath = "//div[@class='ScheduledEvents_boxDiv__2ixVx']")
    public List <WebElement> scheduledEventsChart;

@FindBy(xpath = "(//button[.='Register'])[1]")
    public WebElement registerButton;
@FindBy(xpath = "//h2[.='Event Registration']")
    public WebElement eventRegistrationTitle;
@FindBy(xpath = "//input[@placeholder='Enter your zip code']")
    public WebElement zipCodeInputBox;
@FindBy(xpath = "//button[.='go']")
    public WebElement goButton;
@FindBy(xpath = "//h5[@class='text-center text-warning mt-3']")
    public List<WebElement> scheduledEventsTitles;
    @FindBy(xpath = "//div[@class='attendedEvents_boxDiv__vY473 row p-0']//h6[contains(text(),'Available Seat:')]")
    public List<WebElement> registeredEventsChart;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement button_Cancel;
    @FindBy(xpath = "//div//h6[contains(text(),'Available')]/../..//h5")
    public List<WebElement> registeredEventsTitles;
    @FindBy(xpath = "(//button[text()='No'])[1]")
    public WebElement button_CancelNo;
    @FindBy(xpath = "(//button[text()='Yes'])[1]")
    public WebElement button_CancelYes;
    @FindBy(xpath = "//div[contains(@class,'attendedEvents')]")
    public List<WebElement> attendedEventsChart;
    @FindBy(xpath = "//h5[@class='row justify-content-center text-warning']")
    public List<WebElement> attendedEventsTitles;

    @FindBy(xpath = "//h6[contains(text(),'Date:')]")
    public List<WebElement> attendedEventsDate;

}
