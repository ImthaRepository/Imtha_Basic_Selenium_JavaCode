package AdactinProject;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerCodeForAdactin implements ITestListener {
	@Override
	public void onFinish(ITestContext result) {
		System.out.println(result.getName()+"is finished");
		ITestListener.super.onFinish(result);
	}
	@Override
		public void onStart(ITestContext context) {
		System.out.println(context.getName()+"is being started");
		ITestListener.super.onStart(context);
		}
	@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println(result.getName()+"is failed with percentage");
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}
	@Override
		public void onTestFailure(ITestResult result) {
			System.out.println(result.getName()+"is failed");
			ITestListener.super.onTestFailure(result);
		}
	@Override
		public void onTestSkipped(ITestResult result) {
			System.out.println(result.getName()+"is skipped");
			ITestListener.super.onTestSkipped(result);
		}
	@Override
		public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+"test start");	
		ITestListener.super.onTestStart(result);
		}
	@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println(result.getName()+"is successfully completed");
			ITestListener.super.onTestSuccess(result);
		}

}
