package com.adsel.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReporter(){

        if(extent == null){

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setReportName("Automation Execution Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester","Malithi");
            extent.setSystemInfo("Project","SauceDemo Automation");
            extent.setSystemInfo("Environment","QA");
            extent.setSystemInfo("Browser","Chrome");
            extent.setSystemInfo("OS",System.getProperty("os.name"));

        }

        return extent;
    }
}