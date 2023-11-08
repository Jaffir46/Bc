package org.Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
public static void main(String[] args) {
	System.setProperty("Webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\Driver\\chromedriver.exe");
	WebDriver drop = new ChromeDriver();
	Navigation n = drop.navigate();
	n.to("https://demo.guru99.com/test/drag_drop.html"); 
	drop.manage().window().maximize();
	WebElement s1 = drop.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
	WebElement d1 = drop.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
	
	WebElement s2 = drop.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
	WebElement d2 = drop.findElement(By.xpath("(//li[@class='placeholder'])[2]"));

	WebElement s3 = drop.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
	WebElement d3 = drop.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
	
	WebElement s4 = drop.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
	WebElement d4 = drop.findElement(By.xpath("(//li[@class='placeholder'])[4]"));
	Actions a = new Actions(drop);
	a.dragAndDrop(s1, d1).perform();
	a.dragAndDrop(s2, d2).perform();
	a.dragAndDrop(s3, d3).perform();
	a.dragAndDrop(s4, d4).perform();

}
}
