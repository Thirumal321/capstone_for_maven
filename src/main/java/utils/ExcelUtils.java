package utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static List<String[]> readExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        List<String[]> data = new ArrayList<>();
        for (Row row : sheet) {
            String[] rowData = new String[row.getLastCellNum()];
            for (int i = 0; i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);
                if (cell == null) {
                    rowData[i] = ""; 
                } else {
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData[i] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                rowData[i] = cell.getDateCellValue().toString();
                            } else {
                                rowData[i] = String.valueOf(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            rowData[i] = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case BLANK:
                            rowData[i] = "";
                            break;
                        default:
                            rowData[i] = ""; 
                    }
                }
            }
            data.add(rowData);
        }
        workbook.close();
        file.close();
        return data;
    }
}