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

}
