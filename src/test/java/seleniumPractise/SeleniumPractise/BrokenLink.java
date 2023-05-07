package seleniumPractise.SeleniumPractise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
       int brokenlinks=0;
	     ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			WebDriver driver =new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://www.amazon.com/");
			List<WebElement> links=driver.findElements(By.tagName("a"));
			for(WebElement link:links)
			{
				String url=link.getAttribute("href");
				if(url==null || url.isEmpty())
				{
					System.out.println("url is empty");
					continue;
				}
				URL url1=new URL(url);
				HttpURLConnection httpcon=(HttpURLConnection)url1.openConnection();
				httpcon.connect();
				if(httpcon.getResponseCode()>=400)
				{
					System.out.println(httpcon.getResponseCode()+url+" is"+ "is Broken link");
					brokenlinks++;
				}
				else
				{
					System.out.println(httpcon.getResponseCode()+url+ "is"+"is valid link");
				}
				
				}
			System.out.println(brokenlinks);
			driver.quit();
			}
	}


