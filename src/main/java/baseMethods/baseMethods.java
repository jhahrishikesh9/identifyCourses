package baseMethods;

import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import excelSheet.readExcel;

public class baseMethods {
	WebDriver driver = null;
	String baseUrl = null;
	public WebDriver driver(){
		readExcel r  = new readExcel();
		try {
			readExcel.setExcelFile();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		FileReader file;
		try {
			file = new FileReader(readExcel.getCellData(1, 1));
			Properties p = new Properties();
			try {
				p.load(file);
				String browser = p.getProperty("browser"); 
				System.out.print(browser);
				if(browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",readExcel.getCellData(3, 1));
					driver = new ChromeDriver();
				}
				if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver",readExcel.getCellData(7, 1));
					driver = new FirefoxDriver();
				}
				else {
					System.out.println("Wrong browser");
				}
				//this.driver = new ChromeDriver();
				driver.get(getUrl());
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.manage().window().maximize();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    return driver;
	   
	}
	public String getUrl() {
		baseUrl = readExcel.getCellData(2, 1);
		return baseUrl;
	}
	
	//takeScreenshot method
	public void takeScreenshot(String fileName) throws IOException{
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Copy file at destination
		FileUtils.copyFile(file,new File("C:\\Users\\HP\\eclipse-workspace\\identifyCourses\\Screenshots\\"+fileName+".png"));
	}
	


}
