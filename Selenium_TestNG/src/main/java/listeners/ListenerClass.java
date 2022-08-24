package listeners;

import annotations.FrameworkAnnotation;
import org.testng.*;
import report.ExtentLogger;
import report.ExtentReport;
import utils.ScreenshotUtil;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .category());
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", ScreenshotUtil.getBase64Image());
        ExtentLogger.fail(result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /*
         * For now, we are not using this.
         */
    }

    @Override
    public void onStart(ITestContext context) {
        /*
         * We are having just one test in our suite. So we dont have any special implementation as of now
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
         * We are having just one test in our suite. So we dont have any special implementation as of now
         */

    }

}
