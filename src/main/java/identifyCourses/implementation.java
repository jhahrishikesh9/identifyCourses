package identifyCourses;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import baseMethods.baseMethods;
public class implementation extends baseMethods{
	baseMethods base = new baseMethods();
	List<String> languages = new ArrayList<String>();
	List<WebElement>lang = new ArrayList<WebElement>();
	WebDriver driver = (base.driver());
	String baseUrl = base.getUrl();
	@Test(priority=0)
	public void search() throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']")).sendKeys("web development courses ");
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		//click on searchbox
		js.executeScript("document.getElementsByClassName('search-button')[0].click();");
		base.takeScreenshot("coursesDisplayed");
	}
	@Test(priority=1)
	public void levelFilter() throws IOException, InterruptedException {
		//filter according to beginner level
		driver.findElement(By.xpath("//span[@aria-label='Beginner']")).click();
		Thread.sleep(2000);
		base.takeScreenshot("coursesAfterApplyingBeginnerLevel");
		
	}
	@Test(priority=2)
	public void languageFilter() throws InterruptedException, IOException {
		String parentWindowHandle = driver.getWindowHandle();
		
		//Click on read more which will open a dialog box
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("document.getElementsByClassName('cds-32 cds-button-label')[5].click();");
		Thread.sleep(2000);
		String childWindowHandle = driver.getWindowHandle();      		//switch to child window handle
		driver.switchTo().window(childWindowHandle);
		
		//filtering according to english language
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		Thread.sleep(2000);		
		languages.add((driver.findElement(By.id("checkbox-group"))).getText());          //adding all the languages in text format to languages list
		js2.executeScript("document.querySelector(\"span[aria-label='English']\").click();");
		Thread.sleep(2000);
		base.takeScreenshot("selectingEnglishFilter");
		
		
		//closing the popup box
		driver.findElement(By.cssSelector("button[class='cds-60 cds-31 cds-33 css-clhowe cds-42 cds-button-disableElevation'] span[class='cds-32 cds-button-label']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentWindowHandle);
		base.takeScreenshot("CoursesAfterFilter");
		
	}
	
	//for course 1
	@Test(priority=3)
	public void displayCourse1() throws InterruptedException {
		
		System.out.println("Course 1 Details:");
		Thread.sleep(3000);
		String title = driver.findElement(By.xpath("//h2[normalize-space()='Introduction to Web Development']")).getText();
		
		//String title = driver.findElement(By.cssSelector("li:nth-child(1) div:nth-child(1) div:nth-child(1) a:nth-child(1) div:nth-child(1) div:nth-child(2) h2:nth-child(1)")).getText();
		System.out.println("Title is:"+title);
		String ratings = driver.findElement(By.cssSelector("div[aria-label='Introduction to Web Development course by University of California, Davis'] div[class='css-ilhc4l'] div p[class='cds-1 css-1hb1zhk cds-3']")).getText();
		System.out.print(ratings);
		System.out.println(driver.findElement(By.xpath("//div[@aria-label='Introduction to Web Development course by University of California, Davis']//div[@class='css-ilhc4l']//div//p[@class='cds-1 css-1cxz0bb cds-3'][normalize-space()='Beginner · Course · 1-3 Months']")).getText());
	}
	
	//for course 2
	@Test(priority=4)
	public void displayCourse2() {
		System.out.println("Course 2 Details:");
		String title = driver.findElement(By.xpath("//h2[normalize-space()='IBM Full Stack Software Developer']")).getText();
		System.out.println("Title is:"+title);
		String ratings = driver.findElement(By.cssSelector("div[aria-label='IBM Full Stack Software Developer professional certificate by IBM'] div[class='css-ilhc4l'] div p[class='cds-1 css-1hb1zhk cds-3']")).getText();
		System.out.println("Ratings is: "+ratings);
	}
	
	//for languages
	@Test(priority=5)
	public void languages() {
		System.out.println("Languages are:");
		ArrayList<String>ll = new ArrayList<String>();
		for(String i:languages) {
			System.out.println(i);
			ll.add(i);
		}
		int c=0;

	}
	@Test(priority=7)
	public void levels() {
		ArrayList<String>level = new ArrayList<String>();
		level.add(driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > fieldset:nth-child(1) > div:nth-child(2)")).getText());
		System.out.println(" ");
		System.out.println("Number of levels available is"+level.size());
		System.out.print("Levels are:");
		for(String i:level) {
			System.out.print(i);
		}
		int c=0;
		ArrayList<WebElement> ll = new ArrayList<WebElement>();
		ll.add(driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > fieldset:nth-child(1) > div:nth-child(2)")));
		for(WebElement i:ll) {
			System.out.println(i);
			c++;
		}
		System.out.print("c"+c);
		
	}
	@Test(priority=8)
	public void test3() throws InterruptedException {
		driver.navigate().to(baseUrl);;
		Thread.sleep(5000);
		
		
		driver.findElement(By.id("enterprise-link")).click();
	}
	
	@Test(priority=9)
	public void openCampus() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id("menu-item-9140"));
		action.moveToElement(element).perform();
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.partialLinkText("For Campus")).click();
		Thread.sleep(5000);
	}
	@SuppressWarnings("deprecation")
	@Test(priority=10)
	public void fillValues() throws InterruptedException {
		WebElement Element = driver.findElement(By.cssSelector("section[class='logos']"));
     
        //This will scroll the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        WebElement Element2 = driver.findElement(By.cssSelector(".site-footer"));
        
        //This will scroll the page till the element is found
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element2);
//        WebElement Element3 = driver.findElement(By.cssSelector(".icons-section.text-center.bg-highlight-primary"));
//        
//        //This will scroll the page till the element is found
//        JavascriptExecutor js3 = (JavascriptExecutor) driver;
//        js3.executeScript("arguments[0].scrollIntoView();", Element3);
        Thread.sleep(5000);
        //driver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        System.out.println(driver().manage().timeouts().getPageLoadTimeout());
        WebElement Element4 = driver.findElement(By.xpath("//body/div[3]"));
        driver.switchTo().activeElement();
        //This will scroll the page till the element is found
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("arguments[0].scrollIntoView();", Element4);
		driver.findElement(By.id("LastName")).sendKeys("aabc");
		
		Thread.sleep(2000);
		driver.findElement(By.id("FirstName")).sendKeys("aabc");
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("document.querySelectorAll(\"div[class='container text-center'] h2\")");
		
		//driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("test");
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}


}
