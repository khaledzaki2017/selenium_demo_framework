package base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    //private constructor so that no one else can create objects of this class
    private DriverFactory(){

    }
    private static DriverFactory dr_instance =new DriverFactory();
    public static DriverFactory getDrinstance(){
        return dr_instance;

    }
    ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
    public void setDriver(WebDriver driverParm){
        driver.set(driverParm);
    }
    public WebDriver getDriver(){
    return driver.get();
    }
    public void closeBrowser(){
        driver.get().close();
        driver.remove();
    }
}
