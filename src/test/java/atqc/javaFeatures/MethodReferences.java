package atqc.javaFeatures;

import atqc.javaFeatures.support.Drawable;
import atqc.javaFeatures.support.Message;
import atqc.javaFeatures.support.Messageable;
import atqc.javaFeatures.support.StockMessenger;

import static java.util.Arrays.asList;

public class MethodReferences {
    public static void main(String[] args) {

        //Reference to static method: Print message
//        Drawable drawable = MethodReferences::printMessage;
//        drawable.draw(150);

        //Reference to static method: Print message by Thread
//        Thread tread1 = new Thread(MethodReferences::printMessageByThread);
//        tread1.start();

        //Reference to instance method: Print message by Thread
//        Thread tread2 = new Thread(new StockMessenger()::getInvestmentMessage);
//        tread2.start();

        //Reference to constructor
//        Messageable messageable = Message::new;
//        messageable.getMessage("new message text here.");

    }

    public static void printMessage(int width){
        System.out.println("Need to draw line in " + width + " px.");
    }

    public static void printMessageByThread(){
        System.out.println("Height line draw by 1000 px.");
    }


}
