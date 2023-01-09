package homeWorks.ttykhovetska;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class HandlingExceptionsHomeWork {

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<String>(asList("banana", "kiwi", "orange", "watermelon", "grape"));
        getListElements(fruits);
    }


    public static void getListElements(List<String> inputList){
        try {
            for (int i = 0; i <= inputList.size(); i++) {
                System.out.println(inputList.get(i));
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("There are no fruits. Buy more.");
        }

    }

    public static void getTextFile(){
        try {
            FileInputStream fr= new FileInputStream("~/no_such_file.txt");
        }
        catch (FileNotFoundException e){
            System.out.println("There is no file with such path");
        }

    }

    public static void numberFormatException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any valid number");
        try {
            Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {

        }
        finally{
            System.out.println("Programme end");
        }

    }
/*
01. You have a list: List<String> fruits = asList("banana", "kiwi", "orange", "watermelon", "grape");
Try to get and handle IndexOutOfBoundsException exception. Use 'for' loop.
Print each name of fruit and the last message "There are no fruits. Buy more.".

02.Try to get some not present txt file and handled the exception, that file no found.
Print own error text instead Java Exception.

03. Try to get NumberFormatException and handle it. In last message in console should be text "Programme end" all the time.
 */


}