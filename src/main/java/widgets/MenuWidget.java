package widgets;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MenuWidget extends TestBase {

	@FindBy( css = "[routerlink = '/dashboard']")
	public WebElement dashboardButton;

	@FindBy( css = "[routerlink = '/list']")
	public WebElement offersButton;

	// Initializing the Page Objects:
	public MenuWidget() {
		PageFactory.initElements(driver, this);
	}

	public void waitVisible() {
		waitPageLoad();
		Assert.assertTrue(dashboardButton.isEnabled());
		Assert.assertTrue(offersButton.isEnabled());
	}
}
