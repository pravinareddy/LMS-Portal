package com.lmsapp.lms.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;

public class dataDriven {

	public void getData(String testcaseName) throws IOException
	{
	//fileInputStream argument
	ArrayList<String> a=new ArrayList<String>();

	FileInputStream fis=new FileInputStream("C://Users//shilp//git//LMS-Portal//src//test//java//com//lmsapp//lms//utilities//ExcelReader.java");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);

	XSSFSheet sheet=workbook.getSheet("sheet1");
	
//	XSSFSheet sheet=workbook.getSheetAt(i);


	Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
	Row firstrow= rows.next();
	Row secondrow=rows.next();
	Iterator<Cell> ce=secondrow.cellIterator();//row is collection of cells
	int k=0;
	int coloumn = 0;
	while(ce.hasNext())
	{
		 Row row = rows.next();
		    Iterator<Cell> cells = row.cellIterator(); // row is a collection of cells
		    while (cells.hasNext()) {
		        Cell cell = cells.next();
		        // Process the cell data here
		        System.out.print(cell.getStringCellValue() + "\t");
		        
		    }

	System.out.println(coloumn);


}
}
	}
	