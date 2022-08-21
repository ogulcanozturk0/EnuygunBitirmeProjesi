package testscenarios;

import framework.ConfigReader;
import framework.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;


public class Flight {
    static WebDriver driver;
    static Properties properties;
    Flight flight;
    @BeforeClass
    public void setup(){

        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver("chrome");
        flight = new Flight();
        driver.get(driver.getCurrentUrl());
    }

    @Test(priority = 1)
    public void originTest() throws InterruptedException {

        WebElement originButton = driver.findElement(By.id("OriginInput"));
        originButton.click();
        originButton.sendKeys("İstanbul");

        //List< WebElement > originList = driver.findElements(By.xpath("//*[@id=\"react-autowhatever-OriginInput\"]"));
        //System.out.println(" Toplam " + " " +originList.size());
        WebElement originPicker = driver.findElement(By.xpath("//*[@id=\"react-autowhatever-OriginInput-section-0-item-0\"]"));
        originPicker.click();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void destinationTest() throws InterruptedException {
        WebElement destinationButton = driver.findElement(By.xpath(" //*[@id=\"DestinationInput\"] "));
        destinationButton.click();
        destinationButton.sendKeys(" Amsterdam ");

        WebElement destinationPicker = driver.findElement(By.xpath(" //*[@id=\"react-autowhatever-DestinationInput-section-0-item-0\"]/div "));
        destinationPicker.click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void departureDayTest() throws InterruptedException {
       WebElement departureDay = driver.findElement(By.id(" DepartureDate "));
        departureDay.click();

        WebElement td = driver.findElement(By.cssSelector(" .CalendarDay__today_3  "));

        td.click();

        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void returnDay() throws InterruptedException {
        WebElement returnDay = driver.findElement(By.id(" ReturnDate "));
        returnDay.click();

        WebElement rd = driver.findElement(By.xpath(" //*[@id=\"FlightSearchForm\"]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/table/tbody/tr[5]/td[2] "));
        rd.click();
        Thread.sleep(1000);
    }

    @Test(priority = 5)
    public void clickButton() throws InterruptedException {
        WebElement ubb = driver.findElement(By.xpath(" //*[@id=\"FlightSearchForm\"]/div/div[3]/div[2]/button "));
        ubb.click();
    }

    @Test(priority = 6)
    public void selectTicket() throws InterruptedException {
        WebElement departureTicket = driver.findElement(By.xpath("//*[@id=\"SearchRoot\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/label"));
        departureTicket.click();
        Thread.sleep(1000);

        WebElement returnTicket = driver.findElement(By.xpath("//*[@id=\"SearchRoot\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/label[1]"));
        returnTicket.click();
    }

    @Test(priority = 7)
    public void selectButton(){
        WebElement selectBtn = driver.findElement(By.id("tooltipTarget_0"));
        selectBtn.click();
    }
}
