package org.Maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Bc {
static WebDriver driver;

public static void LaunchBrowser() {
	driver = new ChromeDriver();}

public static void MaxWindow() {
	driver.manage().window().maximize();}

public static void GetUrl(String url) {
	driver.get(url);}

public static void SendKeysEnter(WebElement element , String s) {
	VisibilityOfElement(element);
	element.sendKeys(s,Keys.ENTER);}

public static void SendKeys(WebElement element , String s) {
	VisibilityOfElement(element);
	element.sendKeys(s);}

public static String GetTitle() {
	String title = driver.getTitle();
	return title;}

public static String GetUrlText() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;}

public static void Close() {
	driver.close();}

public static void Quit() {
	driver.quit();}

public static void Click(WebElement element) {
	VisibilityOfElement(element);
	element.click();}

public static void Clear(WebElement element) {
	VisibilityOfElement(element);
	element.clear();}

public  static String GetText(WebElement element) {
	VisibilityOfElement(element);
	String text = element.getText();
	System.out.println(text);
	return text;}

public static WebElement ByName(String Avalue) {
	WebElement e = driver.findElement(By.name(Avalue));
	return e;
}

public static WebElement ById(String Avalue) {
	WebElement e = driver.findElement(By.id(Avalue));
	return e;
}

public static WebElement ByClassName(String Avalue) {
	WebElement e = driver.findElement(By.className(Avalue));
	return e;
}

public static WebElement ByXpath(String Xpth) {
	WebElement e = driver.findElement(By.xpath(Xpth));
	return e;
}

public static String GetAttribute(WebElement element , String value) {
	VisibilityOfElement(element);
	String attribute = element.getAttribute(value);
	return attribute;
}

public static void SelectByText(WebElement element , String text) {
	VisibilityOfElement(element);
	Select s = new Select(element);
	s.selectByVisibleText(text);
}

public static void SelectByIndex(WebElement element, int index) {
	VisibilityOfElement(element);
	Select s = new Select(element);
	s.selectByIndex(index);
}

public static void SelectByValue(WebElement element, String value) {
	VisibilityOfElement(element);
	Select s = new Select(element);
	s.selectByValue(value);
}

public static void JsSendKeys(WebElement element, String text) {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
//	executor.executeScript(text, element);
	executor.executeScript("arguments[0].setAttribute('value'+'"+text+"');", element);

}

public static void Screenshot(WebElement element, String text) throws WebDriverException, IOException {
	VisibilityOfElement(element);
	Files.copy(element.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\SrnShot\\new.png"));
}
public static void VisibilityOfElement(WebElement element) {
	WebDriverWait voe  = new WebDriverWait(driver, Duration.ofSeconds(30));
	voe.until(ExpectedConditions.visibilityOf(element));
}

public static void ImplicitWait(int sec) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}

public static boolean isEnabled(WebElement element) {
	VisibilityOfElement(element);
	boolean enabled = element.isEnabled();
	return enabled;
}

public static boolean isDisplayed(WebElement element) {
	VisibilityOfElement(element);
	boolean displayed = element.isDisplayed();
	return displayed;
}

public static String GetCell(String sn, int rn, int cn ) throws IOException {
	String s =" ";
	File file = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\ExcelSheets\\New.xlsx");
	FileInputStream fis = new  FileInputStream(file);
	@SuppressWarnings("resource")
	Workbook wb = new XSSFWorkbook(fis);
	Sheet sheet = wb.getSheet(sn);
	Row row = sheet.getRow(rn);
	Cell cell = row.getCell(cn);
	CellType cellType = cell.getCellType();
	switch (cellType) {
	case STRING:
		s = cell.getStringCellValue();
		break;
	case NUMERIC:
		if (DateUtil.isCellDateFormatted(cell)) {
			Date dcv = cell.getDateCellValue();
			SimpleDateFormat sdf =  new SimpleDateFormat("dd/mm/yy");
			s=sdf.format(dcv);
		}else {
			double ncv = cell.getNumericCellValue();
			long check = Math.round(ncv);
			if (check==ncv) {
				s=String.valueOf(check);
			}else {
				s=String.valueOf(ncv);
			}
		}
		break;

	default:
		break;
	}return s;
}

public void UpdateCellData(String sn, int rn, int cn, String old, String update ) throws IOException {
	File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\ExcelSheets\\Login.xlsx");
	FileInputStream fis = new FileInputStream(f);
	@SuppressWarnings("resource")
	Workbook wb = new XSSFWorkbook(fis);
	Sheet ss = wb.getSheet(sn);
	Row r = ss.getRow(rn);
	Cell c = r.getCell(cn);
	String sv = c.getStringCellValue();
	if (sv.equals(old)) {
		c.setCellValue(update);
	}
	FileOutputStream fos =  new FileOutputStream(f);
	wb.write(fos);
}

public void CreateCellAndSetCellData(String sn, int rn, int cn, String data) throws IOException {
	File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject\\ExcelSheets\\Login.xlsx");
	FileInputStream fos = new FileInputStream(f);
	@SuppressWarnings("resource")
	Workbook wb = new XSSFWorkbook(fos);
	Sheet ss = wb.getSheet(sn);
	Row r = ss.getRow(rn);
	Cell c = r.createCell(cn);
	c.setCellValue(data);
	FileOutputStream fos1 = new FileOutputStream(f);
	wb.write(fos1);
}

}
