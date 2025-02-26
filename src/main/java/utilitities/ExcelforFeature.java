package utilitities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelforFeature {

    public static void main(String[] args) throws IOException {

        String excelpath = "C:\\SahanaNUMPYNINJASDET\\workspace\\Team5BugDetectors\\SeleniumHackathon_Feb25\\src\\test\\resources\\testData\\LMScenarios.xlsx";
        String featurefiledirectory = System.getProperty("user.dir") + "\\src\\test\\resources\\featureFiles";

      
        File directory = new File(featurefiledirectory);
        if (!directory.exists()) {
            directory.mkdirs();  
        }

        FileInputStream fis = new FileInputStream(excelpath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        for (int sheetindex = 0; sheetindex < workbook.getNumberOfSheets(); sheetindex++) {
            XSSFSheet sheet = workbook.getSheetAt(sheetindex);
            String sheetname = sheet.getSheetName();
            String featurefilepath = featurefiledirectory + "\\" + sheetname + ".feature";

            FileWriter fileWriter = new FileWriter(featurefilepath);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("Feature: " + sheetname + " functionality\n\n");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header row                                    
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue; // Skip empty rows                                                                   

                // Retrieve cell values
                String scenario = getCellValue(row.getCell(1));
                String given = getCellValue(row.getCell(3));
                String when = getCellValue(row.getCell(4));
                String then = getCellValue(row.getCell(5));

                // Check if all cells are non-empty
                if (scenario.isEmpty() || given.isEmpty() || when.isEmpty() || then.isEmpty()) {
                    continue; // Skip rows with missing fields
                }

                // Write scenario to feature file
                writer.write("    Scenario: " + scenario + "\n");
                writer.write("    Given " + given + "\n");
                writer.write("    When " + when + "\n");
                writer.write("    Then " + then + "\n\n");
            }

            writer.close();
            System.out.println("Feature file generated: " + featurefilepath);
        }

        workbook.close();
        fis.close();
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
