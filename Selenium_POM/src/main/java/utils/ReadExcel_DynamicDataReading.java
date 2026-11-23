package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_DynamicDataReading { //this works for dynamic data

	public static String[][] getExcelData(String fileName)   {
		
		//String fileLocation = "./test-data/Login-data.xlsx";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook("./test-data/"+fileName+".xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet = wbook.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("No.of.Rows"+lastRowNum);
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("No.of.columns"+lastCellNum);
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();		
		System.out.println("Rows with headers"+physicalNumberOfRows);
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				//String stringCellValue = cell.getStringCellValue();
				//System.out.println(stringCellValue);
				//System.out.println(value);
				data[i-1][j]=value;
				
			} 
		}
			try {
				wbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
		
		

	}

}
