package pl.pomoku;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Iris {
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private IrisType type;

    public double[] toDoubleInput() {
        return new double[]{sepalLength, sepalWidth, petalLength, petalWidth};
    }
}
