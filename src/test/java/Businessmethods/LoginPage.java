package Businessmethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ObjectRepository.Objrepo;
import Utilities.Commonmethods;
import Utilities.DataProvider;

public class LoginPage extends Basesetupdriver {

	
	public static DataProvider data = new DataProvider();
	
	public void login(String arg1) throws Throwable, Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//DataProvider.excelHashMapValues.put("testCaseID", arg1);
		DataProvider.excelHashMapValues = data.extractExcelData(arg1, "Sheet1");
		String lang = DataProvider.excelHashMapValues.get("Language");
		driver.findElement(By.xpath("//*[@id='dropdown-ember378']/span[1]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-content active']/li"));
		for (WebElement webElement : list) {
			String text = webElement.getText();
			if (text.equals(lang)) {
				webElement.click();
				break;
			}
		}
		
		String uname = DataProvider.excelHashMapValues.get("UserName");
		String group = DataProvider.excelHashMapValues.get("Groupid");
		String pass = DataProvider.excelHashMapValues.get("Password");
		Commonmethods.sendKeys(driver.findElement(Objrepo.user), uname);
		Commonmethods.sendKeys(driver.findElement(Objrepo.grpid), group);
		Commonmethods.click(driver.findElement(Objrepo.con));
		Commonmethods.sendKeys(driver.findElement(Objrepo.pass1), pass);
		Commonmethods.click(driver.findElement(Objrepo.log));
		WebElement list2 = driver.findElement(By.xpath("//div[@class='error-message']"));
		String text1 = list2.getText();
		String newtext = text1;
		newtext = newtext.replaceAll("'", "*");
		data.writeExcelData(arg1, "Sheet1", "Error_message", newtext);

	}

	public void browserclose() {
		System.out.println("browser closed");
		driver.close();

	}

}
