package grid;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

    public static String searchInExcel(String filePath, String searchValue) {
        String result = null;

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {


            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell cell1 = row.getCell(0);
                if (cell1 != null) {
                    cell1.setCellType(CellType.STRING);
                    String cellValue = cell1.getStringCellValue();
                    if (cellValue.equals(searchValue)) {
                            Cell cell2 = row.getCell(1);
                        if (cell2 != null) {
                            cell2.setCellType(CellType.STRING);
                            result = cell2.getStringCellValue();
                        }
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}