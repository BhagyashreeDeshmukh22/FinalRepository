package com.CRM.Utilities;


import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src=new File("./TestData/TestData.xlsx");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
		
			wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("File not found"+e.getMessage());
		}
		
	}
	public String getStringData(String sheetname,int row,int column)
	{
	return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();	
	}
	public String getStringData(int sheetindex,int row,int column)
	{
	return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();	
	}
	public double getNumericData(String sheetname,int row,int column)
	{
	return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();	
	}
}
