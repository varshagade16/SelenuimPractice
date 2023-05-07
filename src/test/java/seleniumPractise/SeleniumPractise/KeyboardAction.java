package seleniumPractise.SeleniumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardAction {

	public static void main(String[] args) {

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); 
		/*driver.get("https://the-internet.herokuapp.com/key_presses");
		Actions act =new Actions(driver);
		//act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(Keys.RETURN).build().perform();*/
		driver.get("https://text-compare.com/");
		WebElement input1=driver.findElement(By.xpath("//textarea[@id=\"inputText1\"]"));
		WebElement input2=driver.findElement(By.xpath("//textarea[@name=\"text2\"]"));
		input1.sendKeys("Welcome to selenuim");
		Actions act= new Actions(driver);
		
		//control +c//
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
  //control+c
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//tab
		
		act.sendKeys(Keys.TAB).build().perform();
		
		//control +v
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		if(input1.getAttribute("value").equals(input2.getAttribute("value")))
		{
			System.out.println("text is copied");
		}
		else
		{
			System.out.println("text is not copied");
		}
		
		
	}

}
