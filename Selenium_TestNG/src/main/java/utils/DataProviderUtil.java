package utils;

import constants.FrameworkConstants;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;


public final class DataProviderUtil {

    private static List<Map<String, String>> list = new ArrayList<>();

    private DataProviderUtil() {
    }

    @DataProvider(parallel = true)
    public static Object[] getData(Method m) {

        String testName = m.getName();

        if(list.isEmpty()) {
            list = ExcelUtil.getTestDetails(FrameworkConstants.getITERATION_DATA_SHEET());
            System.out.println("In Data Provider Utils: "+list);
        }
        List<Map<String, String>> smallList = new ArrayList<>(list);

        Predicate<Map<String,String>> isTestNameNotMatching = map ->!map.get("Test Name").equalsIgnoreCase(testName);
        Predicate<Map<String,String>> isExecuteColumnNo = map -> map.get("Execute").equalsIgnoreCase("no");

        smallList.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));
        System.out.println("Final List in Data Provider Utils:"+ Arrays.toString(smallList.toArray()));
        return smallList.toArray();
    }
}
