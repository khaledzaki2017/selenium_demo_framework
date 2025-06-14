package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetup {
    static ExtentReports extent;

    public static ExtentReports setupExtentReport() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String reportPath = System.getProperty("user.dir") +
                "/Reports/ExecutionReport_" + actualDate + ".html";

        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(sparkReport);

        sparkReport.config().setDocumentTitle("Automation Test Report");
        sparkReport.config().setTheme(Theme.DARK);
        sparkReport.config().setReportName("Test Execution Report");

        // Replace this with your property fetching logic
        extent.setSystemInfo("Executed on Environment: ", PropertiesManager.getPropertyValueByKey("url"));
        extent.setSystemInfo("Executed on Browser: ", PropertiesManager.getPropertyValueByKey("browser"));
        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

        return extent;
    }
}
