package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    //create Webdriver object for given browser
    public WebDriver createBrowserInstance(String browser){
        WebDriver driver=null;
        if (browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--incognito");
            driver=new ChromeDriver(options);


        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions foptions=new FirefoxOptions();
            foptions.addArguments("-private");

            driver=new FirefoxDriver();


        }if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            EdgeOptions edoptions= new EdgeOptions();
            edoptions.addArguments("-inprivate");
            driver=new EdgeDriver(edoptions);

        }
        return driver;
    }
}
