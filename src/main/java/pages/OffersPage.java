package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import widgets.TableWidget;

public class OffersPage extends TestBase {

	@FindBy( css = "[class='ng-star-inserted'] > button")
	public WebElement addButton;

	public TableWidget tableWidget = new TableWidget();
	// Initializing the Page Objects:
	public OffersPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkVisiblePage() {
		waitPageLoad();
        Assert.assertTrue(addButton.isEnabled());
	}

	public void openOfferPage() {
		driver.get(prop.getProperty("url") + "/list/");
		waitPageLoad();
	}
}
