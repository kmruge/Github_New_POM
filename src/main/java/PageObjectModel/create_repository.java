package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.driver_Class;
import Common.ElementFinder;
import PageObjectElement.create_repository_element;

public class create_repository {
	ElementFinder find=new ElementFinder();
	public void createRepository(String name)
	{
		find.find(create_repository_element.createRepo).click();
		find.find(create_repository_element.createNewRepo).click();
		find.find(create_repository_element.reproName).sendKeys(name);
		boolean visbility=find.find(create_repository_element.visiblility).isSelected();
		Assert.assertTrue(visbility);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		find.findWait(create_repository_element.createRepoButton).click();
		boolean Repo_created=find.find(create_repository_element.verificationAfterRepoCreated).isDisplayed();
		Assert.assertTrue(Repo_created);
	}
}
