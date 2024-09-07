package DealsDray.DealsDray;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalTesting2 
{
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.firefoxdriver().setup();
		
	       WebDriver driver=new FirefoxDriver();
	       driver.get("https://demo.dealsdray.com");
	       driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
	       driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
           driver.findElement(By.xpath("//button[@ type='submit']")).click();
           Thread.sleep(1000);
           driver.findElement(By.xpath("//span[@class='material-icons notranslate MuiIcon-root MuiIcon-fontSizeSmall css-va0op3']")).click();
           Thread.sleep(3000);
           driver.findElement(By.xpath("//span[@class='sidenavHoverShow MuiBox-root css-i9zxpg'][normalize-space()='Orders']")).click();
           Thread.sleep(3000);
           driver.findElement(By.xpath("//button[normalize-space()='Add Bulk Orders']")).click();
           WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
           element.sendKeys("C:\\Users\\PRIYANKA S\\Downloads\\demo-data (1).pdf");
           driver.findElement(By.xpath("//button[text()='Import']")).click();
           driver.findElement(By.xpath("//button[normalize-space()='Validate Data']")).click();
           driver.quit();
           
           
	}

}
