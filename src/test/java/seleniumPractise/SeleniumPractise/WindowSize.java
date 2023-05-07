package seleniumPractise.SeleniumPractise;

import java.awt.Dimension;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSize {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); 
		driver.get("https://www.orangehrm.com/");
		WebElement logo=driver.findElement(By.xpath("(//img[@alt=\"OrangeHRM Logo\"])[1]"));
		
		System.out.println(logo.getLocation());
		System.out.println(logo.getLocation().getX());
		System.out.println(logo.getLocation().getY());
		
	System.out.println(logo.getRect().getDimension().getHeight());
		System.out.println(logo.getRect().getDimension().getWidth());
		
		Dimension d=new Dimension();
		System.out.println(d.getSize());
		
	}

}
