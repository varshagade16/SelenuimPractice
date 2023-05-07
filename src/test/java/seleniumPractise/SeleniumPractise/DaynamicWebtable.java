package seleniumPractise.SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DaynamicWebtable {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.get("https://demo.opencart.com/admin/");
		WebElement username=driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
		username.clear();
		username.sendKeys("demo");
		WebElement password=driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
		password.clear();
		password.sendKeys("demo");
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click(); 
		//Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class=\"btn-close\"]")).click();
		driver.findElement(By.xpath("//nav[@id=\"column-left\"]/ul/li[5]")).click();
		driver.findElement(By.xpath("//ul[@class=\"collapse show\"]/li[1]")).click();
		String text=driver.findElement(By.xpath("//div[@class=\"col-sm-6 text-end\"]")).getText();
		System.out.println(text);
		//text.indexOf("(");
		//text.indexOf("pages");
		//int totalpages= Integer.valueOf(text.substring(text.indexOf("("),text.indexOf("pages")));
		//System.out.println("totalpages");
	   /* String val1[]=text.split("(");
	    String val[]=val1[1].split(" ");
	  System.out.println(Integer.valueOf(val[0]));*/
	    
	
		

	}

}
