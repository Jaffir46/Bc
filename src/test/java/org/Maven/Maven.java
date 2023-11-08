package org.Maven;

import org.openqa.selenium.WebElement;

public class Maven extends  Bc {
public static void main(String[] args) {
	LaunchBrowser();
	GetUrl("https://omrbranch.com/");
	MaxWindow();
	ImplicitWait(30);
	WebElement byId = ById("email");
	SendKeys(byId, "contactjaffir@gmail.com");
	WebElement byName = ByName("pass");
	SendKeys(byName, "Jaffir@2699");
	WebElement byXpath = ByXpath("//*[@id=\"userLogin\"]/div[5]/button");
	Click(byXpath);
	
	
	WebElement wlcmtxt = ByXpath("//*[@id=\"wrapper\"]/header/div/div/div/div[2]/div/ul/li[2]/a");
	GetText(wlcmtxt);
}
}