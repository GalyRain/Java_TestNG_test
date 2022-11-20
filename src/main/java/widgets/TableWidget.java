package widgets;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class TableWidget extends TestBase {

	@FindBy( xpath = "//th[1][text()='Id.']")
	public WebElement offerIdText;

	@FindBy( xpath = "//th[2][text()='Name']")
	public WebElement offerNameText;

	@FindBy( xpath = "//th[3][text()='Key']")
	public WebElement offerKeyText;

	@FindBy( xpath = "//th[4][text()='Actions']")
	public WebElement offerActionText;

	@FindBy( xpath = "//span[text()='yes!']")
	public WebElement confirmationDeleteButton;

	// Initializing the Page Objects:
	public TableWidget() {
		PageFactory.initElements(driver, this);
	}

	public void checkVisibleTable() {
		Assert.assertTrue(offerIdText.isDisplayed());
		Assert.assertTrue(offerNameText.isDisplayed());
		Assert.assertTrue(offerKeyText.isDisplayed());
		Assert.assertTrue(offerActionText.isDisplayed());
	}

	public WebElement findOfferByName(String name) {
		WebElement base = driver.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = base.findElements(By.tagName("tr"));

		for (WebElement element : tableRows) {
			List<WebElement> cells = element.findElements(By.tagName("td"));
			WebElement cellName = cells.get(1);
			if (Objects.equals(cellName.getText(), name))
				return element;
		}
		throw new RuntimeException("Don't find");
	}

	public void notFindOfferById(String id) {
		WebElement base = driver.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = base.findElements(By.tagName("tr"));

		for (WebElement element : tableRows) {
			List<WebElement> cells = element.findElements(By.tagName("td"));
			WebElement cellId = cells.get(0);
			if (Objects.equals(cellId.getText(), id))
				throw new RuntimeException("find row");
		}
	}

	public String deleteOfferByIndex(Integer number) {
		WebElement base = driver.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = base.findElements(By.tagName("tr"));
		List<WebElement> cells = tableRows.get(number).findElements(By.tagName("td"));
		WebElement cellDelete = cells.get(3).findElement(By.xpath("//span[text()=' Delete ']"));
		WebElement cellId = cells.get(0);
		cellDelete.click();
		Assert.assertTrue(confirmationDeleteButton.isEnabled());
		confirmationDeleteButton.click();
		return cellId.getText();
	}

	public void checkInvisibilityOffer() {
		Assert.assertFalse(confirmationDeleteButton.isEnabled());
	}
}
