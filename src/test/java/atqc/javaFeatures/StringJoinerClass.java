package atqc.javaFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;


public class StringJoinerClass {
    public static void main(String[] args) {
//        getStringJoinerExample();
//        getStringJoinExample();
//        getCollectorsJoiningExample();
    }

    public static void getStringJoinerExample(){
        StringJoiner joiner1 = new StringJoiner(".");
        joiner1.setEmptyValue("account");

        StringJoiner joiner2 = new StringJoiner(". ", "(", ")");
        joiner2.add("user1");
        joiner2.add("user2");
        joiner2.add("user3");
        joiner2.add("user4");

        System.out.println(joiner1);

        // joiner set value()
        System.out.println(joiner1.setEmptyValue("user"));

        //joiner length
        System.out.println(joiner1.length());

        //toString
        System.out.println(joiner2.toString());
    }

    public static void getStringJoinExample(){
        String numbers = String.join("-", "1", "0", "1", "0");
        System.out.println(numbers);

        List<String> databases = asList("OracleDB", "Mongo", "PostgreSQL", "MySQL");
        String string = String.join(", ", databases);
        System.out.println(string);
    }

    public static void getCollectorsJoiningExample(){
        List<String> list = asList("Angular", "Bootstrap", "NodeJS", "MongoDB");

        String collect = list.stream()
                .collect(Collectors.joining("; ", "[", "]"));

//        System.out.println(collect);
        System.out.println(asList(collect, collect, collect));
    }
}
