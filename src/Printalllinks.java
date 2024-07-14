import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Printalllinks {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\T420\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver = driver.findElement(By.cssSelector("div#gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement coloumndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
System.out.println(coloumndriver.findElements(By.tagName("a")).size());
		
		//4- click on each link in the coloumn and check if the pages are opening-
		for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
		{
			
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
			
		}// opens all the tabs
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();
		
		while(it.hasNext())
		{
			
		   driver.switchTo().window(it.next());
		   System.out.println(driver.getTitle());
		
		}
			
		
		

	}

}
