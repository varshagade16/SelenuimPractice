package seleniumPractise.SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver =new ChromeDriver(options);
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Thread.sleep(20000);
		WebElement drpcountry=driver.findElement(By.cssSelector("select[id='input-country']"));
		//Select select=new Select(drpcountry);
		
		Select s = new Select(drpcountry);
		s.deselectByVisibleText("Albania");
		//s.selectByValue(null)

	}

}
