package seleniumPractise.SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatepickerSelect {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); 
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,990)"," ");
		driver.findElement(By.xpath("//input[@id=\"departon\"]")).click();
		WebElement mon=driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
		Select select=new Select(mon);
		select.selectByVisibleText("Jul");
		
		WebElement year= driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
		Select select1=new Select(year);
		select1.selectByVisibleText("2023");
	
	String date="19";
	
	List<WebElement> alldates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td/a"));
	
	System.out.println("All Dates "+alldates.size());
//	for(WebElement dt:alldates)
	
	for(int i=0;i<alldates.size();i++)
	{
		//Thread.sleep(5000);
		System.out.println("ELE Dates "+alldates.get(i).getText());
		String ele=alldates.get(i).getText();
		
		
		if(ele.contains(date))
		{
		//Thread.sleep(5000);
		alldates.get(i).click();
		break;
		}
		else
		{
		continue;
		}	
		
	}
	
//	driver.close();
	}
	
}
