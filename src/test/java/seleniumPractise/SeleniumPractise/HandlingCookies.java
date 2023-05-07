package seleniumPractise.SeleniumPractise;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); 
		driver.get("https://www.orangehrm.com/");
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println(cookies.size());
		
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()+": "+cookie.getValue());
		}
	}

}
