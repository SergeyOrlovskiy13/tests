package org.example.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Booking_Home {
    public  Data data = new Data();
    public  WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        Booking_Home booking_home = new Booking_Home();

        booking_home.getHomePage(booking_home.driver,  booking_home.data.url);
        booking_home.setDestination(booking_home.driver,  booking_home.data.sity);
        booking_home.setDates(booking_home.driver, "December 2022");


    }

    public void getHomePage(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public  void setDestination(WebDriver driver, String destination) {
        driver.findElement(By.className("sb-destination-label-sr")).sendKeys(destination);
    }

    public  void setDates(WebDriver driver, String month) {
        driver.findElement(By.className("xp__dates-inner"))
                .click();

        while (!driver.findElement(By.className("bui-calendar__month")).getText()
                .equals(month)) {
            driver.findElement(By.xpath("//div[@class='bui-calendar__control bui-calendar__control--next']")).click();
        }
        driver.findElement(By.xpath("//span[@aria-label='1 December 2022']")).click();
        driver.findElement(By.xpath("//span[@aria-label='30 December 2022']")).click();
        driver.findElement(By.className("sb-searchbox__button")).click();
    }
}

