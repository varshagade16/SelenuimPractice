package seleniumPractise.SeleniumPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WelcomeJava {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	System.out.println("Hello and welcome to Java Maven Project Created");
	
	
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
	//	driver.close();

	}

}
