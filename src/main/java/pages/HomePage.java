package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseFunctions.reuseableFunctions;
public class HomePage extends reuseableFunctions {
	
	By acceptCookiesButton = By.xpath("//button[text()='Accept All Cookies']");
	
	public void method(WebDriver driver)  {
		
		waitForVisibilityOfElement(driver, acceptCookiesButton, 10);
		driver.findElement(acceptCookiesButton).click();

		WebElement searchBox = driver.findElement(By.xpath("//xhr-header-component[@class='loaded']")).getShadowRoot().
				findElement(By.cssSelector(".loaded")).getShadowRoot().
				findElement(By.cssSelector("xhr-search")).getShadowRoot().
				findElement(By.cssSelector("#search > input"));
		
		
		searchBox.sendKeys("Pay");
		
		WebElement searchIcon = driver.findElement(By.xpath("//xhr-header-component[@class='loaded']")).getShadowRoot().
				findElement(By.cssSelector(".loaded")).getShadowRoot().
				findElement(By.cssSelector("xhr-search")).getShadowRoot().
				findElement(By.cssSelector("#search > button"));
		
		searchIcon.click();
		
	}
		
}
