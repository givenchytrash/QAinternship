package MainTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelTesting {
	
	@Test
	public void DataReadTest() throws Exception 
	{
		File src = new File("D:\\EclipseSpace\\ExcelTesting\\Test.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook xsf = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = xsf.getSheetAt(0);
		
		String entry0 = sheet.getRow(1).getCell(0).getStringCellValue();
		
		String entry1 = sheet.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println("Data in first cells is " + entry0 + " " + entry1);
		
		xsf.close();
	}

}
