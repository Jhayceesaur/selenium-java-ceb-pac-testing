import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SearchFlights 
{

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions options1 = new ChromeOptions(); //ChromeOptions interface
		options1.addArguments("disable-notifications"); //Disable notification pop-up
		options1.addArguments("disable-geolocation"); //Disable location pop-up
		options1.addArguments("disable-mediastream"); //Disable mic and camera pop-up
		
		WebDriver driver = new ChromeDriver(options1); //Add instance from ChromeOptions
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.cebupacificair.com/en-PH/");
		
		//Handling auto suggestive drop down
		driver.findElement(By.id("'destinationFormControl-0")).sendKeys("si");
		Thread.sleep(2000);
		List<WebElement> options2 = driver.findElements(By.xpath("(//a[@class='country_under ng-tns-c15-18 ng-star-inserted'])[5]"));
		for (WebElement option  : options2) 
		{
			if(option.getText().equalsIgnoreCase("Singapore")) 
				{
					option.click();
					break;
				}
			
		}

	}

}
