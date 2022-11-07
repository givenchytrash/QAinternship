package ui;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.ITestContext;

public class ListenersTest implements ITestListener{
	
		Logger tstlog = (Logger) LogManager.getLogger(AsosQA.class);
	
	    public void onFinish(ITestContext Result) {						
	    }		
		
	    public void onStart(ITestContext Result) {						  		
	    }		
		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	    }		
		
	    public void onTestFailure(ITestResult Result) {
	    	tstlog.info("The name of the testcase failed is :"+ Result.getName());
	    }		
	
	    public void onTestSkipped(ITestResult Result) {
	    }		
	
	    public void onTestStart(ITestResult Result) {
	    }		
	
	    public void onTestSuccess(ITestResult Result) {
	    	tstlog.info("The name of the testcase that succussed is :"+ Result.getName());
	    }

}
