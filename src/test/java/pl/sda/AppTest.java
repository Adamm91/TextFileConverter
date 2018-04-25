package pl.sda;


import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class AppTest {

    private static final String CSV_FILE_NAME = "costam.csv";

    @Test
    public void CSVFileReader() throws IOException {
        // given
        CSVFileReader reader = new CSVFileReader();
        //when
        String expected = "Something{map={lastName=marcinko, name=adam, age=20}}";
        String path = getClass().getClassLoader().getResource(CSV_FILE_NAME).getPath();
        //then
        List<Something> read = reader.read(path);
        Assert.assertEquals(expected, read.get(0).toString());
    }
}
