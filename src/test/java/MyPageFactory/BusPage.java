package MyPageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusPage {
	WebDriver driver;

	public BusPage( WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[@class='chNavIcon appendBottom2 chSprite chBuses']")
	WebElement Bus;
	@FindBy(id="fromCity")
	WebElement selectfrom;
	@FindBy(xpath="//input[@placeholder='From']")
	WebElement from;
	@FindBy(xpath="//input[@placeholder='To']")
	WebElement to;
	@FindBy(xpath="//div[@class='DayPicker-Day' and @role='gridcell' and @aria-label='Mon Apr 15 2024' and @aria-disabled='false' and @aria-selected='false']")
	WebElement date;
	@FindBy(xpath="//button[@id='search_button']")
	WebElement search;

	public void SearchBus() {
		Bus.click();
	}
	public void clickc() {
		from.click();
	}
	public void chooseStartingFrom(String location) throws AWTException {
		from.click();
		from.sendKeys(location);
		Robot robot = new Robot();
		robot.delay(1000); 
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	public void selectto(String destination) throws AWTException {
		to.sendKeys(destination);
		Robot robot = new Robot();
		robot.delay(1000); 
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void SelectDate() {
		date.click();
	}
	public void Searchclick() {
		search.click();
	}
}
