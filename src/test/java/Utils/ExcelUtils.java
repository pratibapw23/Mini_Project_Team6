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
		sheet=workbook.getSheet("UserNamePass");
		String username=sheet.getRow(1).getCell(0).getStringCellValue();
		return username;
		
	}
	public static String getPassword() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("UserNamePass");
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
	public static String getResetPass() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("UserNamePass");
		String uname=sheet.getRow(1).getCell(3).getStringCellValue();
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
	
	public static String[] getRegistrationDetailsUtkarsh() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("Registration_Details");
		String RegistrationDetailsU[]=new String[6];
		RegistrationDetailsU[0]=sheet.getRow(2).getCell(0).getStringCellValue();
		RegistrationDetailsU[1]=sheet.getRow(2).getCell(1).getStringCellValue();
		RegistrationDetailsU[2]=sheet.getRow(2).getCell(2).getStringCellValue();
		RegistrationDetailsU[3]=sheet.getRow(2).getCell(3).getStringCellValue();
		RegistrationDetailsU[4]=sheet.getRow(2).getCell(4).getStringCellValue();
		RegistrationDetailsU[5]=sheet.getRow(2).getCell(5).getStringCellValue();
		
		return RegistrationDetailsU;
		
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
	public static String getOldLastName_UpdateProfile() throws IOException	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Rutuja");
		String OldLastName_UpdateProfile=sheet.getRow(7).getCell(1).getStringCellValue();
		return OldLastName_UpdateProfile;
	}
	public static String getWrongPassword2() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData_Dhanashree");
		String LastName_UpdateProfile=sheet.getRow(3).getCell(6).getStringCellValue();
		return LastName_UpdateProfile;
	}
	public static String getWrongUsername2() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData_Dhanashree");
		String LastName_UpdateProfile=sheet.getRow(3).getCell(0).getStringCellValue();
		return LastName_UpdateProfile;
	}
	

	public static String getUsername1() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData_Dhanashree");
		String LastName_UpdateProfile=sheet.getRow(4).getCell(0).getStringCellValue();
		return LastName_UpdateProfile;
	}
	
	public static String getPassword1() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData_Dhanashree");
		String LastName_UpdateProfile=sheet.getRow(4).getCell(4).getStringCellValue();
		return LastName_UpdateProfile;
	}
	
	
	
	public static String getUsernameU() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData_Utkarsh");
		String username=sheet.getRow(3).getCell(0).getStringCellValue();
		return username;
		
	}
	public static String getPasswordU() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData_Utkarsh");
		String password=sheet.getRow(3).getCell(4).getStringCellValue();
		return password;

	}
	
	
	
	
	public static String[] getRegistrationDetailsDhanu() throws IOException {
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData_Dhanashree");
		String RegistrationDetailsU[]=new String[6];
		RegistrationDetailsU[0]=sheet.getRow(2).getCell(0).getStringCellValue();
		RegistrationDetailsU[1]=sheet.getRow(2).getCell(1).getStringCellValue();
		RegistrationDetailsU[2]=sheet.getRow(2).getCell(2).getStringCellValue();
		RegistrationDetailsU[3]=sheet.getRow(2).getCell(3).getStringCellValue();
		RegistrationDetailsU[4]=sheet.getRow(2).getCell(4).getStringCellValue();
		RegistrationDetailsU[5]=sheet.getRow(2).getCell(5).getStringCellValue();
		
		return RegistrationDetailsU;
	}
	
	public static String getInvalidUserName() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Ankita");
		String username=sheet.getRow(1).getCell(2).getStringCellValue();
		return username;
		
	}
	public static String getInvalidPassword() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Ankita");
		String password=sheet.getRow(1).getCell(3).getStringCellValue();
		return password;

	}
	

	public static String getPasswordA() throws IOException {
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Ankita");
		String pass=sheet.getRow(1).getCell(1).getStringCellValue();
		return pass;
	}
	
	public static String getUserNameA() throws IOException
	{
		workbook=new XSSFWorkbook(".//Files//User_Credentials.xlsx");
		sheet=workbook.getSheet("TestData-Ankita");
		String username=sheet.getRow(1).getCell(0).getStringCellValue();
		return username;
		
	}
	
}
