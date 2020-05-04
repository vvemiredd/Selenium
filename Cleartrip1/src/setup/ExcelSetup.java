package setup;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSetup {
	 public static String Value1;

	 public static String Value2;

	 public static String getvalue1() throws Exception

	 {

	 FileInputStream fi = new FileInputStream("D:\\TestData.xlsx");

	 XSSFWorkbook wb = new XSSFWorkbook(fi);

	 XSSFSheet sh = wb.getSheet("Sheet1");



	 Value1 = sh.getRow(0).getCell(0).getStringCellValue();

	 return Value1;



	 }

	 public static String getvalue2() throws Exception

	 {





	 FileInputStream fi = new FileInputStream("D:\\TestData.xlsx");

	 XSSFWorkbook wb = new XSSFWorkbook(fi);

	 XSSFSheet sh = wb.getSheet("Sheet1");



	 Value2 = sh.getRow(0).getCell(1).getStringCellValue();

	 return Value2;



	 }
}
