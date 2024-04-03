package MyPageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusFilterPage {
	WebDriver driver;

	public BusFilterPage( WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[text()='AC']")
	WebElement AcType;
	@FindBy(xpath="//span[text()='Sleeper']")
	WebElement Seattype;
	@FindBy(xpath="//span[text()='Lakdikapul']")
	WebElement pickup;
	@FindBy(xpath="//span[text()='IntrCity SmartBus']")
	WebElement travelers;
	@FindBy(xpath="//span[text()='Panjim']")
	WebElement droppoint;
	@FindBy(xpath="//div[text()='Select Seats']")
	WebElement selectseats;

	public void filterAc() {
		AcType.click();
	}
	public void filterSleeper() {
		Seattype.click();
	}
	public void pickuppoint() {
		pickup.click();
	}
	public void traveloperation() {
		travelers.click();
	}
	public void drop_point() {
		droppoint.click();
	}
	public void selectingseats() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,100)");
		selectseats.click();
	}
}
