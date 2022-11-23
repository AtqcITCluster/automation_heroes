package atqc.javaFeatures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachMethod {
    public static void main(String[] args) {

        // forEach() and List
//        getForEachAndListExample();

        //forEach() and Map
//        getForEachAndMapExample();

        // forEach() with method reference
//        getForEachWithLambdaAndMethodReferenceExample();

        // forEach() with logic condition
//        getForEachWithCondition();
    }


    public static void getForEachAndListExample(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // before Java8
        for (Integer number : numbers) {
            System.out.println(number);
        }

        System.out.println("-----------");

        //in Java 8
        numbers.forEach(System.out::println);
    }

    public static void getForEachAndMapExample(){
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(1, 100);
        numbers.put(2, 200);
        numbers.put(3, 300);

        // before Java8
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        System.out.println("-----------");

        //in Java 8
        numbers.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }

    public static void getForEachWithLambdaAndMethodReferenceExample(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // with Lambda
        numbers.forEach(number -> System.out.println(number));

        System.out.println("-----------");

        // with method reference
        numbers.forEach(System.out::println);
    }

    public static void getForEachWithCondition() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // before Java8
        for (Integer number : numbers) {
            if (number > 2) {
                System.out.println(number);
            }
        }

        System.out.println("-----------");

        // in Java8
        numbers.forEach(number -> {
            if (number > 2) {
                System.out.println(number);
            }
        });
    }

}
