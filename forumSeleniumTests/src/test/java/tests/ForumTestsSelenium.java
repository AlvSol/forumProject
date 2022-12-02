package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class ForumTestsSelenium {
	
	private WebDriver driver;
	private static String TIPO_DRIVER = "webdriver.chrome.driver";
	private static String PATH_DRIVER = "./src/test/resources/webDriver/chromedriver.exe";
	
	private String URL1 = "http://localhost:3000/home";
	private String URL2 = "http://localhost:3000/thread/0";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(URL1);
	}
	
	//Click on thread 1 (Martial arts) see posts
	@SuppressWarnings("deprecation")
	@Test
	public void test1() {
		
		String text = "Martial arts";
		
		driver.get(URL1);
		
		driver.findElement(By.id("0")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement elem = driver.findElement(By.className("ThreadTitle"));
		String title = elem.getText();
		
		Assert.assertTrue(title.contains(text));
		
		System.out.println("TEST 1 FINISHED");
	}
	
	//Click on the register switch to check that there are less posts if you are not registered.
	@SuppressWarnings("deprecation")
	public void test2() {
		
		driver.get(URL2);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> rows1 = (List<WebElement>) driver.findElement(By.cssSelector("[class='table table-condensed table-hover event-list'] tr"));
		
		driver.findElement(By.id("switchRegister")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> rows2 = (List<WebElement>) driver.findElement(By.cssSelector("[class='table table-condensed table-hover event-list'] tr"));
		
		Assert.assertTrue("Bigger first number of rows than after filtering", rows1.size() > rows2.size());
		System.out.println("TEST 2 FINISHED");
	}
	
	//Click on add post button and check if it opens properly the popup
	@Test
	public void test3() {
		
		driver.get(URL2);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.className("addPostButton")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement elem = driver.findElement(By.className("CreatePostPopUp"));
		
		System.out.println("TEST 3 FINISHED");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("TERMINARON LOS TESTS");
	}

}
