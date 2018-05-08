package pl.sda.readers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.sda.Something;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileReader implements TextFileReader {
    @Override
    public List<Something> read(String path) throws IOException {
        List<Something> result = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        List<String> headers = new ArrayList<>();
        Row headerRow = rowIterator.next();
        Iterator<Cell> headerRowIterator = headerRow.iterator();

        while (headerRowIterator.hasNext()) {
            Cell cell = headerRowIterator.next();
            headers.add(cell.getStringCellValue());
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Something something = new Something();
            int i = 0;
            Iterator<Cell> cellIterator = row.iterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellTypeEnum();

                String value;
                value = CellType.NUMERIC.equals(cellType) ? String.valueOf(cell.getNumericCellValue()) : cell.getStringCellValue();

                    something.setMap(headers.get(i), value);
                    i++;
            }
            result.add(something);
        }

        return result;
    }
}
