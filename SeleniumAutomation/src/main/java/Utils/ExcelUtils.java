package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {	
	private static Workbook myDataBook;
	private static Sheet mySheet;
	
	public static void loadExcel(String filePath, String sheetName) {
		try {
			FileInputStream file = new FileInputStream(filePath);
			myDataBook = new XSSFWorkbook(file);
			mySheet = myDataBook.getSheet(sheetName);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		}
		
	}
	
	public static int getRowCount() {			
			return mySheet.getPhysicalNumberOfRows();
	}
		
	public static String getCellValue(int rowNum, int cellNum) 
	{
		Cell cell = mySheet.getRow(rowNum).getCell(cellNum);
		
		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		}
		
		return "";
	}
	
	public static void closeExcel() throws IOException {			
		myDataBook.close();
	}
}
