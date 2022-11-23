package atqc.javaFeatures;

import atqc.javaFeatures.support.Drawable;
import atqc.javaFeatures.support.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {

        //Without Lambda Expression
//        withoutLambda();

        //With Lambda Expression
//        lambdaExpression();

        // Without Lambda Sorting users
//        withoutLambdaSortingUsers();

        // With Lambda Sorting users
//        lambdaSortingUsers();
    }

    public static void lambdaExpression(){
        Drawable drawable = (int width) -> System.out.println("Drawing line by " + width + " px");
        drawable.draw(44);
    }


    public static void withoutLambda(){
        Drawable drawable = new Drawable() {
            @Override
            public void draw(int width) {
                System.out.println("Drawing line by " + width + " px");
            }
        };
        drawable.draw(44);
    }

    public static void withoutLambdaSortingUsers(){
        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Alex", 21));
        System.out.println("Before sort:");
        for (User user : users) {
            System.out.println(user.getName() + ": " + user.getAge());
        }

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("\nAfter sort:");
        for (User user : users) {
            System.out.println(user.getName() + ": " + user.getAge());
        }

    }

    public static void lambdaSortingUsers(){
        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Alex", 21));

        System.out.println("Before sort:");
        for (User user : users) {
            System.out.println(user.getName() + ": " + user.getAge());
        }

        Collections.sort(users, (o1, o2) -> o1.getAge() - o2.getAge());

        System.out.println("\nAfter sort:");
        for (User user : users) {
            System.out.println(user.getName() + ": " + user.getAge());
        }
    }
}

