package practiceFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDataInside {
	
	String [] [] data = {
			{"Admin","admin123"},
			{"dummy","dummy123"},
			{"Admin","dummy123"},
			{"dummy","admin123"}		
	};
	
	@DataProvider(name="Login Data")
	public String[][] loginDataProvider() {
		return data;
	}

	@Test(dataProvider="Login Data")
	public void BothCorrect(String uName, String pWord) {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\karth\\Desktop\\Drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/");
    
    WebElement userName = driver.findElement(By.id("txtUsername"));
    userName.sendKeys(uName);
    
    WebElement passWord = driver.findElement(By.id("txtPassword"));
    passWord.sendKeys(pWord);
    
    WebElement loginBtn = driver.findElement(By.id("btnLogin"));
    loginBtn.click();
    
    driver.quit();    
	}

}
