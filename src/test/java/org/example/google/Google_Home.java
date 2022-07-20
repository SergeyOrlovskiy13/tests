package org.example.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Home {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        DataGoogle data = new DataGoogle();

        driver.get(data.url);
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"))
                .sendKeys("Booking.com");
        driver.findElement(By.xpath("//input[@class=\"gNO89b\"]")).click();
    }
}
