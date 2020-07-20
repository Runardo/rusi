package textmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/***********************************************
 * Classe para comunicação com arquivos texto. *
 * @author Ruan                                *
 * @since  06/07/2020                          *
 ***********************************************/
public class TextManager {
    
    public static int file_put_contents(String path, Object content, boolean append) {
        File file = new File(path);
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter     fileWriter     = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (append) {
                bufferedWriter.append(content + "\n");
            }
            else {
                bufferedWriter.write(content + "\n");
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException exception) {}
        
        return content.toString().length();
    }
    
    public static String file_get_contents(String path) {
        File file = new File(path);
        
        if (file.exists()) {
            try {
                FileReader     fileReader     = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                
                String line, content = "";
                while ((line = bufferedReader.readLine()) != null) {
                    content = content + line + "\n";
                }

                bufferedReader.close();
                fileReader.close();

                return content;
            } catch (IOException exception) {}
        }
        
        return "";
    }
    
    public static ArrayList<String> file_get_contents_as_array(String path) {
        File file = new File(path);
        
        if (file.exists()) {
            try {
                FileReader     fileReader     = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                
                String line;
                ArrayList<String> content = new ArrayList<>();
                while ((line = bufferedReader.readLine()) != null) {
                    content.add(line);
                }

                bufferedReader.close();
                fileReader.close();

                return content;
            } catch (IOException exception) {}
        }
        
        return null;
    }
    
}