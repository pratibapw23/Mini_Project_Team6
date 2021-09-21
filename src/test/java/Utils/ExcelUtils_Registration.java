package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils_Registration {
static XSSFWorkbook workbook;
static XSSFSheet sheet;

	public static String getUserName() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		String userid=sheet.getRow(1).getCell(0).getStringCellValue();
		return userid;
		
	}
	public static  String getFirstName() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		String fname=sheet.getRow(1).getCell(1).getStringCellValue();
		return fname;
		
	}
	public static String getLastName() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		String lname=sheet.getRow(1).getCell(2).getStringCellValue();
		return lname;

	}
	public static String getEmail() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		String email=sheet.getRow(1).getCell(3).getStringCellValue();
		return email;
	}

	public static String getRegPassword() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		String password=sheet.getRow(1).getCell(4).getStringCellValue();
		return password;
	}
	public static String getRegConfirmPassword() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		String cpass=sheet.getRow(1).getCell(5).getStringCellValue();
		return cpass;
	}
	public static String getMobileNo() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		long no= (long) sheet.getRow(1).getCell(7).getNumericCellValue();
		String s=Long.toString(no);
		return s;
	}
	
	public static String getPathImage() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		String path=sheet.getRow(1).getCell(8).getStringCellValue();
		return path;
	}
	public static String getWrongMobileNo() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData_Dhanashree");
		long no= (long) sheet.getRow(2).getCell(8).getNumericCellValue();
		String s=Long.toString(no);
		return s;
	}
	
	public static String username_am() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Amruta");
		String username=sheet.getRow(0).getCell(0).getStringCellValue();
		
		return username;
	}
	
	public static String getRegPassword_am() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Amruta");
		String password=sheet.getRow(0).getCell(1).getStringCellValue();
		return password;
	}
	
	
		

	}


