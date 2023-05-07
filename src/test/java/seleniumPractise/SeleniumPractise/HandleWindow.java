package seleniumPractise.SeleniumPractise;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindow {

	public static void main(String[] args) throws InterruptedException {
		

		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//String handle=driver.getWindowHandle();
		//System.out.println(handle);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> windowid=driver.getWindowHandles();
		//System.out.println(windowid);

	Iterator<String> it=windowid.iterator();
	String parentid=it.next();
	String childid=it.next();
	System.out.println(parentid);
	System.out.println(childid);
	driver.switchTo().window(parentid);
	String tiltlwe=driver.getTitle();
	System.out.println(tiltlwe);
   driver.switchTo().window(childid);
   Thread.sleep(5000);
	String titlech=driver.getTitle();
	System.out.println(titlech);
	//driver.close();
	driver.quit();
	}
	

}
