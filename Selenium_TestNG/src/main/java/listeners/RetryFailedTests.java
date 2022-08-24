package listeners;

import enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.PropertyUtil;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;


    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;

        if (PropertyUtil.get(ConfigProperties.RETRY_FAILED_TESTS).equalsIgnoreCase("yes")) {
            int retries = 1;
            value = count < retries;
            count++;
        }
        return value;
    }

}
