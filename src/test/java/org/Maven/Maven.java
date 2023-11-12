package org.Maven;

import org.openqa.selenium.WebElement;

public class Maven extends  Bc {
public static void main(String[] args) throws InterruptedException {
	LaunchBrowser();
	GetUrl("https://omrbranch.com/");
	MaxWindow();
	ImplicitWait(40);
	WebElement byId = ById("email");
	SendKeys(byId, "contactjaffir@gmail.com");
	WebElement byName = ByName("pass");
	SendKeys(byName, "Jaffir@2699");
	WebElement byXpath = ByXpath("//*[@id=\"userLogin\"]/div[5]/button");
	Click(byXpath);

	WebElement wlcmtxt = ByXpath("//a[@class='icoTwitter mr-2 dropdown-toggle']");
	GetText(wlcmtxt);	
	
	WebElement srch = ById("search");
	SendKeysEnter(srch, "nuts");
	
	WebElement txt = ByXpath("//h5[@class='sectionTitle font35 font-weight-bold color11']");
	GetText(txt);
	
	
	WebElement kart = ByXpath("//*[@id=\"productResult\"]/div[1]/div/div[3]/a");
	Click(kart);
	WebElement qnty = ByXpath("//*[@id=\"cart-21\"]");
	Click(qnty);
	WebElement gokrt = ByXpath("//a[@class='hover1']");
	Thread.sleep(2000);
	Click(gokrt);
	
	WebElement adrs = ByXpath("/html/body/div[4]/section[2]/div/div[2]/div/div");
	Click(adrs);
	WebElement adrstype = ByXpath("//*[@id=\"address_type\"]/option[3]");
	Click(adrstype);
	WebElement fname = ByName("first_name");
	SendKeys(fname, "JAFFIR");
	WebElement lname = ByName("last_name");
	SendKeys(lname, "Noor");
	WebElement mob = ByName("mobile");
	SendKeys(mob, "8122228398");
	WebElement dno = ByName("apartment");
	SendKeys(dno, "115/1");
	WebElement adrs1 = ByName("address");
	SendKeys(adrs1, "115/1,\nkalugumalai");
	WebElement ctry = ByXpath("//*[@id=\"updateAddress\"]/div[4]/div[2]/select/option[36]");
	Click(ctry);
	WebElement cty = ByXpath("//*[@id=\"updateAddress\"]/div[5]/div[1]/select/option[226]");
	Click(cty);
	WebElement pcd = ByName("zipcode");
	SendKeys(pcd, "628552");
	WebElement save = ByXpath("//*[@id=\"updateAddress\"]/div[6]/button");
	Click(save);
	Thread.sleep(2000);
	WebElement plcordr = ById("placeOrder");
	Click(plcordr);
	WebElement ordrid = ByXpath("/html/body/div[4]/section/section[1]/div/div[1]/div[1]/p[1]");
	GetText(ordrid);
	
	
//	Quit();
}
}