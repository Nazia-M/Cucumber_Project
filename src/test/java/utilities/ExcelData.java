package utilities;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelData {

    public static void main(String[] args) throws IOException {

        Logger log = LoggerHelper.getLogger(LoggerHelper.class);

        FileInputStream fis = new FileInputStream("C://Users//Salim//Desktop//SeleniumCucumber//TestData//APITestCases.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();


        for(int i=0;i<rowCount;i++)
        {
            XSSFRow currentRow = sheet.getRow(i);
            for(int j=0;j<colCount;j++)
            {
                String value = currentRow.getCell(j).toString();
                log.info(value+" ");
            }
        }
    }
}
