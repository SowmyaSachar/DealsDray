package DealsDray.DealsDray;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
//import org.openqa.selenium.firefox.FirefoxDriver;
	//import org.openqa.selenium.safari.SafariDriver;
    import org.openqa.selenium.Dimension;
    import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.io.FileHandler;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;

	public class ScreenshotAutomation {
	    private WebDriver driver;

	    public void setup(String browser) {
	        if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        }
	    }
//	        } else if (browser.equalsIgnoreCase("firefox")) {
//	            WebDriverManager.firefoxdriver().setup();
//	            driver = new FirefoxDriver();
//	        } else if (browser.equalsIgnoreCase("safari")) {
//	            driver = new SafariDriver();
//	        }
	    //}

	    public void takeScreenshot(String folderPath) throws IOException {
	        String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileHandler.copy(screenshot, new File(folderPath + "/screenshot-" + timestamp + ".png"));
	    }

	    public void clickFirstThreeLinksAndTakeScreenshots(String url, String device, int width, int height) throws IOException {
	        driver.get(url);
	        driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));

	        // Loop to click and capture screenshots for the first 3 links
	        for (int i = 0; i < 5; i++) {
	            // Re-fetch the list of links after each navigation back to avoid stale element exceptions
	            List<WebElement> links = driver.findElements(By.xpath("(//a[contains(@href, 'http')])[position()<=5]")); 

	            // Make sure we are handling the case where there might not be enough links
	            if (i < links.size()) {
	                String linkHref = links.get(i).getAttribute("href");
	                System.out.println("Navigating to: " + linkHref);
	                driver.navigate().to(linkHref);  // Navigate to the link

	                // Take screenshot after page loads
	                String folderPath = "F:/DealsDray/DealsDray/screenshots/" + device + "/" + width + "x" + height;
	                new File(folderPath).mkdirs();  // Create directories if they don't exist
	                takeScreenshot(folderPath);

	                // Navigate back to the home page
	                driver.navigate().back();
	            } else {
	                System.out.println("Less than 5 links found on the page.");
	                break;
	            }
	        }
	    }

	    public void runTests(List<String> browsers, List<int[]> resolutions) throws IOException {
	        String homepageUrl = "https://www.getcalley.com/";

	        for (String browser : browsers) {
	            setup(browser);
	            for (int[] res : resolutions) {
	                clickFirstThreeLinksAndTakeScreenshots(homepageUrl, browser, res[0], res[1]);
	            }
	            driver.quit();
	        }
	    }
	}

		

	


