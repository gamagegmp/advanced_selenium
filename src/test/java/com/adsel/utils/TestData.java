package com.adsel.utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginData")
    public static Object[][] loginData(){

        return new Object[][]{
                {"standard_user","secret_sauce", true},
                {"locked_out_user","secret_sauce", false},
                {"problem_user","secret_sauce", true}
        };
    }

    @DataProvider(name = "excelLoginData")
    public static Object[][] excelLoginData() {

        String filePath = System.getProperty("user.dir") + "/src/test/resources/data/LoginData.xlsx";
        String sheetName = "Login";

        return ExcelUtils.getExcelData(filePath, sheetName);
    }

}

