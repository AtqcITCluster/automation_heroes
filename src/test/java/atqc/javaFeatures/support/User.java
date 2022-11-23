package atqc.javaFeatures.support;

public class User {

    String name;
    int age;

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return age;
    }

    public User(String userName, int userAge){
        name = userName;
        this.age = userAge;
    }

}
