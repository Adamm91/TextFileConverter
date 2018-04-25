package pl.sda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileReader implements TextFileReader {

    @Override
    public List<Something> read(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;

        List<Something> somethings = new ArrayList<>();
        while ((line = reader.readLine()) != null && !line.isEmpty() ) {
            if ("{".contains(line)){
                Something something = new Something();
                while (!"}".contains(line)) {
                    line = reader.readLine();
                    String[] keyAndValue = line.split(" : ");
                    something.setMap(keyAndValue[0], keyAndValue[1]);
                }
                somethings.add(something);
            }


        }

        return null;
    }
}
