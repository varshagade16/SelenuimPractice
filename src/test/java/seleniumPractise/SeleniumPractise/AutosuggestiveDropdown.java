package seleniumPractise.SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestiveDropdown {

	public static void main(String[] args) {

		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.bing.com/");
		driver.findElement(By.cssSelector("textarea[id=\"sb_form_q\"]")).sendKeys("Selenium");
		List<WebElement> drp=driver.findElements(By.xpath("//ul[@class=\"sa_drw\"]/li"));
		System.out.println(drp.size());
		for(WebElement option:drp)
		{
			try
			{
			if(option.getText().equalsIgnoreCase("Selenium"));
			{
				
				option.click();
			break;
			}
			}
			catch(Exception e)
			{
				option.click();
			}
		}
		}
		


}
