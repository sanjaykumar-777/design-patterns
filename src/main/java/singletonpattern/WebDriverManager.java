package singletonpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private static volatile WebDriverManager instance;

    //each thread-local will have the copy of the webdriver
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private WebDriverManager(){
    }

    //initializing the driver
    private void initDriver(String browser){
        switch (browser){
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
            case "edge":
                tlDriver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: "+browser);
        }
    }


    public static WebDriverManager getInstance(String browser){
        if(instance == null){
            synchronized (WebDriverManager.class){
                if (instance == null){
                    instance = new WebDriverManager();
                }
            }
        }

        if(tlDriver.get() == null){
            instance.initDriver(browser);
        }
        return instance;
    }

    //thread-local get method
    public WebDriver getDriver() {
        return tlDriver.get();
    }

    //quit the method
    public static void quitBrowser() {
        if (tlDriver.get() != null){
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
