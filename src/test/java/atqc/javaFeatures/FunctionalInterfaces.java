package atqc.javaFeatures;

import atqc.javaFeatures.support.Drawable;
import atqc.javaFeatures.support.User;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    public static void main(String[] args) {

//        Drawable drawable = getFunctionalInterfaceStableApproach();
//        drawable.draw(15);

//        getConsumerInterface();

//        getPredicateInterface();

//        getFunctionInterface();

//        getSupplierInterface();
    }


    // Stable Approach
    public static Drawable getFunctionalInterfaceStableApproach(){
        Drawable drawable = width -> System.out.println("Drawing line by " + width + " px");
        return drawable;
    }

    // Consumer Interface
    public static void getConsumerInterface(){
        Consumer<Integer> printer = x-> System.out.println(x + "$");
        printer.accept(600);
    }

    // Predicate Interface
    public static void getPredicateInterface(){
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false
    }

    // Function Interface
    public static void getFunctionInterface(){
        Function<Integer, String> convert = x-> x + "$";
        System.out.println(convert.apply(5));
        System.out.println(convert.apply(5) instanceof String);
    }

    // Supplier interface
    public static void getSupplierInterface(){
        Supplier<User> userFactory = () -> {

            Scanner in = new Scanner(System.in);
            System.out.println("Enter name: ");
            String name = in.nextLine();
            return new User(name, 50);
        };

        User userFirstName = userFactory.get();
        User userLastName = userFactory.get();

        System.out.println("First name: " + userFirstName.getName());
        System.out.println("Last name: " + userLastName.getName());
    }



}
