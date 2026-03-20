package com.adsel.utils;

import com.adsel.base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReporter();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result){

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result){

        test.fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(BaseTest.driver,result.getName());

        try{

            test.addScreenCaptureFromPath(screenshotPath);

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context){

        extent.flush();
    }
}