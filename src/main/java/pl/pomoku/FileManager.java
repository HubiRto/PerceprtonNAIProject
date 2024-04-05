package pl.pomoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public List<Iris> readIrisData(String filename) {
        List<Iris> irisList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Main.class.getClassLoader().getResourceAsStream(filename)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double sepalLength = Double.parseDouble(values[0]);
                double sepalWidth = Double.parseDouble(values[1]);
                double petalLength = Double.parseDouble(values[2]);
                double petalWidth = Double.parseDouble(values[3]);
                IrisType type = IrisType.valueOf(values[4].toUpperCase().substring(5));
                Iris iris = new Iris(sepalLength, sepalWidth, petalLength, petalWidth, type);
                irisList.add(iris);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return irisList;
    }
}
