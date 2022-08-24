package report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    private static String getMarkupHelper(String message, ExtentColor color){
        return MarkupHelper.createLabel(message, color).getMarkup();
    }

    public static void pass(String message, String base64Screenshot) {
        ExtentManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message, String base64Screenshot) {
        ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }


    public static void info(String message, String base64Screenshot) {
        ExtentManager.getExtentTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

}
