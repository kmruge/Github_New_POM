package test_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.driver_Class;
import PageObjectModel.HomePage;
import PageObjectModel.create_repository;
import PageObjectModel.login_Page;

public class test_run extends  driver_Class {
	HomePage homepage=new HomePage();
	login_Page loginpage=new login_Page();
	create_repository createRepo=new create_repository();
	@Test(priority=1)
	void homePage(Method method)
	{
		test=report.createTest(method.getName());
		homepage.homePageVerification();
		homepage.signIn();
	}
	@Test(priority=2)
	void loginPage(Method method)
	{
		test=report.createTest(method.getName());
		loginpage.loginVerify();
		loginpage.credentialEntering();
	}
	@Test(priority=3, dataProvider="RepositoryName")
	void creating_repository(String name) throws IOException
	{
		test=report.createTest("creating_repository");
		createRepo.createRepository(name);
//		
	}
	
	@DataProvider(name="RepositoryName")
	String[][] excel() throws IOException
	{
		String file_location="C:\\Users\\kmruge\\eclipse-workspace\\Github_new_POM\\File\\book.xlsx";
	    XSSFWorkbook book=new XSSFWorkbook(file_location);
		XSSFSheet sheet=book.getSheetAt(0);
		int rowNumber=sheet.getLastRowNum();
		int cellNumber=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowNumber+1][cellNumber];
		for(int i=0;i<=rowNumber;i++)
		{
			for(int j=0;j<cellNumber;j++)
			{
				XSSFRow row=sheet.getRow(i);
				XSSFCell cell=row.getCell(j);
				DataFormatter diff=new DataFormatter();
				String value=diff.formatCellValue(cell);
				data[i][j]=value;
			}
		}
		return data;
	}
}
