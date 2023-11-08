package org.Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

import org.junit.*;
public class Junit {
static WebDriver driver;

@BeforeClass
public  static void BeforeClass() {
	driver = new ChromeDriver();
	driver.get("https://omrbranch.com/");
	driver.manage().window().maximize();
}
@AfterClass

@Test
public void Login() {
	WebElement usr = driver.findElement(By.id("email"));
	usr.sendKeys("contactjaffir@gmail.com");
	WebElement pas = driver.findElement(By.id("pass"));
	pas.sendKeys("Jaffir@2699");
	WebElement clk = driver.findElement(By.xpath("//*[@id=\"userLogin\"]/div[5]/button"));
	clk.click();
}
@After
public void After() throws WebDriverException, IOException {
	TakesScreenshot ts = (TakesScreenshot)driver;
	Files.copy(ts.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\SrnShot\\bc.png"));
}
@Before
public void Before() throws WebDriverException, IOException {TakesScreenshot ts = (TakesScreenshot)driver;
Files.copy(ts.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\SrnShot\\ac.png"));
}
}
