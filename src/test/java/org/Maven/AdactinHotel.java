package org.Maven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdactinHotel {
public static void main(String[] args) throws AWTException, InterruptedException {
	System.setProperty("Webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\Driver\\chromedriver.exe");
	WebDriver url = new ChromeDriver();
	url.get("https://adactinhotelapp.com/");url.manage().window().maximize();
	
	WebElement usr = url.findElement(By.id("username"));
	usr.sendKeys("8122228398");
	WebElement ps = url.findElement(By.id("password"));
	ps.sendKeys("XN4Y57",Keys.ENTER);
	
	Thread.sleep(2000);
	
	WebElement Location = url.findElement(By.id("location"));
	Select loc = new Select(Location);
	loc.selectByValue("Los Angeles");
	WebElement Hotel = url.findElement(By.id("hotels"));
	Select htl = new Select(Hotel);
	htl.selectByVisibleText("Hotel Sunshine");
	WebElement RoomType = url.findElement(By.id("room_type"));
	Select rt = new Select(RoomType);
//	rt.selectByValue("Super Deluxe");
	rt.selectByIndex(3);
	WebElement RoomNos = url.findElement(By.id("room_nos"));
	Select rnos = new Select(RoomNos);
	rnos.selectByValue("1");
	WebElement CiD = url.findElement(By.id("datepick_in"));
	CiD.sendKeys("20/10/2023");
	WebElement CoD = url.findElement(By.id("datepick_out"));
	CoD.sendKeys("25/10/2023");
	WebElement AdultPerRoom = url.findElement(By.id("adult_room"));
	Select apr = new Select(AdultPerRoom);
	apr.selectByValue("2");
	WebElement ChildrenPerRoom = url.findElement(By.id("child_room"));
	Select cpr = new Select(ChildrenPerRoom);
	cpr.selectByValue("0");Thread.sleep(2000);
	WebElement Srch = url.findElement(By.id("Submit"));
	Srch.click();
	
	WebElement RdoBtn = url.findElement(By.id("radiobutton_0"));
	RdoBtn.click();Thread.sleep(2000);
	WebElement Ctnu = url.findElement(By.id("continue"));
	Ctnu.click();
//	Actions a = new Actions(url);
	WebElement FirstName = url.findElement(By.id("first_name"));
//	a.keyDown(Keys.SHIFT).sendKeys(FirstName,"jaffir").keyUp(Keys.SHIFT).perform();Thread.sleep(1000);
	FirstName.click();
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_SHIFT);
	r.keyPress(KeyEvent.VK_J);
	r.keyRelease(KeyEvent.VK_J);
	r.keyPress(KeyEvent.VK_A);
	r.keyRelease(KeyEvent.VK_A);
	r.keyPress(KeyEvent.VK_F);
	r.keyRelease(KeyEvent.VK_F);	
	r.keyPress(KeyEvent.VK_F);
	r.keyRelease(KeyEvent.VK_F);
	r.keyPress(KeyEvent.VK_I);
	r.keyRelease(KeyEvent.VK_I);
	r.keyPress(KeyEvent.VK_R);
	r.keyRelease(KeyEvent.VK_R);
	r.keyRelease(KeyEvent.VK_SHIFT);
	
	Thread.sleep(2000);
	
	WebElement LastName = url.findElement(By.id("last_name"));
	LastName.sendKeys("NOOR");

	
	
	
	WebElement BillingAddress = url.findElement(By.id("address"));
	BillingAddress.sendKeys("115/1,\nPlotNo: 67,\nSenthur Nagar, 7th Street,\nKalugumalai.");
	WebElement ccno = url.findElement(By.id("cc_num"));
	ccno.sendKeys("1234567890123456");
	
	WebElement CcType = url.findElement(By.id("cc_type"));
	Select cct = new Select(CcType);
	cct.selectByValue("AMEX");
	
	WebElement Edm = url.findElement(By.id("cc_exp_month"));
	Select em = new Select(Edm);
	em.selectByValue("12");
	WebElement Edy = url.findElement(By.id("cc_exp_year"));
	Select ey = new Select(Edy);
	ey.selectByValue("2023");
	WebElement CvvNumber = url.findElement(By.id("cc_cvv"));
	CvvNumber.sendKeys("1372");
	WebElement BkNw = url.findElement(By.id("book_now"));
	BkNw.click();
	Thread.sleep(3000);

	String t = url.getTitle();
	System.out.println(t);
	Thread.sleep(2000);
	
	WebElement OId = url.findElement(By.xpath("//input [@id=\"order_no\"]"));
	String oId = OId.getAttribute("value");
	System.out.println("Order Id: "+oId);
	Thread.sleep(3000);

	url.close();

}
}
