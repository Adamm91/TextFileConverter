package pl.sda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface TextFileReader {
    List<Something> read(String path) throws IOException;
}
