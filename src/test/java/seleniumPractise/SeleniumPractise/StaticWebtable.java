package seleniumPractise.SeleniumPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebtable {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.get("https://www.selenium.dev/ecosystem/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,990)"," ");
		List<WebElement> rows=driver.findElements(By.xpath("(//table[@class=\"table\"])[1]//tr"));
	   System.out.println(rows.size());
	
	  List<WebElement> colums=driver.findElements(By.xpath("(//table[@class=\"table\"])[1]//thead/tr/th"));
	
      System.out.println(colums.size());
    // String value=driver.findElement(By.xpath("(//table[@class=\"table\"])[1]/tbody/tr[4]/td[2]")).getText();
     //System.out.println(value);
     
     
    /* for(int i=1;i<=rows.size();i++)
     {
    	 for(int j=1;j<=colums.size();j++)
    	 {
    		 String value=driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr["+i+"]/td["+j+"]")).getText();
    	     System.out.println(value);
    	 }
     }*/
      
      for(int r=1;r<=rows.size();r++)
      {
    	  String name=driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr["+r+"]/td[1]")).getText();

    	  if(name.equals("selenuim"))
    	  {
    		  String langauge=driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr["+r+"]/td[2]")).getText();
    		  System.out.println(langauge);
    		  String autor=driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr["+r+"]/td[3]")).getText();
    		  System.out.println(autor);
    		  
    	  }
    	  
    	  
      }
      driver.quit();
	
	}

}
