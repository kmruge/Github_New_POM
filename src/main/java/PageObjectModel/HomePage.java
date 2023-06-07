package PageObjectModel;

import org.testng.Assert;

import Base.driver_Class;
import Common.ElementFinder;
import PageObjectElement.HomePageElement;

public class HomePage {
	ElementFinder find=new ElementFinder();
	public void homePageVerification()
	{
		String tile=driver_Class.driver.getTitle();
		boolean con=false;
		if(tile.contains("GitHub"))
		{
			con=true;
		}
		Assert.assertTrue(con);
	}
	public void signIn()
	{
		find.find(HomePageElement.signIn).click();
	}
}
