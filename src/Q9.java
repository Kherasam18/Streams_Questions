import java.util.*;
import java.util.function.*;

public class Q9 {
    public static Map<String, Double> calculateTotal(List<Double> priceChanges){
        Map<String, Double> initialMap = new HashMap<>();
        initialMap.put("TotalGain", 0.0);
        initialMap.put("TotalLoss", 0.0);

        BiFunction<Map<String, Double>, Double, Map<String, Double>> accumulator =
                (accMap, change) -> {
                    if (change > 0) {
                        accMap.put("TotalGain", accMap.get("TotalGain") + change);
                    } else {
                        accMap.put("TotalLoss", accMap.get("TotalLoss") + Math.abs(change));
                    }
                    return accMap;
                };

        BinaryOperator<Map<String, Double>> combiner = (Map<String, Double> map1, Map<String, Double> map2) -> {
            map1.put("TotalGain", map1.get("TotalGain") + map2.get("TotalGain"));
            map1.put("TotalLoss", map1.get("TotalLoss") + map2.get("TotalLoss"));
            return map1;
        };

        return priceChanges.stream().reduce(initialMap, accumulator, combiner);
    }

    public static void main(String[] args) {
        List<Double> changes = Arrays.asList(5.2, -2.1, 10.0, -3.5, 0.0, 7.8, -1.0);
        Map<String, Double> result = calculateTotal(changes);
        System.out.println(STR."Total Gain: \{result.get("TotalGain")}");
        System.out.println(STR."Total Loss: \{result.get("TotalLoss")}");
    }
}
