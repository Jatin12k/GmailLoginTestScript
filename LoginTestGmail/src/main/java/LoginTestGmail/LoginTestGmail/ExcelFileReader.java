package LoginTestGmail.LoginTestGmail;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileReader {
	private static String filePath = "e://GmailData.xlsx";

	public static String getExcelData(String sheetName, int rowNum, int cellNum) {

		String retVal = null;
		try {
			Workbook wb = WorkbookFactory.create(new File(filePath));
			Sheet s = wb.getSheet(sheetName);
			Row row = s.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			DataFormatter dataFormatter = new DataFormatter();
			retVal = dataFormatter.formatCellValue(cell);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	}
