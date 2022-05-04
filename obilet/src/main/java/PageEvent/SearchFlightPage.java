package PageEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.FlightVariables;

import java.util.List;
import java.util.Random;

public class SearchFlightPage extends AbstractPage{
    WebDriver driver;
    public String listFlightCode;
    public WebElement listingFlightCode;
    public String listReturnFlightCode;
    public WebElement listingReturnFlightCode;

    public SearchFlightPage(){
        driver = Driver.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = FlightVariables.FLIGHT_TICKET_BUTTON)
    private WebElement flightTicketButton;

    public void flightButtonClick(){
        clickFunction(flightTicketButton);
    }

    @FindBy(css = FlightVariables.POPUP)
    private WebElement popupElement;

    public void closePopup(){
        clickFunction(popupElement);
    }

    @FindBy(id = FlightVariables.CLICK_DEPARTURE)
    private WebElement selectDeparture;

    @FindBy(id = FlightVariables.SEARCH_DEPARTURE)
    private WebElement searchTextDeparture;

    @FindBy(xpath = FlightVariables.SELECT_DEPARTURE)
    private WebElement selectedDepartureText;

    public void selectDeparture(){
        clickFunction(selectDeparture);
        sendKeysFunction(searchTextDeparture, "İstanbul");
        waitSeconds(3);
        clickFunction(selectedDepartureText);
    }

    @FindBy(id = FlightVariables.CLICK_DESTINATION)
    private WebElement selectDestination;

    @FindBy(id = FlightVariables.SEARCH_DESTINATION)
    private WebElement searchTextDestination;

    @FindBy(xpath = FlightVariables.SELECT_DESTINATION)
    private WebElement selectedDestinationText;

    public void selectDestination(){
        clickFunction(selectDestination);
        sendKeysFunction(searchTextDestination, "Antalya");
        waitSeconds(3);
        clickFunction(selectedDestinationText);
    }

    @FindBy(id = FlightVariables.DEPARTURE_DATE)
    private WebElement departureDate;

    public void selectDepartureDate(){
        clickFunction(departureDate);
        List<WebElement> days = driver.findElements(By.xpath( "//ob-datepicker[@id='departure']//div[@class='calendar-left']//button[@class='week in']"));
        Random calendarSize = new Random();
        int departureDay = calendarSize.nextInt(days.size())+1;
        waitSeconds(2);
        clickElementByXpath(FlightVariables.SELECT_DEPARTURE_DATE + "["+ departureDay +"]");
    }

    @FindBy(id = FlightVariables.RETURN_DATE)
    private WebElement returnDate;

    @FindBy(id = FlightVariables.ONE_WAY)
    private WebElement oneWay;

    public void selectReturnDate(){
        clickFunction(oneWay);
        List<WebElement> days = driver.findElements(By.xpath( "//ob-datepicker[@id='return']//div[@class='calendar-right']//button[@class='week in']"));
        Random calendarSize = new Random();
        int returnDay = calendarSize.nextInt(days.size())+1;
        waitSeconds(2);
        clickElementByXpath((FlightVariables.SELECT_RETURN_DATE + "["+ returnDay +"]" ));
    }

    @FindBy(id = FlightVariables.SEARCH_FLIGHT)
    private WebElement flightSearchButton;

    public void clickFlightSearch(){
        clickFunction(flightSearchButton);
    }

    @FindBy(id = FlightVariables.DEPARTURE_LIST)
    private WebElement departureList;
    @FindBy(css = FlightVariables.ECO_DEPARTURE_LIST)
    private WebElement ecoDeparture;
    public void checkFlightList(){
        waitSeconds(5);
        Assert.assertEquals(departureList,departureList);
        System.out.println("Gidiş Uçuşları Listelendi");
        List<WebElement> list = driver.findElements(By.cssSelector("#outbound-journeys .one-way"));
        Random rnd = new Random();
        int rndFlight = rnd.nextInt(list.size()) + 1;
        WebElement promotion = driver.findElement(By.cssSelector("ul#outbound-journeys > li:nth-child(" + rndFlight + ") > div:nth-child(1) > ul > li > div.warning"));
        waitSeconds(5);
        WebElement departureFlightDetail = driver.findElement(By.cssSelector("ul#outbound-journeys > li:nth-child("+rndFlight+") > div.journey > div.price > button"));
        clickFunction(departureFlightDetail);
        waitSeconds(4);
        String airLine = driver.findElement(By.cssSelector(FlightVariables.AIRLINE)).getText();
        listingFlightCode = driver.findElement(By.cssSelector(".code > strong:nth-child(2)"));
        listFlightCode =  airLine +" - "+ listingFlightCode.getText();
        System.out.println(listFlightCode);
        System.out.println("------");
        clickFunction(closeFlightDetail);
        WebElement dpFlight = driver.findElement(By.cssSelector("ul#outbound-journeys > li:nth-child(" + rndFlight + ") > div.journey > ul > li:nth-child(1)"));
        waitSeconds(5);
        clickFunction(dpFlight);
        if (promotion.getText().equals("Promosyonlu")) {
            clickFunction(driver.findElement(By.cssSelector("#outbound-journeys > li > div.details.row > ul > li > ul > li > div.fly-container > div.fly-content-container.EF > div.price")));
        }
    }

    @FindBy(id = FlightVariables.RETURN_LIST)
    private WebElement returnList;
    @FindBy(css = FlightVariables.ECO_RETURN_LIST)
    private WebElement ecoReturn;
    public void checkReturnFlightList(){
        waitSeconds(5);
        Assert.assertEquals(returnList,returnList);
        System.out.println("Dönüş Uçuşları Listelendi");
        List<WebElement> list = driver.findElements(By.cssSelector("#return-journeys .one-way"));
        Random rnd = new Random();
        int rndFlight = rnd.nextInt(list.size()) + 1;
        WebElement promotion = driver.findElement(By.cssSelector("ul#return-journeys > li:nth-child(" + rndFlight + ") > div:nth-child(1) > ul > li > div.warning"));
        waitSeconds(5);
        WebElement returnFlightDetail = driver.findElement(By.cssSelector("ul#return-journeys > li:nth-child("+rndFlight+") > div.journey > div.price > button"));
        clickFunction(returnFlightDetail);
        waitSeconds(4);
        String airLine = driver.findElement(By.cssSelector(FlightVariables.AIRLINE)).getText();
        listingReturnFlightCode = driver.findElement(By.cssSelector(".code > strong:nth-child(2)"));
        listReturnFlightCode =  airLine +" - "+ listingReturnFlightCode.getText();
        System.out.println(listReturnFlightCode);
        clickFunction(closeFlightDetail);
        waitSeconds(3);
        WebElement rtFlight = driver.findElement(By.cssSelector("ul#return-journeys > li:nth-child(" + rndFlight + ") > div.journey > ul > li:nth-child(1)"));
        waitSeconds(5);
        clickFunction(rtFlight);
        waitSeconds(3);
        if (promotion.getText().equals("Promosyonlu")) {
            clickFunction(driver.findElement(By.cssSelector("#return-journeys > li > div.details.row > ul > li > ul > li > div.fly-container > div.fly-content-container.EF > div.price")));
        }
    }
    @FindBy(css = FlightVariables.LISTING_FLIGHT_CODE)
    private WebElement flightCode;

    @FindBy(css = FlightVariables.CLOSE_FLIGHT_DETAIL)
    private WebElement closeFlightDetail;

    public void checkPaymentPage(){
        waitSeconds(7);
        Assert.assertEquals(driver.getTitle(),FlightVariables.PAYMENT_TITLE);
        System.out.println("---------");
        System.out.println("Ödeme Sayfası Açıldı");
    }

    public void checkTicket() {
        waitSeconds(7);
        WebElement departureTicketControl = driver.findElement(By.cssSelector(FlightVariables.PAYMENT_DEPARTURE_FLIGHT_CODE));
        System.out.println(departureTicketControl.getText());
        waitSeconds(5);
        WebElement returnTicketControl = driver.findElement(By.cssSelector(FlightVariables.PAYMENT_RETURN_FLIGHT_CODE));
        System.out.println(returnTicketControl.getText());
        waitSeconds(5);
        Assert.assertEquals(departureTicketControl.getText(),listFlightCode);
        Assert.assertEquals(returnTicketControl.getText(),listReturnFlightCode);
        waitSeconds(3);
    }

}
