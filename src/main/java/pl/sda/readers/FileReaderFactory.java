package pl.sda.readers;

import pl.sda.readers.CSVFileReader;
import pl.sda.readers.JSONFileReader;
import pl.sda.readers.TextFileReader;
import pl.sda.readers.XMLFileReader;

public class FileReaderFactory {
    public static TextFileReader createReader (String filePath) {
        if (filePath.toLowerCase().endsWith(".csv")) return new CSVFileReader();
        if (filePath.toLowerCase().endsWith(".xml")) return new XMLFileReader();
        if (filePath.toLowerCase().endsWith(".json")) return new JSONFileReader();
        if (filePath.toLowerCase().endsWith(".xlsx")) return new ExcelFileReader();
        return null;
    }
}
