package vtiger.genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

import vtiger.POMRepository.HomePage;
import vtiger.POMRepository.LoginPage;

public class BaseClass
{
	public WebDriver driver;
	public FileUtility fUtils=new FileUtility();
	public WebDriverUtility wUtils=new WebDriverUtility();
	public ExcelUtility eUtils=new ExcelUtility();
	public static WebDriver sdriver;
	public Connection connection;
	
	@BeforeSuite
	public void bsconfig() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root","root");
		System.out.println("Connection has been established.");
	}
	@BeforeClass
	public void bcconfig() throws IOException
	{
		
		String url = fUtils.toFetchDataFromPropertyFile(IPathConstant.URL_KEY);		
		
		driver=new ChromeDriver();
		System.out.println("The browser has been launched.");
		wUtils.maximizeTheWebpage(driver);
		wUtils.implicitWait(driver);
		driver.get(url);
		System.out.println("The url has been navigated.");
		sdriver=driver;
	}
	@BeforeMethod
	public void bmconfig() throws IOException
	{
		String username = fUtils.toFetchDataFromPropertyFile(IPathConstant.USERNAME_KEY);
		String password = fUtils.toFetchDataFromPropertyFile(IPathConstant.PASSWORD_KEY);
		
		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("The "+username+" has logged in.");
	}
	@AfterMethod
	public void amconfig() throws IOException
	{   
		String username = fUtils.toFetchDataFromPropertyFile(IPathConstant.USERNAME_KEY);
		HomePage home = new HomePage(driver);
		home.logoutAction();
		System.out.println("The "+username+" has logged out.");
	}
	@AfterClass
	public void acconfig()
	{
		driver.quit();
		System.out.println("The browser has been closed.");
	}
	@AfterSuite
	public void asconfig() throws SQLException
	{
		connection.close();
		System.out.println("Database connection has been closed.");
	}
}
