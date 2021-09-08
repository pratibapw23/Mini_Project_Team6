package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteUser {
	public static boolean deleteUser(String email,WebDriver driver) throws IOException
	{

		driver.get("http://test-monk.in/admin");
		driver.findElement(By.name("username")).sendKeys("tushar");
		driver.findElement(By.name("password")).sendKeys("tushar");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content-main\"]/div[1]/table/tbody/tr[2]/th/a")).click();
		driver.findElement(By.name("q")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"changelist-search\"]/div/input[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"result_list\"]/tbody/tr/td[1]/input")).click();
		
		Select genderUi = new Select(driver.findElement(By.name("action")));
		genderUi.selectByValue("delete_selected");
		
		driver.findElement(By.name("index")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/input[4]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"nav-sidebar\"]/div[2]/table/tbody/tr[2]/th/a")).click(); //user_datas link
		driver.findElement(By.xpath("//*[@id=\"result_list\"]/tbody/tr[1]/td/input")).click();
		
		Select	userDatas = new Select(driver.findElement(By.name("action")));
		userDatas.selectByValue("delete_selected");
		
		driver.findElement(By.xpath("//*[@id=\"changelist-form\"]/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/input[4]")).click();
		return true;
		
	}
}
