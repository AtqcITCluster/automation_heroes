package atqc.javaFeatures;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class NashornJavaScriptEngine {
    public static void main(String[] args) {
        final String FILE_PATH = "src/test/java/atqc/javaFeatures/support/hello.js";
        File file = new File(FILE_PATH);

        // Creating script engine
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("Nashorn");

        // Reading js file
//        try {
//            engine.eval(new FileReader(file.getAbsolutePath()));
//        } catch (ScriptException | FileNotFoundException e) {
//            e.printStackTrace();
//        }

        // calling a functions
//        Invocable invocable = (Invocable)engine;
//        try {
//            engine.eval(new FileReader(file.getAbsolutePath()));
//            invocable.invokeFunction("functionDemo1");
////            invocable.invokeFunction("functionDemo2", "works good!");
//        } catch (ScriptException | NoSuchMethodException | FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }



}
