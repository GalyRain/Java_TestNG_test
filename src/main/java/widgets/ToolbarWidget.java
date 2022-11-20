package widgets;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolbarWidget extends TestBase {

	@FindBy( xpath = "//span[text()='QA Test Form']")
	public WebElement nameToolbar;

	@FindBy( css = "#mat-slide-toggle-1 div")
	public WebElement menuToggleSwitcher;

	// Initializing the Page Objects:
	public ToolbarWidget() {
		PageFactory.initElements(driver, this);
	}

	public void checkedMenu() {
		if(!menuToggleSwitcher.isSelected())
			menuToggleSwitcher.click();
	}
}
