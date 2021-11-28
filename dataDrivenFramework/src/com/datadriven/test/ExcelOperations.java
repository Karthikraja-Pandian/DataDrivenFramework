package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		// get text data from excel
				Xls_Reader reader = new Xls_Reader(
						"C:\\Users\\karth\\eclipse-workspace\\dataDrivenFramework\\src\\com\\testdata\\FormTestData.xlsx");
		
		if(!reader.isSheetExist("Homepage")) {
			reader.addSheet("Homepage");
		}
		
		// So many methods are there to perform. Use whatever needed at the time
		

	}

}
