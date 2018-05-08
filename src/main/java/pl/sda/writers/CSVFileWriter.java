package pl.sda.writers;


import pl.sda.Something;
import pl.sda.writers.TextFileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class CSVFileWriter implements TextFileWriter {

    @Override
    public void write(List<Something> somethings, String filePath) throws IOException {

        FileWriter writer = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        Set<String> headers = somethings.get(0).getMap().keySet();
        StringBuilder head = new StringBuilder();
        for (String header : headers) {
            head.append(header).append(";");
        }
        bufferedWriter.write(head.deleteCharAt(head.length() - 1).toString() + "\n");

        StringBuilder body = new StringBuilder();
        for (Something something : somethings) {
            for (String header : headers) {
                body.append(something.getMap().get(header)).append(";");
            }
            body.deleteCharAt(body.length() - 1).append("\n");
        }
        bufferedWriter.write(body.toString());
        bufferedWriter.close();
        writer.close();
    }
}
