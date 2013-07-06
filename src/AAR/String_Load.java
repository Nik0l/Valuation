package AAR;
import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class String_Load {

	   //SpellChecker checker = new SpellChecker();

	   //SpellResponse spellResponse = checker.check( "helloo worlrd" );

	   public static String ReadDoc(String f, List<String> NameList) {
		   String text = "";
		   String test = "kaлopиmetp";
		   
		   try {
			   FileInputStream file = new FileInputStream(new File("table.xls"));
			 //Get the workbook instance for XLS file
			   HSSFWorkbook workbook = new HSSFWorkbook(file);			    
			   //Get first sheet from the workbook
			   HSSFSheet sheet = workbook.getSheetAt(0);			    
			   //Iterate through each rows from first sheet
			   Iterator<Row> rowIterator = sheet.iterator();
			   while(rowIterator.hasNext()) {				   
				   Row row = rowIterator.next();
				   Iterator<Cell> cellIterator = row.cellIterator();
				   Cell cell = null;
				   int number_of_column = 2;
				   
				   for (int i = 0; i < number_of_column; i++)
				   {
					   if (cellIterator.hasNext())
					   {
						   cell = cellIterator.next();
					   }
				   }
				   switch(cell.getCellType()) {
				   
	                case Cell.CELL_TYPE_BOOLEAN:
	                    System.out.print(cell.getBooleanCellValue() + "\t\t\n");
	                    break;
	                case Cell.CELL_TYPE_NUMERIC:
	                {
	                	NameList.add(Double.toString(cell.getNumericCellValue()));
	                    System.out.print(cell.getNumericCellValue() + "\t\t\n");
	                    break;
	                }
	                case Cell.CELL_TYPE_STRING:
	                {
	                	String s = Filter.DeleteNumbers(cell.getStringCellValue());
	                	NameList.add(s);
	                	System.out.print(NameList.size());
	                    System.out.print(cell.getStringCellValue() + "\t\t\n");
	                    break;
	                }
	               }//switch
			   }//while
			   file.close();
		   }
		   catch (Exception e) {
			   }
			   
		   return text;
	   }
}
