package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import constants.FrameworkConstants;
import enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

	private ExtentReport() {}

	private static ExtentReports extent;

	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath())
					.viewConfigurer()
					.viewOrder()
					.as(new ViewName[]{ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY,ViewName.DEVICE,ViewName.AUTHOR})
					.apply();
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle(FrameworkConstants.getREPORT_TITLE());
			spark.config().setReportName(FrameworkConstants.getREPORT_NAME());
		}
	}

	public static void flushReports(){
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extent.createTest(testCaseName));
	}
	
	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}
	

	public static void addCategories(CategoryType[] categories) {
		for(CategoryType temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}




}
