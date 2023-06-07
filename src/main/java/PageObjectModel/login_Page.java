package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.driver_Class;
import Common.ElementFinder;
import PageObjectElement.login_Page_Element;

public class login_Page {
	ElementFinder find=new ElementFinder();
	public void loginVerify()
	{
		WebElement ele=find.find(login_Page_Element.verify);
		Assert.assertNotNull(ele);
	}
	public void credentialEntering()
	{
		find.find(login_Page_Element.emailField).sendKeys(driver_Class.property.getProperty("EmailID"));
		find.find(login_Page_Element.passWordField).sendKeys(driver_Class.property.getProperty("Password"));
		find.find(login_Page_Element.signInbutton).click();
	}
}
