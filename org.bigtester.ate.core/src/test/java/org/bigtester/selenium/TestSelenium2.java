package org.bigtester.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class TestSelenium2 {
  @Test
  public void f() {
	  FirefoxProfile profile = new FirefoxProfile();
	  //profile.setPreference(key, value);
	  WebDriver driver = new FirefoxDriver();

		// And now use this tovisit Google

		driver.get("about:config");

		// Alternatively thesame thing can be done like this

		// driver.navigate().to("http://www.google.com");

		// Find the text inputelement by its name

		WebElement element = driver.findElement(By.id("warningButton"));

		// Enter something tosearch for

		element.click();

		
		// Check the title ofthe page

		System.out.println("Page title is: " + driver.getTitle());

		// Should see:"cheese! - Google Search"

		System.out.println("Page title is: " + driver.getTitle());

		// Close the browser

		driver.quit();
  }
}
