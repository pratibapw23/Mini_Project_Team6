package Utils;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static final CharSequence FirstName_UpdateProfile = null;

	static XSSFWorkbook workbook;
	
	static XSSFSheet sheet;
	
	public static String getUsername() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String username=sheet.getRow(1).getCell(0).getStringCellValue();
		return username;
		
	}
	public static String getPassword() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		return password;

	}
	public static String getExpectedColor() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Properties");
		String ExpectedColor=sheet.getRow(1).getCell(0).getStringCellValue();
		return ExpectedColor;
	}
	public static String[] getStringPasswords() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		
		String pass[]=new String[2];
		pass[0]=sheet.getRow(2).getCell(2).getStringCellValue();
		pass[1]=sheet.getRow(3).getCell(2).getStringCellValue();
		return pass; 
	}
	public static String getNumericPasswords() throws IOException
	{
		double numericPassw=sheet.getRow(1).getCell(2).getNumericCellValue();
		String s=Double.toString(numericPassw);
		return s;
	}
	public static String getExpectedSignUpTitle() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String ExpectedSignUpTitle=sheet.getRow(1).getCell(4).getStringCellValue();
		return ExpectedSignUpTitle;
	}
	
	public static String getUserName_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String UserName_UpdateProfile=sheet.getRow(5).getCell(0).getStringCellValue();
		return UserName_UpdateProfile;
	}
	public static String getPassword_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String Password_UpdateProfile=sheet.getRow(5).getCell(1).getStringCellValue();
		return Password_UpdateProfile;
	}
	public static String getFirstName_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String FirstName_UpdateProfile=sheet.getRow(6).getCell(0).getStringCellValue();
		return FirstName_UpdateProfile;
	}
	public static String getLastName_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String LastName_UpdateProfile=sheet.getRow(7).getCell(0).getStringCellValue();
		return LastName_UpdateProfile;
	}


}
