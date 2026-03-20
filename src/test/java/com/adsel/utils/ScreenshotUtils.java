package com.adsel.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName){

        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String path = System.getProperty("user.dir")
                + "/test-output/screenshots/"
                + testName + "_" + timeStamp + ".png";

        try{

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File destination = new File(path);

            destination.getParentFile().mkdirs();

            FileHandler.copy(src, destination);

        }catch(IOException e){
            e.printStackTrace();
        }

        return path;
    }
}