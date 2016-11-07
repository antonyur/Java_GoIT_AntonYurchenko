package module11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:/Temp/module11_task.txt";
        Map<String, String> map = new HashMap<>();
        map.put("hi", "bye");
        map.put("hello", "goodbye");

        //Task1
        try {
            String text = IOUtils.replacer(map, filePath);
            System.out.println(text);
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //Task2
        try{
            File file = IOUtils.fileContentReplacer(map, filePath);
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //Task3
        try{
            File file = IOUtils.fileContentMerger(map, filePath);
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //Task4
        try{
            //with try catch
            int count = IOUtils.checkWord("bye", filePath, true);
            System.out.println(String.format("the word buy occurs %d times", count));

            //with try with resources
            count = IOUtils.checkWord("bye", filePath, false);
            System.out.println(String.format("the word buy occurs %d times", count));
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
