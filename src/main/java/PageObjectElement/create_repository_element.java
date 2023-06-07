package PageObjectElement;

public interface create_repository_element {
	String createRepo="//details[@class='details-overlay details-reset']//summary[@aria-haspopup='menu']";
	String createNewRepo="//a[contains(text(),'New repository')]";
	String reproName="//input[@id='react-aria-2']";
	String nameDuplicateVerification="//span[@id='react-aria-2-validationMessage']";
	String visiblility="//input[@value='public']";
	String createRepoButton="//button[contains(@class,'ws60qy-0 i')]";
	String verificationAfterRepoCreated ="//span[@data-content='Settings']";
}
