package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Common.contant_values;

public class driver_Class {
	public static RemoteWebDriver driver=null;
	public static ExtentSparkReporter reporthtml=null;
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	public static Properties property=null;
	@BeforeClass
	public void driver()
	{
		property=new Properties();
		try {
			property.load(new FileInputStream("C:\\Users\\kmruge\\eclipse-workspace\\Github_new_POM\\File\\pro.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(contant_values.URL);
	}
	@BeforeTest
	public void extentsReport()
	{
		reporthtml=new ExtentSparkReporter(new File("C:\\Users\\kmruge\\eclipse-workspace\\Github_new_POM\\ExtentReport\\report.html"));
		reporthtml.config().setDocumentTitle("FreeCRM project");
		reporthtml.config().setReportName("Functional Report");
		reporthtml.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(reporthtml);
		report.setSystemInfo("Window", "Windows10");
		report.setSystemInfo("Tester Name", "Muru");
		report.setSystemInfo("Id", "kmruge");
	}
	@AfterMethod
	public void afterTestRun(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test failed at "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Passed at "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
	        test.log(Status.SKIP, "Test result Skipped at "+result.getName());
		}
	}
	@AfterTest
	public void flush()
	{
		report.flush();
	}
}
