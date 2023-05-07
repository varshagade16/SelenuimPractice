package seleniumPractise.SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrame {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//a[normalize-space()='AbstractAnnotations']")).click();
        
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        
        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("(//th[@class=\"colFirst\"])[2]")).click();
	}

}
