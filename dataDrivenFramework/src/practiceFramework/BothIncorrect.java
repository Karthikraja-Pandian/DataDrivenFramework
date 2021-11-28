package practiceFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothIncorrect {
	
	@Test
	@Parameters({"username", "password"})
	public void loginWithBothIncorrect(String uName, String pWord) {

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
