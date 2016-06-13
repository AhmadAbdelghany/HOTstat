package ie.nuim.hotstat.selenium;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReportGenerationScenarioTest {
    
    static WebDriver driver;
    static Wait<WebDriver> wait;
    static int delay=0; // optional delay so you can watch progress
    static String url="http://localhost:80/hotstat/report/1/generate";
    
    WebElement field1, field2, field3, field4;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
//        MarionetteDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.get(url);
//      wait = new WebDriverWait(driver, 30);
//      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("reportId")));
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.close();
    }

    /**
     * Tests report id is visible on the header
     * @throws Exception
     */
    @Test
    public void testReportId() throws Exception {
        String actual = driver.findElement(By.id("reportId")).getText();
        String expected = "1";
        assertEquals(actual, expected);
    }
    
    /**
     * Tests name of measure 1
     * @throws Exception
     */
    @Test
    public void testMeasure1Name() throws Exception {
        String actual = driver.findElement(By.id("measure1Name")).getText();
        String expected = "BUILDINGS";
        assertThat(actual, is(expected));
    }
    
    /**
     * Tests result of measure 1
     * @throws Exception
     */
    @Test
    public void testMeasure1Result() throws Exception {
        String actual = driver.findElement(By.id("measure1Result")).getText();
        String expected = "107";
        assertThat(actual, is(expected));
    }
    
    /**
     * Tests score of measure 1
     * @throws Exception
     */
    @Test
    public void testMeasure1Score() throws Exception {
        String actual = driver.findElement(By.id("measure1Score")).getText();
        String expected = "1.9 out of 5";
        assertThat(actual, is(expected));
    }

}
