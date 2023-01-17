package homeWorks.thotsuliak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class HandlingExceptionsHomeWork {

    public static void main(String[] args) throws IOException {
        handleIndexOutOfBoundsException();
        handleTheFileNotFoundException();
        handleNumberFormatException();
    }

    public static void handleIndexOutOfBoundsException() {
        List<String> fruits = asList("Banana", "Kiwi", "Orange", "Watermelon", "Grape");
        final int fruitsCount = 10;
        try {
            for (int i = 0; i <= fruitsCount; i++) {
                System.out.println(fruits.get(i));
            }
        }
        catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
            System.out.println("There are no fruits. Buy more.");
        }
    }

    public static void handleTheFileNotFoundException() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("testFile.txt"))) {

            String currentLine = reader.readLine();
            System.out.println(currentLine);

        } catch (FileNotFoundException exception) {
            System.out.println("Фаіл не знайдено");
        }
    }

    public static void handleNumberFormatException() {
        int age;
        System.out.print("Введіть свій вік: ");

        try {
            Scanner scanner = new Scanner(System.in);
            age = Integer.parseInt(scanner.next());
            if (age == 0) {
                System.out.println("Неправильно введено вік.");
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Неправильно введено вік.");
        }
        System.out.println("Programme end.");
    }
}