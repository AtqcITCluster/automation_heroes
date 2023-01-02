package homeWorks.olapa;

import java.util.List;

import static java.util.Arrays.asList;

public class Fruits {


    public static void main(String[] args) {
        List<String> fruits = asList("banana", "kiwi", "orange", "watermelon", "grape");
        for (int index = 0; index < fruits.size() + 1; index++) {
            try {
                System.out.println(fruits.get(index));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("There are no fruits.");

            }


        }
    }
}



