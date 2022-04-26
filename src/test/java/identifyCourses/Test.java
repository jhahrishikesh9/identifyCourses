package identifyCourses;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Test {
	//@org.testng.annotations.Test
	implementation i = new implementation();
	WebDriver driver;
	@org.testng.annotations.Test
	public void search(){
		try {
			i.search();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.testng.annotations.Test
	public void filterLevel() {
		try {
			i.levelFilter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.testng.annotations.Test
	public void filterLanguage() {
		try {
			i.languageFilter();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.testng.annotations.Test
	public void displayCourse1() throws InterruptedException {
		i.displayCourse1();
	}
	@org.testng.annotations.Test
	public void displayCourse2() {
		i.displayCourse2();
	}
	@org.testng.annotations.Test
	public void levels() {
		i.levels();
	}
	@org.testng.annotations.Test
	public void test3() {
		try {
			i.test3();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.testng.annotations.Test
	public void opencampus() {
		try {
			i.openCampus();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.testng.annotations.Test
	public void fillValues() {
		try {
			i.fillValues();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}