package seleniumPractise.SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkInNewTaB {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); 
		driver.get("https://demo.nopcommerce.com/");
	    //String tab=	Keys.chord(Keys.CONTROL,Keys.RETURN);
		//driver.findElement(By.xpath("//a[text()='Register']")).sendKeys(tab);

		driver.switchTo().newWindow(WindowType.TAB);
		  driver.get("https://www.opencart.com/");
		
	}

}
