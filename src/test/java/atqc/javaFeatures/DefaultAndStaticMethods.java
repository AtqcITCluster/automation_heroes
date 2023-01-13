package atqc.javaFeatures;

import atqc.javaFeatures.support.Drawable;

public class DefaultAndStaticMethods implements Drawable {

    public void draw(int weight) {
        System.out.println("Drawing " + weight + "mm");
    }

    public static void main(String[] args) {
        DefaultAndStaticMethods defaultMethods = new DefaultAndStaticMethods();

        //abstract method
        defaultMethods.draw(2000);



        //default method
        defaultMethods.drawSmiles();

        // static method
        Drawable.drawDottedLine();
    }




}
