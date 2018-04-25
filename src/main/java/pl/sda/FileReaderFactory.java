package pl.sda;

public class FileReaderFactory {
    public TextFileReader createReader (FactoryType type) {
        if (type.equals("CSV")) return new CSVFileReader();
        if (type.equals("JSON")) return new JSONFileReader();
        return null;
    }
}
