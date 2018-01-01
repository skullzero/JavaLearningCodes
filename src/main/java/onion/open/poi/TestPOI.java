package onion.open.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


public class TestPOI 
{	
	@Test
	public void testPOI() throws IOException
	{
//		String excelFile 		= "/Users/onion/my/git/JavaLearningCodes/src/main/java/onion/open/poi/poi-test.xls";
		String excelFile			= "/Users/onion/my/git/JavaLearningCodes/src/main/java/onion/open/poi/poi-test.xlsx";
		String EXCEL_XLSX		= ".xlsx";
		String EXCEL_XLS			= ".xls";
		ExcelReader excelReader	= new ExcelReader();
		Workbook excel			= null;
		InputStream inputStream		= null;
		OutputStream outputStream	= null;
		
		try
		{
			inputStream		= new FileInputStream(excelFile);
			
			if(excelFile.endsWith(EXCEL_XLS))
			{
				System.out.println("----XLS");
				excel =	new HSSFWorkbook(inputStream);
				
				//设置单元格格式
				CellStyle style = excel.createCellStyle();
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				style.setFillForegroundColor(HSSFColorPredefined.DARK_RED.getIndex());	
				excel.getSheetAt(0).getRow(2).getCell(3).setCellStyle(style);
			}
			else if(excelFile.endsWith(EXCEL_XLSX))
			{
				System.out.println("----XLSX");
				excel = new XSSFWorkbook(inputStream);

				//设置单元格格式
				XSSFCellStyle style = (XSSFCellStyle)excel.createCellStyle();
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				style.setFillForegroundColor(new XSSFColor(new java.awt.Color(128, 0, 128)));
				excel.getSheetAt(0).getRow(2).getCell(3).setCellStyle(style);
			}
			
			//测试拿第一个sheet
			excelReader.readSheet(excel.getSheetAt(0));
			excelReader.readRow(excel.getSheetAt(0), 1);
			excelReader.readCell(excel.getSheetAt(0), 2, 1);
			inputStream.close();
			
			
			//写入
			outputStream		= new FileOutputStream(excelFile);
			excel.getSheetAt(0).getRow(2).getCell(3).setCellValue("write test3");
			excel.write(outputStream);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			outputStream.close();
			inputStream.close();
		}
		
	}
}
 