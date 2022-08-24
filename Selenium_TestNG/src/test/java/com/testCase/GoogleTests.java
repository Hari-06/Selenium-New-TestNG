package com.testCase;

import annotations.FrameworkAnnotation;
import com.page.GooglePage;
import enums.CategoryType;
import org.testng.annotations.Test;
import java.util.Map;
public class GoogleTests extends BaseTest {

    private GoogleTests() {
    }

    //@Test
    @FrameworkAnnotation(
            category = {CategoryType.MINI_REGRESSION},
            author = {"HARI", "TEERAN"})
    public void google_Test(Map<String, String> data) {
        GooglePage username = new GooglePage().enterSearchText(data.get("username")).clickSearch();
        username.getTitle();
    }


}
