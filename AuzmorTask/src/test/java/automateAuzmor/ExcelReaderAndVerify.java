package automateAuzmor;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReaderAndVerify {

    private FileInputStream fis;
    private FileOutputStream fot;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellStyle;
    private  Color mycolor;
    private  String execelFilePath;
    private Map<String,Integer> columns= new HashMap<>();

    public  void  setExcelFile(String ExcelPath, String SheetName) throws Exception{
        try {
            File f = new File(ExcelPath);
            wb = WorkbookFactory.create(f);
            sh = wb.getSheet(SheetName);
            this.execelFilePath = ExcelPath;
            sh.getRow(0).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public  String getCellData(int rownum,int colnum) throws Exception {
        try {
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()) {
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        CellData = String.valueOf(cell.getDateCellValue());
                    } else {
                        CellData = String.valueOf((long) cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }
    public String getCellData(String columnName, int rownum) throws Exception {
        //System.out.println("Column Name: " + columnName);
        return getCellData(rownum, columns.get(columnName));

    }
    public void readAndPrintCompletedEmails() throws Exception {
        int rowCount = sh.getLastRowNum();
        int emailColumnIndex = columns.get("Email/Username");
        int statusColumnIndex = columns.get("Progress Status");
        for (int i = 1; i <= rowCount; i++) {
            String status = getCellData(i, statusColumnIndex);
            if (status.equalsIgnoreCase("Completed")) {
                String email = getCellData(i, emailColumnIndex);
                System.out.println("Email/Username: " + email);
            }
        }
    }
    public  static void main(String []args) throws Exception {
         ExcelReaderAndVerify excelReaderAndVerify=new ExcelReaderAndVerify();
         excelReaderAndVerify.setExcelFile("./src/test/resources/Report.xlsx","Learner info");
        excelReaderAndVerify.readAndPrintCompletedEmails();

//        System.out.println(excelReaderAndVerify.getCellData("Email/Username",1));
//        System.out.println(excelReaderAndVerify.getCellData("Status",1));


    }


}
