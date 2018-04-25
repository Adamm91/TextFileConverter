//package pl.sda;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CSVFileReader implements TextFileReader {
//    public List<Car> read(String filePath) throws IOException {
//        FileReader fileReader = new FileReader(filePath);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        String[] headers = null;
//        String line;
//        List<Car> cars = new ArrayList<>();
//        int i = 0;
//        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
//            if (i == 0) {
//                headers = line.split(";");
//                i++;
//            } else {
//                Car parsedCar = parseCSVRow(headers, line);
//                cars.add(parsedCar);
//            }
//        }
//        return cars;
//    }
//
//    private Car parseCSVRow(String[] headers, String line) {
//        Car car = new Car();
//        String[] values = line.split(";");
//        for (int i = 0; i < values.length; i++) {
//            setPersonFieldFromCSVFile(car, headers[i], values[i]);
//        }
//        return car;
//    }
//
//    private void setPersonFieldFromCSVFile(Car car, String header, String value) {
//        if ("producent".equals(header)) {
//            car.setProducent(value);
//        }
//        if ("model".equals(header)) {
//            car.setModel(value);
//        }
//        if ("type".equals(header)) {
//            car.setType(value);
//        }
//    }
//
//
//}

package pl.sda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader implements TextFileReader {
    public List<Something> read(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] headers = null;
        String line;
        List<Something> somethings = new ArrayList<>();
        int i = 0;
        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            if (i == 0) {
                headers = line.split(";");
                i++;
            } else {
                Something parsedSomething = parseCSVRow(headers, line);
                somethings.add(parsedSomething);
            }
        }
        return somethings;
    }

    private Something parseCSVRow(String[] headers, String line) {
        Something something = new Something();
        String[] values = line.split(";");
        for (int i = 0; i < values.length; i++) {
            something.setMap(headers[i], values[i]);
        }
        return something;
    }

//    private void setSomethingFieldFromCSVFile(Something something, String header, String value) {
//
//    }


}
