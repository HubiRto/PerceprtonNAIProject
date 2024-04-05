package pl.pomoku;

import java.util.List;
import java.util.Scanner;

public class CLI {
    private Perceptron perceptron;
    private Scanner scanner;

    public CLI(Perceptron perceptron, Scanner scanner) {
        this.perceptron = perceptron;
        this.scanner = scanner;
    }

    public void start(List<Iris> testSet) {
        System.out.println("Welcome to Iris Flower Classification System!");
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Classify entire test set");
            System.out.println("2. Enter individual data for classification");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    classifyTestSet(testSet);
                    break;
                case 2:
                    classifyIndividualData(scanner);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void classifyTestSet(List<Iris> testSet) {
        int correctCount = 0;
        for (Iris iris : testSet) {
            IrisType result = perceptron.classify(new double[]{iris.getSepalLength(), iris.getSepalWidth(), iris.getPetalLength(), iris.getPetalWidth()});
            if (result.equals(iris.getType())) {
                correctCount++;
            }
        }
        double accuracy = (double) correctCount / testSet.size() * 100;
        System.out.println("------------------------TEST-------------------------");
        System.out.println("Classification accuracy on test set: " + accuracy + "%");
        System.out.println("-----------------------------------------------------");
    }

    private void classifyIndividualData(Scanner scanner) {
        System.out.println("Enter sepal length:");
        double sepalLength = scanner.nextDouble();
        System.out.println("Enter sepal width:");
        double sepalWidth = scanner.nextDouble();
        System.out.println("Enter petal length:");
        double petalLength = scanner.nextDouble();
        System.out.println("Enter petal width:");
        double petalWidth = scanner.nextDouble();

        IrisType result = perceptron.classify(new double[]{sepalLength, sepalWidth, petalLength, petalWidth});
        System.out.println("Predicted iris type: " + result);
    }
}
