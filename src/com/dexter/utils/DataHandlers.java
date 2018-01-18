/**
 * 
 */
package com.dexter.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Vikrant
 * Read and write data using properties file
 *
 */
public class DataHandlers {
	public static String getDataFromPropertyFile(String fileName, String key) throws Exception
	{
		String data=null;
		try
		{
		File f = new File ("./config_data/"+fileName+".properties");
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		data = (String)prop.get(key);
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
		
	}
public static void writeDataToPropertyFile(String fileName, String key,String value,String comment) throws Exception
{
	try{
	File f = new File("./config_data/"+fileName+".properties");
	FileInputStream fis= new FileInputStream(f);
	Properties prop = new Properties();
	prop.load(fis);
	prop.setProperty(key, value);
	FileOutputStream fos = new FileOutputStream(f);
	prop.store(fos, comment);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
}

public static String getDataFromExcel(String fileName, String sheetName , int rowIndex, int cellIndex)
{
	String data = null;
	try{
	File f = new File("./test_data/"+fileName+".xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet st =wb.getSheet(sheetName);
	Row r=st.getRow(rowIndex);
	Cell c= r.getCell(cellIndex);
	data = c.toString();
	}
	catch ( Exception e)
	{
		e.printStackTrace();
	}
	return data;
	
}

public static void writedataToExcel(String fileName,String sheetName,int rowIndex,int cellIndex,String data) 
{
	try
	{
		File f = new File("./test_data/"+fileName+".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet st = wb.getSheet(sheetName);
		Row r = st.getRow(rowIndex);
		Cell c = r.getCell(cellIndex);
		c.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}
