package constants;

import enums.ConfigProperties;
import lombok.Getter;
import utils.PropertyUtil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
public final class FrameworkConstants {

    @Getter private static final String USER_DIR = System.getProperty("user.dir");
    @Getter private static final String RESOURCES_PATH = USER_DIR + "/src/test/resources";
    @Getter private static final String EDGE_DRIVER_PATH = RESOURCES_PATH + "/driver/msedgedriver.exe";
    @Getter private static final String CONFIG_FILE_PATH = RESOURCES_PATH + "/config/config.properties";
    @Getter private static final String EXCEL_PATH = RESOURCES_PATH + "/excel/testdata.xlsx";
    @Getter private static final int EXPLICIT_WAIT_TIME = 20;
    @Getter private static final String RUN_MANAGER_DATA_SHEET = "RUN MANAGER";
    @Getter private static final String ITERATION_DATA_SHEET = "DATA";
    @Getter private static final String EXTENT_REPORT_FOLDER_PATH = USER_DIR + "/extent-test-output/";
    @Getter private static final String REPORT_TITLE = "Selenium Test Report";
    @Getter private static final String REPORT_NAME = "TEST-NG";
    private static String extentReportFilePath = "";

    private FrameworkConstants() {
    }

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {

        if (PropertyUtil.get(ConfigProperties.OVERRIDE_REPORTS).equalsIgnoreCase("no")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh.mm.ss");
            LocalDateTime now = LocalDateTime.now();
            String folderName = dtf.format(now);
            return EXTENT_REPORT_FOLDER_PATH + folderName + "/index.html";
        } else {
            return EXTENT_REPORT_FOLDER_PATH + "/index.html";
        }
    }
}
