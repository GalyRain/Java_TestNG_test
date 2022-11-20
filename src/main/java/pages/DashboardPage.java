package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import org.testng.Assert;
import widgets.MenuWidget;
import widgets.ToolbarWidget;

import java.util.concurrent.TimeUnit;

public class DashboardPage extends TestBase {

	public ToolbarWidget toolbarWidget = new ToolbarWidget();
	public MenuWidget menuWidget = new MenuWidget();
	// Initializing the Page Objects:
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkVisiblePage() {
		waitPageLoad();
        Assert.assertTrue(toolbarWidget.nameToolbar.isDisplayed());
        Assert.assertTrue(toolbarWidget.menuToggleSwitcher.isDisplayed());
	}
}
