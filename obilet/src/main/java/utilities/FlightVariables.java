package utilities;

public class FlightVariables {
    public static final String FLIGHT_TICKET_BUTTON = "//a[@href='/ucak-bileti']";
    public static final String CLICK_DEPARTURE = "origin";
    public static final String SEARCH_DEPARTURE = "origin-input";
    public static final String SELECT_DEPARTURE = "//*[@id=\"origin\"]/div/ul/li[1]";
    public static final String CLICK_DESTINATION= "destination";
    public static final String SEARCH_DESTINATION = "destination-input";
    public static final String SELECT_DESTINATION = "//*[@id=\"destination\"]/div/ul/li[2]";
    public static final String DEPARTURE_DATE = "departure";
    public static final String SELECT_DEPARTURE_DATE = "(//div[@class='calendar-left']//button[@class='week in'])";
    public static final String RETURN_DATE = "return";
    public static final String ONE_WAY = "one-way";
    public static final String SELECT_RETURN_DATE = "(//div[@class='calendar-right']//button[@class='week in'])";
    public static final String SEARCH_FLIGHT = "search-button";
    public static final String DEPARTURE_LIST = "outbound-journeys";
    public static final String RETURN_LIST = "return-journeys";
    public static final String ECO_RETURN_LIST = "#return-journeys > li > div.details.row > ul > li > ul > li:nth-child(1) > div > div:nth-child(2) > .price";
    public static final String ECO_DEPARTURE_LIST = "#outbound-journeys > li > div.details.row > ul > li > ul > li:nth-child(1) > div > div:nth-child(2) > .price";
    public static final String PAYMENT_TITLE = "Satın Al - obilet.com";
    public static final String AIRLINE = "#journey > div > ul > li > ul > li > div.airline.col > span";
    public static final String LISTING_FLIGHT_CODE = ".code > strong:nth-child(2)";
    public static final String CLOSE_FLIGHT_DETAIL = "button.close:nth-child(4)";
    public static final String PAYMENT_DEPARTURE_FLIGHT_CODE = ".journey > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > strong:nth-child(2)";
    public static final String PAYMENT_RETURN_FLIGHT_CODE = ".journey > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > strong";
    public static final String POPUP = "body > div.cookies-policy > div > a.close";
}
