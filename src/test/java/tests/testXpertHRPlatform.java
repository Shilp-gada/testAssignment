package tests;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseFunctions.reuseableFunctions;
import pages.HomePage;
import pages.SearchResultsPage;

public class testXpertHRPlatform {

        HomePage homePage = new HomePage();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        reuseableFunctions reusableFunction = new reuseableFunctions();

        @Test
        public void testXpertHRPlatformSearch() {

            // open the browser and go to the xpertHR portal
        	System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.xperthr.co.uk/");
            driver.manage().window().maximize();

			
            // Implicit wait for 10 seconds
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            // Search the keyword 'Pay' on the homePage
            homePage.method(driver);
            
            // Retrieve the number of results obtained
            int totalSearchResults = searchResultsPage.getTotalSeachResults(driver);
            
            // apply sorting with 'Employment law guide' and get the number of results after sorting
            searchResultsPage.applySorting(driver, "Employment law guide");
            
            // Retrieve the number of results obtained post sorting
            int totalSortResults = searchResultsPage.getTotalSeachResults(driver);
            
            //verify no of results in search is greater than or equal no of results after filter
            Assert.assertTrue(totalSearchResults>=totalSortResults, "Sorting not happeing correctly");
            
            // close the browser
            driver.quit();

			 
        }
    }
