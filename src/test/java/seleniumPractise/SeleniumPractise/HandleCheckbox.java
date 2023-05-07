package seleniumPractise.SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {

	public static void main(String[] args) throws InterruptedException {
		
		

		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		//driver.findElement(By.xpath("(//input[@class=\"form-check-input\"])[4]")).click();
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class=\"form-check-input\" and contains(@id,'day')]"));
		System.out.println(checkboxes.size());
		//+Thread.sleep(5000);
		/*for(int i=0;i<checkboxes.size();i++)
		{
			System.out.println(checkboxes.get(i).getText());
			checkboxes.get(i).click();
		}*/
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,990)"," ");
		
		/*for(WebElement checkbox:checkboxes)
		{
			String chname =checkbox.getAttribute("id");
			if(chname.equalsIgnoreCase("monday") || chname.equalsIgnoreCase("sunday"))
			{
				checkbox.click();
			}
		
		}*/
		
		int total=checkboxes.size();
		for(int i=total-3;i<total;i++)
		{
			checkboxes.get(i).click();
		}
		
		
	}

}
