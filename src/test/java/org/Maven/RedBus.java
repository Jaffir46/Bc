package org.Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("Webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace\\Automation\\Driver\\chromedriver.exe");
	WebDriver url = new ChromeDriver();
	url.get("https://www.redbus.com/");
	url.manage().window().maximize();
	
	String s = url.getTitle();
	System.out.println("Title: "+s);
	String ss=url.getCurrentUrl();
	System.out.println("Url: "+ss);
	
	WebElement from = url.findElement(By.id("src"));
	from.sendKeys("Kalugumalai");
	Thread.sleep(1000);
	WebElement to = url.findElement(By.id("dest"));
	to.sendKeys("koyambedu");
	Thread.sleep(1000);
	WebElement ok = url.findElement(By.xpath("//button[contains(text(),'Okay')]"));ok.click();
	Thread.sleep(1000);
	
	WebElement df = url.findElement(By.xpath("//div[@id=\"date-box\"]"));
	df.click();
	Thread.sleep(1000);
	WebElement sl1 = url.findElement(By.xpath("//span[contains(text(),'13')][1]"));
	sl1.click();
	Thread.sleep(1000);
	
	WebElement dr = url.findElement(By.xpath("//div[contains(@class,'returndate input-box ')]"));
	dr.click();
	Thread.sleep(1000);
	WebElement sl2 = url.findElement(By.xpath("//span[contains(text(),'15')][1]"));
	sl2.click();
	Thread.sleep(1000);
	WebElement srch = url.findElement(By.xpath("//div[contains(text(),'SEARCH')]"));
	srch.click();
	Thread.sleep(5000);	
	
	WebElement x = url.findElement(By.xpath("//i[contains(@class,'icon icon-close')]"));x.click();
	Thread.sleep(2000);	
WebElement vs = url.findElement(By.xpath("//div[contains(@class,'button view-seats fr')][1]"));
vs.click();

}
}
