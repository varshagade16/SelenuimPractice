package seleniumPractise.SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		driver.get("https://www.redbus.in/");
		
		String year="2023";
		String month="oct";
		String date="10";
		driver.findElement(By.xpath("//input[@id=\"onward_cal\"]")).click();
		while(true)
		{
			String monthyear=driver.findElement(By.xpath("//td[@class=\"monthTitle\"]")).getText();
			String[] arr=monthyear.split(" ");
			String mon=arr[0];
			String yearr=arr[1];
			
			if(mon.equalsIgnoreCase(month) && year.equalsIgnoreCase(yearr))
			break;
			else
			{
				
				driver.findElement(By.xpath("//td[@class=\"next\"]")).click();
			}
			}
		
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class=\"rb-monthTable first last\"]//td"));
		
		for(WebElement datee:dates)
		{
			String ele=datee.getText();
			if(ele.equals(date))
			{
				datee.click();
				break;
			}
		}

		
	}

}
