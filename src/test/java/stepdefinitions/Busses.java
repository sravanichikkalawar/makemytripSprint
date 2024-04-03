package stepdefinitions;

import java.awt.AWTException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MyPageFactory.BusFilterPage;
import MyPageFactory.BusPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Busses {
	WebDriver driver;

	@Given("I am on home page")
	public void i_am_on_home_page() throws InterruptedException {
		driver =  new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-frame']")));
		driver.switchTo().frame(frame); 
		WebElement clsBtn =driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
		clsBtn.click();
		String parentWindowHandle=driver.getWindowHandle();
		driver.switchTo().window(parentWindowHandle);
	}

	@When("I select the busses")
	public void i_select_the_busses() {
		BusPage bp = new BusPage(driver);
		bp.SearchBus();
	}

	@When("I choose the Starting from {string}")
	public void i_choose_the_starting_from(String string) throws AWTException  {
		BusPage bp = new BusPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement from = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromCity")));
		from.click();
		WebElement fromField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));
		bp.chooseStartingFrom(string);
	}

	@When("I choose the destination To {string}")
	public void i_choose_the_destination_to(String string) throws AWTException {
		BusPage bp = new BusPage(driver);
		bp.selectto(string);
	}

	@When("I choose the date {string}")
	public void i_choose_the_date(String string) {
		BusPage bp = new BusPage(driver);
		bp.SelectDate();
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		BusPage bp = new BusPage(driver);
		bp.Searchclick();
	}

	@Then("I should see available buses")
	public void i_should_see_available_buses() {
	}

	@When("I select filter like Ac type")
	public void i_select_filter_like_ac_type() {
		BusFilterPage Bf = new BusFilterPage(driver);
		Bf.filterAc();
	}

	@When("I select filter like Seat type")
	public void i_select_filter_like_seat_type() {
		BusFilterPage Bf = new BusFilterPage(driver);
		Bf.filterSleeper();
	}

	@Then("I should be able see the available busses")
	public void i_should_be_able_see_the_available_busses() {
	}

	@When("I click pickup point as {string}")
	public void i_click_pickup_point_as(String string) {
		BusFilterPage Bf = new BusFilterPage(driver);
		Bf.pickuppoint();
	}

	@Then("I should be able see the available busses according to preference")
	public void i_should_be_able_see_the_available_busses_according_to_preference() {
	}

	@When("I click on travel operater as {string}")
	public void i_click_on_travel_operater_as(String string) {
		BusFilterPage Bf = new BusFilterPage(driver);
		Bf.traveloperation();
	}

	@When("I click on drop point as {string}")
	public void i_click_on_drop_point_as(String string) {
		BusFilterPage Bf = new BusFilterPage(driver);
		Bf.drop_point();
	}

	@Then("I should see the buses from the travelers only")
	public void i_should_see_the_buses_from_the_travelers_only() {
	}

	@When("I click on select seats")
	public void i_click_on_select_seats() {
		BusFilterPage Bf = new BusFilterPage(driver);
		Bf.selectingseats();
	}

	@Then("I should see the seats available in bus")
	public void i_should_see_the_seats_available_in_bus() {
	}
}
