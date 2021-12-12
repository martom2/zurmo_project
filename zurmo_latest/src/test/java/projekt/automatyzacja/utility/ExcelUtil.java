package projekt.automatyzacja.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	//Main Directory of the project
	private String currentDir = System.getProperty("user.dir");

	//Location of Test data excel file
    private String testDataExcelPath;
 
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFCell cell;
    private XSSFRow row;
	
	
    // Constructor has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
    public ExcelUtil(String testDataExcelFileName, String sheetName) {
     
            testDataExcelPath = currentDir + "\\src\\test\\java\\projekt\\automatyzacja\\testdata\\";
        
        try {
            // Open the Excel file
            FileInputStream excelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
            this.workbook = new XSSFWorkbook(excelFile);
            this.sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    
    //This method reads the test data from the Excel cell.
    //We are passing row number and column number as parameters.
    public String getCellData(int RowNum, int ColNum) {
        try {
            cell = sheet.getRow(RowNum).getCell(ColNum);
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
    
    //This method gets excel file, row and column number and set a value to the that cell.
    public void setCellData(String value, int RowNum, int ColNum, String testDataExcelFileName) {
        try {
            row = sheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
	
    public int getNumberOfRows() {
    	return sheet.getPhysicalNumberOfRows();
    }
    
    public int getNumberOfCellsInARow(int rowNumber) {
    	row = sheet.getRow(rowNumber);
    	return row.getLastCellNum();
    }
}
