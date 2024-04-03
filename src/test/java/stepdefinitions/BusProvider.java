package stepdefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyPageFactory.BusPage;



public class BusProvider {
	WebDriver driver;
	@Test(dataProvider="testdata")
	
	public void Program(String From,String To) throws InterruptedException, AWTException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-frame']")));
		driver.switchTo().frame(frame); 
		WebElement clsBtn =driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
		clsBtn.click();
		String parentWindowHandle=driver.getWindowHandle();
		driver.switchTo().window(parentWindowHandle);
		BusPage bp = new BusPage(driver);
		bp.SearchBus();
		WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement from = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromCity")));
		from.click();
		WebElement fromField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));
		BusPage sfrom = new BusPage(driver);
		sfrom.chooseStartingFrom(From);
		BusPage sto = new BusPage(driver);
		sto.selectto(To);
		BusPage sdate = new BusPage(driver);
		sdate.SelectDate();
		BusPage click = new BusPage(driver);
		click.Searchclick();

	}
	@DataProvider(name="testdata")
	public Object readcell(){
		MyPageFactory.ExcelUtilities utilities = new MyPageFactory.ExcelUtilities("C:\\Users\\CHSRAVAN\\Documents\\sheet.xlsx");
		int rows = utilities .getRowCount(0);
		Object[][] logindetails=new Object[rows][2];
		for(int i=0;i<rows;i++) { 
			for(int j=0;j<2;j++) { 
				logindetails[i][j]=  utilities .readcell(0,i+1,j); 
			} 
		} 
		return logindetails; 

	}

}
