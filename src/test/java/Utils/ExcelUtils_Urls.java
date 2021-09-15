package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils_Urls {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public static String[] getURLs() throws IOException
	{
		String urls[]=new String[9];
		
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Rutuja");
		urls[0]=sheet.getRow(0).getCell(4).getStringCellValue();//Home
		urls[1]=sheet.getRow(1).getCell(4).getStringCellValue();//Register
		urls[2]=sheet.getRow(2).getCell(4).getStringCellValue();//Login
		urls[3]=sheet.getRow(3).getCell(4).getStringCellValue();//Dashboard
		urls[4]=sheet.getRow(4).getCell(4).getStringCellValue();//UploadPage
		urls[5]=sheet.getRow(7).getCell(4).getStringCellValue();//Profile
		urls[6]=sheet.getRow(8).getCell(4).getStringCellValue();//UpdateProfile
		urls[7]=sheet.getRow(9).getCell(4).getStringCellValue();//UpdatePic
		urls[8]=sheet.getRow(10).getCell(4).getStringCellValue();//ChangePassword
		return urls;
		
	}
}
