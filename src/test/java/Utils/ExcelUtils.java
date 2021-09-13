package Utils;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
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
	public static String[] getRegistrationDetails() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String RegistrationDetails[]=new String[6];
		RegistrationDetails[0]=sheet.getRow(6).getCell(0).getStringCellValue();
		RegistrationDetails[1]=sheet.getRow(6).getCell(1).getStringCellValue();
		RegistrationDetails[2]=sheet.getRow(6).getCell(2).getStringCellValue();
		RegistrationDetails[3]=sheet.getRow(6).getCell(3).getStringCellValue();
		RegistrationDetails[4]=sheet.getRow(6).getCell(4).getStringCellValue();
		RegistrationDetails[5]=sheet.getRow(6).getCell(5).getStringCellValue();

		return RegistrationDetails;
		
	}
	public static double getMobileNo() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		double mobileno=sheet.getRow(6).getCell(7).getNumericCellValue();
		
		return mobileno;
	}
	public static String getExpectedUrl() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");	
		String ProfileUrl=sheet.getRow(9).getCell(0).getStringCellValue();
		return ProfileUrl;
	}
	
	
	public static String getUsernameChangePassword() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String uname=sheet.getRow(10).getCell(0).getStringCellValue();
		return uname;
	}
	
	public static String getOldPasswordChangePassword() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String uname=sheet.getRow(10).getCell(1).getStringCellValue();
		return uname;
	}
	public static String getNewPasswordChangePassword() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Credentials");
		String uname=sheet.getRow(10).getCell(2).getStringCellValue();
		return uname;
	}
	public static String getRegisterPageExpectedTitle() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Properties");
		String RegisterPageExpectedTitle=sheet.getRow(1).getCell(1).getStringCellValue();
		return RegisterPageExpectedTitle;
	}
	public static String getLoginPageExpectedTitle() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Properties");
		String LoginPageExpectedTitle=sheet.getRow(1).getCell(2).getStringCellValue();
		return LoginPageExpectedTitle;
	}
	public static String[] getRegistrationDetails1() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		String RegistrationDetails[]=new String[6];
		RegistrationDetails[0]=sheet.getRow(1).getCell(0).getStringCellValue();
		RegistrationDetails[1]=sheet.getRow(1).getCell(1).getStringCellValue();
		RegistrationDetails[2]=sheet.getRow(1).getCell(2).getStringCellValue();
		RegistrationDetails[3]=sheet.getRow(1).getCell(3).getStringCellValue();
		RegistrationDetails[4]=sheet.getRow(1).getCell(4).getStringCellValue();
		RegistrationDetails[5]=sheet.getRow(1).getCell(5).getStringCellValue();

		return RegistrationDetails;
		
	}
	
	public static String getUserName_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Rutuja");
		String UserName_UpdateProfile=sheet.getRow(5).getCell(0).getStringCellValue();
		return UserName_UpdateProfile;
	}
	public static String getPassword_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Rutuja");
		String Password_UpdateProfile=sheet.getRow(5).getCell(1).getStringCellValue();
		return Password_UpdateProfile;
	}
	public static String getFirstName_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Rutuja");
		String FirstName_UpdateProfile=sheet.getRow(6).getCell(0).getStringCellValue();
		return FirstName_UpdateProfile;
	}
	public static String getLastName_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Rutuja");
		String LastName_UpdateProfile=sheet.getRow(7).getCell(0).getStringCellValue();
		return LastName_UpdateProfile;
	}
	public static String getOldFirstName_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Rutuja");
		String OldFirstName_UpdateProfile=sheet.getRow(6).getCell(1).getStringCellValue();
		return OldFirstName_UpdateProfile;
	}
	public static String getOldLastName_UpdateProfile() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Rutuja");
		String OldLastName_UpdateProfile=sheet.getRow(7).getCell(1).getStringCellValue();
		return OldLastName_UpdateProfile;
	}

}
