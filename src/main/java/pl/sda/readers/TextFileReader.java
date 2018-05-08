package pl.sda.readers;

import pl.sda.Something;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface TextFileReader {
    List<Something> read(String path) throws IOException;
}
