package singletonpattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class AppTest {
    private WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome")String browser) {
        driver = WebDriverManager.getInstance(browser).getDriver();
    }

    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
        System.out.println(Thread.currentThread().getName() + ": " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitBrowser();
    }

}
