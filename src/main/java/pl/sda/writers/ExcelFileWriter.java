package pl.sda.writers;

import com.itextpdf.text.DocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.sda.Something;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExcelFileWriter implements TextFileWriter {
    @Override
    public void write(List<Something> somethings, String filePath) throws IOException, DocumentException {

        FileOutputStream outputStream = new FileOutputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet();
        int rowNumber = 0;
        int cellNumber = 0;
        Set<String> headers = somethings.get(0).getMap().keySet();
        Row row = sheet.createRow(rowNumber++);
        Cell cell = null;
        for (String header : headers) {
            cell = row.createCell(cellNumber++);
            cell.setCellValue(header);
        }
        for (Something something : somethings) {
            row = sheet.createRow(rowNumber++);
            Map<String, String> map = something.getMap();
            cellNumber = 0;
            for (String header : headers) {
                cell = row.createCell(cellNumber++);
                cell.setCellValue(map.get(header));
            }
        }

        workbook.write(outputStream);
        outputStream.close();
    }
}
