package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import utils.DataProviderUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer{

	// controls the test method at run time
	// priority setting
	// enabled = true or false
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtil.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

	

}
