package atqc.javaFeatures.support;

@FunctionalInterface
public interface Drawable {

    //abstract method
    void draw(int wight);

    //default method
    default void drawSmiles(){
        System.out.println("☺ ☻ ☺ ☻ ☺ ☻ ☺ ☻");
    }

    // static method
    static void drawDottedLine(){
        System.out.println(".............................................................");
    }

}
