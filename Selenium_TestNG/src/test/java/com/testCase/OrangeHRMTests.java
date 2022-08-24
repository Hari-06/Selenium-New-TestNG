package com.testCase;

import annotations.FrameworkAnnotation;
import com.page.OrangeHRMLoginPage;
import enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import report.ExtentLogger;
import utils.ScreenshotUtil;

import java.util.Map;

public class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test
    @FrameworkAnnotation(
            category = {CategoryType.REGRESSION, CategoryType.MINI_REGRESSION},
            author = {"HARI", "TEERAN"})
    public void login_Logout_Test(Map<String, String> data) {
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .clickWelcome()
                .clickLogout()
                .getTitle();
       ExtentLogger.pass("Login Successful", ScreenshotUtil.getBase64Image());

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");


    }


}
