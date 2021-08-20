package applicationTests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListner implements  ITestListener  {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Finished");

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Started");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Failed");

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Skipped");
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Ttest Started");
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


}
