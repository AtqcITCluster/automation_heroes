package atqc.handlingExceptions;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class ExceptionsBase {

    public FileReader fileReader;

    // method with Exception
    public void exchange(int uahValue, int dollarCourse){
        System.out.println("User get " + uahValue / dollarCourse + "$");
    }

    //handled method
    public void exchangeHandled(int uahValue, int dollarCourse){
        try{
            System.out.println("User get " + uahValue / dollarCourse + "$");
        }catch(ArithmeticException e){
            System.out.println("Dollar course not found.");
        }
    }


    // method with Exception
    public void getNullObject(){
        fileReader.show();
    }

    //handled method
    public void getNullObjectHandled(){
        try {
            fileReader.show();
        }catch(NullPointerException e){
            System.out.println("Method return null");
        }
    }

    // method with Exception
    public void getListElement(int indexOfElement){
        ArrayList<Integer> arrayIntegers =new ArrayList<Integer>(asList(10,20,30));
        System.out.println("Value is: " + arrayIntegers.get(indexOfElement));
    }

    //handled method
    public void getListElementHandled(int indexOfElement){
        ArrayList<Integer> arrayIntegers =new ArrayList<Integer>(asList(10,20,30));

        try{
            System.out.println("Value is: " + arrayIntegers.get(indexOfElement));
        } catch(IndexOutOfBoundsException e){
            System.out.println("There is no element in list with index " + indexOfElement);
        }finally {
            System.out.println("Works every time");
        }
    }

}
