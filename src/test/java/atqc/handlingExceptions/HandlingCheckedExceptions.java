package atqc.handlingExceptions;

import java.io.FileNotFoundException;

public class HandlingCheckedExceptions {
    public static void main(String[] args) throws FileNotFoundException, CustomException {

        FileReader fileReader = new FileReader();

//        fileReader.getTextFile();
//        fileReader.getTextFileHandle();
//        fileReader.getTextFileWithCustomError();

        System.out.println("next method work");
    }

}
