package module11;

import java.io.*;
import java.util.*;
import static java.lang.Math.toIntExact;

public class IOUtils {

    private static String fileToString(String filePath) throws FileNotFoundException, IOException {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }

        return sb.toString();
    }

    private static String fileToStringUsualTryCatch(String filePath) throws FileNotFoundException, IOException {
        StringBuilder sb = new StringBuilder();

        //FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(filePath)));
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        finally {
            br.close();
        }


        return sb.toString();
    }

    private static File stringToFile(String text, String filePath, boolean append) throws FileNotFoundException, IOException {
        File file = new File(filePath);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            String line = null;
            bw.write(text);
            bw.flush();
        }

        return file;
    }

    private static String stringReplacer(String text, Map<String, String> replaceMap) {
        for (Map.Entry<String, String> e : replaceMap.entrySet()) {
            String key = e.getKey();
            String replacement = e.getValue();
            text = text.replaceAll("\\s"+key+"\\s"," "+replacement+" ");
            text = text.replaceAll("\\s "+key+","," "+replacement+",");
            text = text.replaceAll("\\s"+key+";"," "+replacement+";");
            text = text.replaceAll("^"+key+"\\s"," "+replacement+" ");
            text = text.replaceAll("^"+key+","," "+replacement+",");
            text = text.replaceAll("^"+key+";"," "+replacement+";");
        }

        return text;
    }


    public static String replacer(Map<String, String> replaceMap, String filePath) throws FileNotFoundException, IOException {
        String text = fileToString(filePath);
        return stringReplacer(text, replaceMap);
    }

    public static File fileContentReplacer(Map<String, String> replaceMap, String filePath) throws FileNotFoundException, IOException {
        String text = fileToString(filePath);
        text = stringReplacer(text, replaceMap);

        return stringToFile(text, filePath, false);
    }

    public static File fileContentMerger(Map<String, String> replaceMap, String filePath) throws FileNotFoundException, IOException {
        String text = fileToString(filePath);
        text = stringReplacer(text, replaceMap);

        return stringToFile(text, filePath, true);
    }

    public static int checkWord(String word, String filePath, boolean usualTry) throws FileNotFoundException, IOException, ArithmeticException {
        String text = "";
        if (usualTry)
            text = fileToStringUsualTryCatch(filePath);
        else
            fileToString(filePath);
        String[] words = text.split("[\\s,;]+");
        List<String> wordList = Arrays.asList(words);
        Long count =  wordList.stream()
            .filter(w -> w.equals(word))
            .count();

        return toIntExact(count);
    }
}
