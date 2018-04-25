package pl.sda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFileWriter implements TextFileWriter {
    @Override
    public void write(String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("HELLO");

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
