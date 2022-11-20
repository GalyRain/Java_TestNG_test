package pages;

import base.TestBase;
import generators.RandomStringGenerator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OfferAddPage extends TestBase {

	@FindBy( xpath = "//input[@placeholder='name']")
	public WebElement nameInput;

	@FindBy( xpath = "//input[@placeholder='key']")
	public WebElement keyInput;

	@FindBy( xpath = "//select")
	public WebElement categorySelector;

	@FindBy( xpath = "(//mat-select[1])[1]")
	public WebElement networksSelector;

	@FindBy( xpath = "//span[text()='Facebook']")
	public WebElement networksFBSelector;

	@FindBy( xpath = "(//mat-select[1])[2]")
	public WebElement groupSelector;

	@FindBy( xpath = "//span[text()=' VK ']")
	public WebElement groupVKSelector;

	@FindBy( xpath = "//button/span[text()=' Add group ']")
	public WebElement addGroupButton;

	@FindBy( xpath = "//button/span[text()=' Save ']")
	public WebElement saveButton;

	// Initializing the Page Objects:
	public OfferAddPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkVisiblePage() {
		waitPageLoad();
        Assert.assertTrue(nameInput.isDisplayed());
        Assert.assertTrue(keyInput.isDisplayed());
	}

	public String creatNewRandomOffer() {
		String name = RandomStringGenerator.randomName();
		nameInput.sendKeys(name);
		keyInput.sendKeys(RandomStringGenerator.randomKey());
		Select select = new Select(categorySelector);
		select.selectByValue("1");

		this.networksSelector.click();
		Assert.assertTrue(networksFBSelector.isEnabled());
		networksFBSelector.click();
        new Actions(driver).keyDown(Keys.TAB).perform();

		groupSelector.click();
		Assert.assertTrue(groupVKSelector.isEnabled());
		groupVKSelector.click();

		addGroupButton.isDisplayed();
		addGroupButton.click();

		Assert.assertTrue(saveButton.isDisplayed());
		saveButton.click();

		return name;
	}
}
