package utilities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;

import java.io.File;

public class LoggerUtility {

    // Use ThreadLocal to ensure each thread has its own logger instance
    private static final ThreadLocal<Logger> loggerThreadLocal = ThreadLocal.withInitial(() -> LogManager.getLogger());

    // ThreadLocal for log filename to avoid conflicts in parallel execution
    private static final ThreadLocal<String> logFileNameThreadLocal = new ThreadLocal<>();

    public void startTestCase(String testCaseName) {
        // Sanitize test case name for use in filenames
        String sanitizedTestCaseName = testCaseName.replaceAll("[^a-zA-Z0-9]", "_").replaceAll("_+", "_");

        // Generate a unique log filename using thread ID and timestamp
        String logFileName = sanitizedTestCaseName + "_" + Thread.currentThread().getId() + "_" + System.currentTimeMillis();
        logFileNameThreadLocal.set(logFileName);

        // Configure ThreadContext for the current thread
        ThreadContext.put("logFilename", logFileName);

        // Log the start of the test case
        info("\n\n************** Execution Started : " + testCaseName + " **************\n");
    }

    public void endTestCase(String testCaseName) {
        info("\n\n************** Execution End : " + testCaseName + " **************\n");

        // Clean up ThreadLocal variables to avoid memory leaks
        logFileNameThreadLocal.remove();
        loggerThreadLocal.remove();
    }

    private Logger getLogger() {
        return loggerThreadLocal.get();
    }

    private String getCallInfo() {
        // Use a more efficient way to get caller information (if needed)
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > 3) {
            StackTraceElement caller = stackTrace[3];
            return caller.getClassName() + ":" + caller.getMethodName() + " " + caller.getLineNumber() + " ==> ";
        }
        return "";
    }

    public void trace(Object message) {
        getLogger().trace(message);
    }

    public void trace(Object message, Throwable t) {
        getLogger().trace(message, t);
    }

    public void debug(Object message) {
        getLogger().debug(getCallInfo() + message);
    }

    public void debug(Object message, Throwable t) {
        getLogger().debug(getCallInfo() + message, t);
    }

    public void error(Object message) {
        getLogger().error(getCallInfo() + message);
    }

    public void error(Object message, Throwable t) {
        getLogger().error(getCallInfo() + message, t);
    }

    public void fatal(Object message) {
        getLogger().fatal(getCallInfo() + message);
    }

    public void fatal(Object message, Throwable t) {
        getLogger().fatal(getCallInfo() + message, t);
    }

    public void info(Object message) {
        getLogger().info(getCallInfo() + message);
    }

    public void info(Object message, Throwable t) {
        getLogger().info(getCallInfo() + message, t);
    }

    public void warn(Object message) {
        getLogger().warn(getCallInfo() + message);
    }

    public void warn(Object message, Throwable t) {
        getLogger().warn(getCallInfo() + message, t);
    }
}
