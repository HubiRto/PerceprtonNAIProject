package pl.pomoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        List<Iris> irisList = fileManager.readIrisData("iris.txt");

        System.out.println("Learning rate (0-1): ");
        Scanner sc = new Scanner(System.in);
        double lr = Double.parseDouble(sc.nextLine());


        Perceptron perceptron = new Perceptron(lr);
        perceptron.train(getRandomData(irisList, 35));

        CLI cli = new CLI(perceptron, sc);
        cli.start(getRandomData(irisList, 15));
    }

    private static List<Iris> getRandomData(List<Iris> data, int number) {
        Random random = new Random();
        List<Iris> result = new ArrayList<>();
        int i = 0;
        while (i < number) {
            int n = random.nextInt(data.size());
            Iris rand = data.get(n);
            if (!result.contains(rand)) {
                result.add(rand);
                i++;
            }
        }
        return result;
    }
}