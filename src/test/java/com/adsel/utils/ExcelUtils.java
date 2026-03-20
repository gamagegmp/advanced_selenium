package com.adsel.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) {
        Object[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount-1][colCount]; // skip header

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    if(cell.getCellType() == CellType.BOOLEAN){
                        data[i-1][j] = cell.getBooleanCellValue();
                    } else {
                        data[i-1][j] = cell.getStringCellValue();
                    }
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
