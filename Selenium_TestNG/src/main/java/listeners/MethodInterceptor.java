package listeners;

import constants.FrameworkConstants;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import utils.ExcelUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MethodInterceptor implements IMethodInterceptor {

    // This Listener class is used to maintain the testng test data from Excel
    // will be Executed only once in the entire run
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String, String>> list = ExcelUtil.getTestDetails(FrameworkConstants.getRUN_MANAGER_DATA_SHEET());
        List<IMethodInstance> result = new ArrayList<>();

        for (int i = 0; i < methods.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("Test Name")) &&
                        list.get(j).get("Execute").equalsIgnoreCase("Yes")) {
                    methods.get(i).getMethod().setDescription((list.get(j).get("Test Description")));
                    methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));
                    methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("Priority")));
                    result.add(methods.get(i));
                }

            }
        }
        if(result.isEmpty()){
            System.out.println("Please select some test cases in "+FrameworkConstants.getEXCEL_PATH()+" to execute.");
        }
        return result;
    }

}
