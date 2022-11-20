import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DashboardPage;
import pages.OffersPage;
import pages.OfferAddPage;

public class OfferTest extends TestBase {
	DashboardPage dashboardPage;
	OffersPage offersPage;
	OfferAddPage offerAddPage;

	public OfferTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		dashboardPage = new DashboardPage();
		offersPage = new OffersPage();
		offerAddPage = new OfferAddPage();
	}

	@Test(priority=1)
	public void offerAddTest(){
		offersPage.openOfferPage();
		offersPage.checkVisiblePage();
		offersPage.addButton.click();
		offerAddPage.checkVisiblePage();
		String offerName = offerAddPage.creatNewRandomOffer();
		offersPage.checkVisiblePage();
		offersPage.tableWidget.checkVisibleTable();
		offersPage.tableWidget.findOfferByName(offerName);
	}

	@Test(priority=2)
	public void offerDeleteTest(){
		offersPage.openOfferPage();
		offersPage.checkVisiblePage();
		String rowId = offersPage.tableWidget.deleteOfferByIndex(0);
		offersPage.checkVisiblePage();
		offersPage.openOfferPage();
		offersPage.tableWidget.notFindOfferById(rowId);
	}

	@AfterMethod
	public void tearDown(){
		stopDriver();
	}
}
