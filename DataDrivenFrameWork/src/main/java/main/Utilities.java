package main;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities extends Main{
	
	public static String getData(String string) {

		
		//System.out.println(testCaseName);
		String sheetName = "Sheet1"; // Replace with the actual sheet name where the data is present
		String key = string; 
		int keyposition = 0;
		String Value = "";
		
		String filePath = System.getProperty("user.dir")+"\\TestData\\testData.xlsx";
		try  {
			FileInputStream fis = new FileInputStream(filePath); 
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				System.out.println("Sheet '" + sheetName + "' not found!");
				return"";
			}

			int targetRowNum = -1;
			
			for (Row row : sheet) {
				Cell cell = row.getCell(0); // Assuming the test case names are in the first column
				
				if (cell != null && cell.getCellType() == CellType.STRING) {
					String acttestCaseName = cell.getStringCellValue();
					if (Main.testCaseName.equals(acttestCaseName)) {
						targetRowNum = row.getRowNum();
						break;
					}
				}
			}

			if (targetRowNum == -1) {
				System.out.println("Test case '" + testCaseName + "' not found!");
				return "";
			}

			Row targetRow = sheet.getRow(targetRowNum);
			for (Cell cell : targetRow) {
				if (cell.getCellType() == CellType.STRING) {
					String value = cell.getStringCellValue();
					if (key.contentEquals(value)) {
						
						keyposition = cell.getColumnIndex();
						 Value = targetRow.getCell(keyposition+1).getStringCellValue();
					}
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Value;

	}

}
