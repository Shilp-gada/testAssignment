package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseFunctions.reuseableFunctions;

public class SearchResultsPage extends reuseableFunctions{
	
	By totalSeachResults = By.xpath("//div[@id='ResultsTitle']/p/span");
	By sortFilter = By.xpath("//label[text()='Resource Type']");
	
	
	public int getTotalSeachResults(WebDriver driver) {
		
		waitForVisibilityOfElement(driver, totalSeachResults, 10);	
		String[] strarr = driver.findElement(totalSeachResults).getText().trim().split(" ");
		System.out.println("No of results obtained = "+strarr[1]);
		
		return Integer.parseInt(strarr[1]);		
	}
	
	public void applySorting(WebDriver driver, String sortoption) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortFilter));
        
        driver.findElement(sortFilter).click();
        driver.findElement(By.xpath("//a[text()='"+sortoption+"']")).click();
				
	}

}
