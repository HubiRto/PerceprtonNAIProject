package pl.pomoku;

import lombok.Setter;

import java.util.List;

@Setter
public class Perceptron {
//    private static final double LEARNING_RATE = 0.1;
    private final double[] weights;
    private double bias;
    private double learningRate;

    public Perceptron(double learningRate) {
        this.learningRate = learningRate;
        weights = new double[4];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random();
        }
        bias = Math.random();
    }

    public void train(List<Iris> irisList) {
        for (int epoch = 0; epoch < 100; epoch++) {
            for (Iris iris : irisList) {
                double[] inputs = iris.toDoubleInput();
                IrisType target = iris.getType();
                IrisType output = classify(inputs);
                if (!target.equals(output)) {
                    updateWeights(inputs, target);
                }
            }
        }
    }

    IrisType classify(double[] inputs) {
        double sum = bias;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * inputs[i];
        }
        return sum >= 0 ? IrisType.SETOSA : IrisType.VIRGINICA;
    }

    private void updateWeights(double[] inputs, IrisType target) {
        double error = target.equals(IrisType.SETOSA) ? 1 : -1;
        for (int i = 0; i < weights.length; i++) {
            weights[i] += learningRate * error * inputs[i];
        }
        bias += learningRate * error;
    }
}
