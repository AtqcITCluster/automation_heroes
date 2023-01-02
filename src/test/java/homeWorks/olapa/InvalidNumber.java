package homeWorks.olapa;

public class InvalidNumber {

    public static void main(String[] args) {
        String str = "25T";
        try {
            int number = Integer.parseInt(str);
            System.out.println(number);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("Program completion");
        }
    }
}

