package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
	
	//get text data from excel
		Xls_Reader reader = new Xls_Reader
				("C:\\Users\\karth\\eclipse-workspace\\dataDrivenFramework\\src\\com\\testdata\\FormTestData.xlsx");

		String firstname = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstname);
		
		String lastname = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastname);
		
		String phone = reader.getCellData("RegTestData", "phone", 2);
		System.out.println(phone);
		
		String country = reader.getCellData("RegTestData", "country", 2);
		System.out.println(country);
		
		String city = reader.getCellData("RegTestData", "city", 2);
		System.out.println(city);
		
		String email = reader.getCellData("RegTestData", "email", 2);
		System.out.println(email);
		
		String timeforcontact = reader.getCellData("RegTestData", "timeforcontact", 2);
		System.out.println(timeforcontact);
		
	// webdriver code
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\karth\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-1\']")).sendKeys(firstname);
		
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-2\']")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-3\']")).sendKeys(phone);
		
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-4\']")).sendKeys(country);
		
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-5\']")).sendKeys(city);
		
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-6\']")).sendKeys(email);
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\'RESULT_RadioButton-9\']")));
		select.selectByVisibleText(timeforcontact);	
		
	}

}
