package seleniumPractise.SeleniumPractise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException {

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); 
		driver.get("https://demo.nopcommerce.com/");
		
		//fullpage Screenshot
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshots\\homepage.png");
		FileUtils.copyFile(src, dest);
		//SECTIONOF PAGE
		WebElement section=driver.findElement(By.xpath("//div[@class=\"category-item\"]"));
		File src1=section.getScreenshotAs(OutputType.FILE);
		File dest2=new File(".\\Screenshots\\homepage1.png");
		FileUtils.copyFile(src1, dest2);
		
		//FIELD OF PAHE
		
		WebElement textbox=driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]"));
		
		
		File src3=textbox.getScreenshotAs(OutputType.FILE);
		File dest4=new File(".\\Screenshots\\homepage3.png");
		FileUtils.copyFile(src3, dest4);
		

	}

}
