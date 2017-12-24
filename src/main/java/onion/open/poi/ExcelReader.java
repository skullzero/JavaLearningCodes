package onion.open.poi;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelReader 
{
	//循环取出excel中某个sheet的所有的数据
	public String readSheet(Sheet sheet)
	{
        String text	= "";  
        Row row		= null;
        Cell cell	= null;
        
        try 
        {  
             for (Iterator<Row> rowIterator = sheet.iterator();rowIterator.hasNext();) 
             {  
                 row = rowIterator.next();  
                 for (Iterator<Cell> iterator = row.cellIterator();iterator.hasNext();) 
                 {  
                     cell = iterator.next();  
                     text += getCellData(cell) + "   ";
                 }  
             }          
        } 
        catch (Exception e) 
        {  
        		e.printStackTrace();  
        } 

        System.out.println(text);
        return text;		
	}
	
	//取出某一行的所有数据
	public String readRow(Sheet sheet, int rowIndex)
	{
        String text	= ""; 
		Row row		= sheet.getRow(rowIndex);
        Cell cell	= null;
        
        for (Iterator<Cell> iterator = row.cellIterator();iterator.hasNext();) 
        {  
            cell = iterator.next();  
            text += getCellData(cell) + "   ";  
        } 		
        
        System.out.println(text);
        return text;
	}
	
	public String readCell(Sheet sheet, int rowIndex, int cellIndex)
	{
		Cell cell	= sheet.getRow(rowIndex).getCell(cellIndex);
		String text	= getCellData(cell);
		System.out.println(text);
		
		return text;
	}
	
	public String getCellData(Cell cell)
	{
		String text = ""; 
		
		//根据单元的的类型 读取相应的结果  
        if(cell.getCellType() == Cell.CELL_TYPE_STRING) 
       	{
       	 	text = cell.getStringCellValue();  
       	}
        else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) 
       	{
       	 	text = cell.getNumericCellValue() + "";  
       	}
        else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA) 
       	{
       	 	text = cell.getCellFormula();
       	}
        
        return text;
	}
	
}
