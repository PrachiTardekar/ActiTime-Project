package com.ActiTime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FileLibrary {

	//String path="./TestData/commondata.property";
	public String readDataFromePropertyFile(String key) throws IOException
	{
		
		FileInputStream fis=new FileInputStream("./TestData/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
}
	public String readDataFromExcelfile(String name, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream("./TestData/Exceldata.xlsx");
	 
		Workbook wb = WorkbookFactory.create(file);
		String data = wb.getSheet(name).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
}