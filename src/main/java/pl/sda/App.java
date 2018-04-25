package pl.sda;

import java.io.IOException;
import java.util.List;

public class App {
//    public static void main( String[] args ){
//        CSVFileReader reader = new CSVFileReader();
//        try {
//            List<Something> somethingList = reader.read("C:\\Users\\adamm\\Desktop\\SDA\\costam.csv");
//                somethingList.forEach(e -> System.out.println(e.toString()));
//
//        } catch (IOException e) {
//            System.out.println("WYSTAPIL BLAD");
//        }
//    }

    public static void main(String[] args) {
        CSVFileWriter csvFileWriter = new CSVFileWriter();
        csvFileWriter.write("write.txt");
    }
}
