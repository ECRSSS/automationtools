package nnglebanov.automationtools.logging;

import nnglebanov.automationtools.utils.LoggingUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by WE on 26.06.2018.
 */
public class GeneralTestListener implements ITestListener{
    /**
     * Invoked each time before a test will be invoked.
     * The <code>ITestResult</code> is only partially filled with the references to
     * class, method, start millis and status.
     *
     * @param result the partially filled <code>ITestResult</code>
     * @see ITestResult#STARTED
     */
    @Override
    public void onTestStart(ITestResult result) {

    }

    /**
     * Invoked each time a test succeeds.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS
     */
    @Override
    public void onTestSuccess(ITestResult result) {

        LoggingUtils.takeScreenshot();

    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#FAILURE
     */
    @Override
    public void onTestFailure(ITestResult result) {

    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SKIP
     */
    @Override
    public void onTestSkipped(ITestResult result) {

    }

    /**
     * Invoked each time a method fails but has been annotated with
     * successPercentage and this failure still keeps it within the
     * success percentage requested.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    /**
     * Invoked after the test class is instantiated and before
     * any configuration method is called.
     *
     * @param context
     */
    @Override
    public void onStart(ITestContext context) {

    }

    /**
     * Invoked after all the tests have run and all their
     * Configuration methods have been called.
     *
     * @param context
     */
    @Override
    public void onFinish(ITestContext context) {

    }
}
