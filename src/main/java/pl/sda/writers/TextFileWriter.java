package pl.sda.writers;

import com.itextpdf.text.DocumentException;
import pl.sda.Something;

import java.io.IOException;
import java.util.List;

public interface TextFileWriter {
    public void write(List<Something> somethings, String filePath) throws IOException, DocumentException;
}
