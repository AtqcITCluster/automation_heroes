package atqc.javaFeatures;

import atqc.javaFeatures.support.User;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
//        beforeStreamApproach();
//        withStreamApproach();

        //filter
//        getStreamFilterAndCount();
//        getStreamWithMultiFiltering();

        //map
//        getStreamWithMapping();
//        getStreamMappingForCapitalizeNames();
//        getStreamMappingForLisObjectsToListIntegers();
//        getStreamFilterMappingObject();

        // collect to collections
//        getStreamMappingForLisObjectsToListIntegers();
//        getStreamFilterMappingCollectToList();
//        getStreamCollectToCollection();

        // FindAny/FindFirst
//        getStreamFindAny();
//        getStreamFindFirst();

        //matching
//        getStreamAnyMatch();
//        getStreamAllMatch();
//        getStreamNoneMatch();

        // reduce
//        getStreamSumReduce();
//        getStreamSearchReduceInteger();
//        getStreamSearchReduceString();
    }

    public static void beforeStreamApproach(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        for (Integer i : numbers) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void withStreamApproach(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }

    public static void getStreamFilterAndCount(){
        List<String> names = Arrays.asList("John", "Jan", "Tirion", "Marry", "Nikolas");

        long count = names.stream()
                .filter(i -> i.length() > 4)
                .count();
        System.out.println(count);
    }

    public static void getStreamWithMultiFiltering(){
        List<String> names = Arrays.asList("John", "Daenerys", "Tyrion", "", null, "Arya");

        names.stream()
                .filter(Objects::nonNull)
                .filter(name -> !name.isEmpty() && name.contains("a"))
                .forEach(System.out::println);
    }

    public static void getStreamWithMapping(){
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7);

        numbers.stream()
                .map(i -> i * 2)
                .forEach(System.out::println);
    }

    public static void getStreamMappingForCapitalizeNames(){
        List<String> names = Arrays.asList("john", "arya", "sansa");

        names.stream()
                .map(StringUtils::capitalize)
                .forEach(System.out::println);
    }

    public static void getStreamFilterMappingObject(){
        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Alex", 21),
                new User("Chuck", 100));

        users.stream()
                .filter(user -> user.getAge() >30)
                .map(User::getName)
                .forEach(System.out::println);
    }

    public static void getStreamMappingForLisObjectsToListIntegers(){
        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Alex", 21),
                new User("Chuck", 100));

        List<Integer> userAges = users.stream()
                .map(User::getAge)
                .collect(Collectors.toList());

        System.out.println(userAges);
    }

    public static void getStreamFilterMappingCollectToList(){
        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Alex", 21),
                new User("Chuck", 100));

        List<String> filteredUserManes = users.stream()
            .filter(age -> age.getAge() > 30)
            .map(User::getName)
            .collect(Collectors.toList());

        System.out.println(filteredUserManes);
    }

    public static void getStreamCollectToCollection(){
        List<String> names = Arrays.asList("Jaime", "Daenerys", "", "Tyrion", "");

        Queue<String> queue = names.stream()
                .filter(n -> !n.isEmpty())
                .collect(Collectors.toCollection(() -> new LinkedList<>()));

        System.out.println(queue);
    }

    public static void getStreamFindAny(){
        List<String> strings = Arrays.asList("Java is the best", "Java 8", "Java 9", "Jacoco", "BLOB");

        Optional<String> java = strings.stream()
                .filter(s -> s.contains("Java"))
                .findAny();

        System.out.println(java);
    }

    public static void getStreamFindFirst(){
        List<String> strings = Arrays.asList("Jacoco", "Python is the best", "Java 8", "Java 9",  "BLOB");

        Optional<String> java = strings.stream()
                .filter(s -> s.contains("Java"))
                .findFirst();

        System.out.println(java);
    }

    public static void getStreamAnyMatch(){
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7);

        boolean match = numbers.stream()
                .anyMatch(number -> number > 4);

        System.out.println(match);
    }

    public static void getStreamAllMatch(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean match = numbers.stream()
                .allMatch(number -> number > 3);

        System.out.println(match);
    }

    public static void getStreamNoneMatch(){
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(1, 3, 5, 7);

        boolean match = numbers2.stream()
                .noneMatch(number -> number % 2 == 0);

        System.out.println(match);
    }

    public static void getStreamSumReduce(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5);

        Integer sum = numbers.stream()
                .reduce(10, (left, right) -> left + right);

        System.out.println(sum);
    }

    public static void getStreamSearchReduceInteger(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 7);

        Integer min = numbers.stream()
                .reduce(Integer.MAX_VALUE, Integer::min);

        System.out.println(min);
    }

    public static void getStreamSearchReduceString(){
        List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "ddd", "ffff");

        String s = strings.stream()
                .reduce("", (left, right) -> left.length() > right.length() ? left : right);

        System.out.println(s);
    }
}
