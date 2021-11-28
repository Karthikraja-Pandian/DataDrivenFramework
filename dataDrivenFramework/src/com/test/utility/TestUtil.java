package com.test.utility;

import java.util.ArrayList;
import com.excel.utility.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {
		
	    ArrayList<Object[]> myData = new ArrayList<Object[]>();
	     
	    try {
	    	 reader = new Xls_Reader(
	 		 "C:\\Users\\karth\\eclipse-workspace\\dataDrivenFramework\\src\\com\\testdata\\FormTestData.xlsx");
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	     
	    int rowCount = reader.getRowCount("RegTestData");
	     	    
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

				String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
				String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
				String phone = reader.getCellData("RegTestData", "phone", rowNum);
			    String country = reader.getCellData("RegTestData", "country", rowNum);
	            String city = reader.getCellData("RegTestData", "city", rowNum);
				String email = reader.getCellData("RegTestData", "email", rowNum);
				String timeForContact = reader.getCellData("RegTestData", "timeforcontact", rowNum);
				
				Object[] ob = {firstName, lastName, phone, country, city, email, timeForContact};
				myData.add(ob);
		}	
		return myData;
	}
}
	
