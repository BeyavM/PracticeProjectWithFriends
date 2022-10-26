package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    // a Singleton driver
    // creating a private constructor, so we are closing access to the object of this class. from outside any classes
    private Driver(){}

    // making our 'driver' instance private because we do not want it to be reachable from outside any class
    // we make it static because we dont want to create an object and for it to be used before anything else. not to mention we will use it in a static method
    private static WebDriver driver;


    // creating a reusable method which will return the same driver instance when we call it
    public static WebDriver getDriver(){
        if (driver == null){
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                default:
                    System.out.println("Driver does not exist, Options are: " + "\nchrome" + "\nfirefox" + "\nedge" + "\nsafari");
            }
        }

        // same driver instance will return everytime we call driver
        return driver;
    }


    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver = null; //creates new session. if we dont do this step we will have exceptions when we use the method since the previous session is no longer available
        }
    }
}
