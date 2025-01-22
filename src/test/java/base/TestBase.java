package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertiesManager;

import java.time.Duration;

public class TestBase {
    BrowserFactory bf =new BrowserFactory();

    @BeforeMethod
    public void launchApp(){
        String browser= PropertiesManager.getPropertyValueByKey("browser");
        String url= PropertiesManager.getPropertyValueByKey("url");

        DriverFactory.getDrinstance().setDriver(bf.createBrowserInstance(browser));
        WebDriver driver=DriverFactory.getDrinstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(url);


    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getDrinstance().closeBrowser();
    }

}
