package Common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.driver_Class;

public class ElementFinder {
	public WebElement find(String path)
	{
		if(path.isEmpty())
		{
			return null;
		}
		else
		{
			return driver_Class.driver.findElement(By.xpath(path));
		}
	}
	public WebElement findWait(String path)
	{
		if(path.isEmpty())
		{
			return null;
		}
		else
		{
			WebDriverWait wait=new WebDriverWait(driver_Class.driver,Duration.ofSeconds(30));
			return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
		}
	}
	public void javaExecutor(String path)
	{
		WebElement l = driver_Class.driver.findElement(By.xpath(path));
		JavascriptExecutor j = (JavascriptExecutor) driver_Class.driver;
		j.executeScript("arguments[0].click();", l);
	}
}
