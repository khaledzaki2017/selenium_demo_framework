package base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentFactory {
    //private constructor so that no one else can create objects of this class
    private ExtentFactory(){

    }
    private static ExtentFactory ex_instance =new ExtentFactory();
    public static ExtentFactory getExtentInstance(){
        return ex_instance;

    }
    ThreadLocal<ExtentTest> extent=new ThreadLocal<ExtentTest>();
    public void setExtent(ExtentTest extentTestObj){
        extent.set(extentTestObj);
    }
    public ExtentTest getExtent(){
        return extent.get();
    }

}
