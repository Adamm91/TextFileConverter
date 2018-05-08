package pl.sda.writers;

import pl.sda.writers.*;

public class FileWriterFactory {
    public static TextFileWriter createWriter (String path) {
        if (path.toLowerCase().endsWith(".csv")) return new CSVFileWriter();
        if (path.toLowerCase().endsWith(".json")) return new JSONFileWriter();
        if (path.toLowerCase().endsWith(".xml")) return new XMLFileWriter();
        if (path.toLowerCase().endsWith(".pdf")) return new PDFFileWriter();
        if (path.toLowerCase().endsWith(".xlsx")) return new ExcelFileWriter();
        return null;
    }
}
