import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {
    public static boolean readFile(String filename, ArrayList<String> words){

        if(filename == null || words == null){
            System.out.println("filename is null or words is null");
            return false;
        }

        Scanner scanner;

        try{
            File file = new File(filename);
            if(file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF8");
                scanner.useLocale(Locale.ENGLISH);
            }
            else
                return false;
        } catch (IOException e) {
            System.out.println("cannot open" + filename);
        }

        return false;
    }
}
