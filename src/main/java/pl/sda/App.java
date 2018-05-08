package pl.sda;

import com.itextpdf.text.DocumentException;
import pl.sda.readers.FileReaderFactory;
import pl.sda.readers.TextFileReader;
import pl.sda.writers.FileWriterFactory;
import pl.sda.writers.TextFileWriter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, DocumentException, URISyntaxException {
        String originFilePath = "C:\\Users\\adamm\\Desktop\\SDA\\J7_FileParsing\\persons.xlsx";
        String destinationPath = "C:\\Users\\adamm\\Desktop\\SDA\\J7_FileParsing\\personsEXCELNEW.xlsx";
        TextFileReader reader = FileReaderFactory.createReader(originFilePath);

        List<Something> values = reader.read(originFilePath);

        TextFileWriter writer = FileWriterFactory.createWriter(destinationPath);
        writer.write(values, destinationPath);


    }
}
