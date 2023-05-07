package seleniumPractise.SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); 
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		WebElement inputbox=driver.findElement(By.xpath("//input[@id=\"age\"]"));
		String tooltiptext=inputbox.getAttribute("title");
		System.out.println(tooltiptext);

	}

}
