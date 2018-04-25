package pl.sda;

public class FileWriterFactory {
    public TextFileWriter createWriter (FactoryType type) {
        if (type.equals("CSV")) return new CSVFileWriter();
        if (type.equals("JSON")) return new JSONFileWriter();
        return null;
    }
}
