package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPage{

    public CommonPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    private EventsPage eventsPage;

    public EventsPage getEventsPage() {
        if (eventsPage == null) {
            eventsPage = new EventsPage();
        }
        return eventsPage;
    }

}
