package org.example.booking;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class Booking_HomeTest1 {

    Booking_Home booking_home = new Booking_Home();


    @Test
    void getHomePage() {
        booking_home.getHomePage(booking_home.driver, booking_home.data.url);
        assertEquals("Booking.com | Official site | The best hotels, flights, car rentals & accommodations",booking_home.driver.getTitle());
    }

    @Test
    void setDestination() {
        booking_home.getHomePage(booking_home.driver, booking_home.data.url);
        booking_home.setDestination(booking_home.driver, booking_home.data.sity);
        booking_home.setDates(booking_home.driver, "December 2022");

        String newUrl = booking_home.driver.getCurrentUrl();

        WebDriver driver1 = new ChromeDriver();
        driver1.get(newUrl);


        String s = driver1.findElement(By.xpath("//div[@class=\"efdb2b543b\"]")).getText();
        if (s.contains("New York"))
            s = "New York";
        else
            s=driver1.findElement(By.xpath("//div[@class=\"efdb2b543b\"]")).getText();

        assertEquals("New York",s);



    }

    @Test
    void setDates() {
        booking_home.getHomePage(booking_home.driver, booking_home.data.url);
        booking_home.setDestination(booking_home.driver, booking_home.data.sity);
        booking_home.setDates(booking_home.driver, "December 2022");

        String newUrl = booking_home.driver.getCurrentUrl();

        WebDriver driver1 = new ChromeDriver();
        driver1.get(newUrl);

        String  e1 =driver1.findElement(By.xpath("//button[@data-testid=\"date-display-field-start\"]")).getText();
        String  e2 =driver1.findElement(By.xpath("//button[@data-testid=\"date-display-field-end\"]")).getText();

        if (e1.contains("1 December 2022") && e2.contains("30 December 2022")){
            e1 = "1 December 2022";
            e2 = "30 December 2022";
        } else {
            e1 = "null";
            e2 = "null";
        }

        assertEquals("1 December 2022",e1);
        assertEquals("30 December 2022",e2);
    }
}