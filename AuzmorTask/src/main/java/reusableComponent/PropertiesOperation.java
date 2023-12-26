package reusableComponent;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperation  {
    static String username,password;
    static   String adress,city,state,postal,email,cardnumber,expiry,cvv;

    static Properties prop =new Properties();
   static File src= new File(System.getProperty("user.dir")+"/src/test/resources/TestData (2).xlsx");

    static FileInputStream read_Test;

    static {
        try {
            read_Test = new FileInputStream(src);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  static String getPropertyy(String key) throws Exception {
        String filePath= System.getProperty("user.dir")+"/src/test/resources/config.properties";
        FileInputStream fis=new FileInputStream(filePath);
        prop.load(fis);

        String value =prop.get(key).toString();
        if(StringUtils.isEmpty(value))
        {
            throw new Exception("value is not specified for key: "+key+" in propertiesFile");
        }
        return  value;
    }
    public static String[] ReadTestDataAdmin() throws IOException {
        XSSFWorkbook xfs  = new XSSFWorkbook(read_Test);
        XSSFSheet sheet= xfs.getSheetAt(0);
       username=sheet.getRow(1).getCell(0).getStringCellValue();
        password=sheet.getRow(1).getCell(1).getStringCellValue();
        return new String[]{ username, password };
    }
    public static String[] ReadTestDataLearner() throws IOException {
        XSSFWorkbook xfs  = new XSSFWorkbook(read_Test);
        XSSFSheet sheet= xfs.getSheetAt(0);
        username=sheet.getRow(2).getCell(0).getStringCellValue();
        password=sheet.getRow(1).getCell(1).getStringCellValue();
        return new String[]{ username, password };
    }
    public static String[] PaymentDetails() throws IOException {
        File src= new File(System.getProperty("user.dir")+"/src/test/resources/TestData/TestPayment.xlsx");
        FileInputStream read_Test ;
        read_Test = new FileInputStream(src);
        XSSFWorkbook xfs  = new XSSFWorkbook(read_Test);
        XSSFSheet sheet= xfs.getSheetAt(0);
        adress=sheet.getRow(0).getCell(0).getStringCellValue();
        city=sheet.getRow(0).getCell(1).getStringCellValue();
        state=sheet.getRow(0).getCell(2).getStringCellValue();
        postal=sheet.getRow(0).getCell(3).getStringCellValue();
        email=sheet.getRow(0).getCell(4).getStringCellValue();
        cardnumber=sheet.getRow(0).getCell(5).getStringCellValue();
        expiry=sheet.getRow(0).getCell(6).getStringCellValue();
        cvv=sheet.getRow(0).getCell(7).getStringCellValue();
        return new String[]{ adress,city,state,postal,email,cardnumber,expiry,cvv};
    }


}
