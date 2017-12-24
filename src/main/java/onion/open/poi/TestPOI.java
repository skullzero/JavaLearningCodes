package onion.open.poi;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


public class TestPOI 
{	
	@Test
	public void testPOI()
	{
		//String excelFile = "/Users/onion/my/git/JavaLearningCodes/src/main/java/onion/open/poi/poi-test.xls";
		String excelFile			= "/Users/onion/my/git/JavaLearningCodes/src/main/java/onion/open/poi/poi-test.xlsx";
		String EXCEL_XLSX		= ".xlsx";
		String EXCEL_XLS			= ".xls";
		ExcelReader excelReader	= new ExcelReader();
		Workbook excel			= null;
		
		try
		{
			InputStream stream = new FileInputStream(excelFile);
			
			if(excelFile.endsWith(EXCEL_XLS))
			{
				System.out.println("----XLS");
				excel =	new HSSFWorkbook(stream);
			}
			else if(excelFile.endsWith(EXCEL_XLSX))
			{
				System.out.println("----XLSX");
				excel = new XSSFWorkbook(stream);
			}
			
			//测试拿第一个sheet
			excelReader.readSheet(excel.getSheetAt(0));
			excelReader.readRow(excel.getSheetAt(0), 1);
			excelReader.readCell(excel.getSheetAt(0), 2, 1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
 