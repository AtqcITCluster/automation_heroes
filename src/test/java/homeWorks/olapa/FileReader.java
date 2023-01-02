package homeWorks.olapa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class FileReader {

    private static final String FILEPATH = "C://there_is_no_file.txt";

    public void show() {
        System.out.println("Element shown");
    }

    // uncomment and check compiler warnings
    public void getTextFile() {

    }

    //handled method
    public void getTextFileHandle() {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILEPATH);
        } catch (FileNotFoundException e) {
            System.out.println("Error text is: " + e.getMessage());
        }
    }

    public void getTextFileWithCustomError() throws FileNotFoundException, atqc.handlingExceptions.CustomException {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILEPATH);
        } catch (FileNotFoundException e) {
            throw new atqc.handlingExceptions.CustomException("File isn't created in path " + FILEPATH);
        }
    }

}

