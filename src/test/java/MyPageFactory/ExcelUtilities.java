package MyPageFactory;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	XSSFWorkbook wb=new XSSFWorkbook();
	XSSFSheet ws; 
	public ExcelUtilities(String excelFilePath)  {
		try {
			File fldata = new File(excelFilePath);
			FileInputStream Fis=new FileInputStream(fldata);
			wb = new XSSFWorkbook(Fis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String readcell(int sheetno,int Rowno,int cellno) {
		ws= wb.getSheetAt(sheetno);
		String data = ws.getRow(Rowno).getCell(cellno).getStringCellValue();
		return data;
	}
	public int getRowCount(int wsIndex) {
		int row = wb.getSheetAt(wsIndex).getLastRowNum();
		return row;
	}
}
