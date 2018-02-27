/*
    Author: Michael Moschetti
*/
import java.util.regex.*;
import java.util.*;
import java.io.*;

class RegEx {

    private static Pattern[] patterns = {
        Pattern.compile("define"),
        Pattern.compile("base"),
        Pattern.compile("appname"),
        Pattern.compile("bg"),
        Pattern.compile("fg"),
        Pattern.compile("font"),
        Pattern.compile("fontSize"),
        Pattern.compile("language"),
        Pattern.compile("name"),
        Pattern.compile("uint"),
        Pattern.compile("int"),
        Pattern.compile("regex"),
        Pattern.compile("pi"),
        Pattern.compile("Na"),
        Pattern.compile("G")
    };

    private static String[] matches = {
        "root",
        "..",
        "test",
        "C=ff0000",
        "C=000000",
        "Times",
        "12",
        "en",
        "/[a-z]A-Z][a-zA-Z0-9]*/",
        "/\\d+/",
        "/\\-?d+/",
        "m\"/.*/",
        "3.14159265358979",
        "6.022140857e+23",
        "-6.67408e-11"
    };

    public static void main(String args[]) throws IOException {
        File f = new File("data/hwregex.dat");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
    
        while ((line = br.readLine()) != null) {
            for(int i = 0; i < patterns.length; i++) {
                Matcher m = patterns[i].matcher(line);
                if(m.find()) {
                    System.out.println(matches[i]);
                }
            }
        }
    }
}
