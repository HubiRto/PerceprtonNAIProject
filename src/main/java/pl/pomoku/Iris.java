import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pomoku.IrisType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Iris {
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private IrisType irisType;
}
