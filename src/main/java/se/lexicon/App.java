package se.lexicon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /*
        NOTE! With BufferedWriter BufferedReader = chars/Strings (NOT reading with Bytes)

        Task
        1.Writing to a file!
        2.Reading form the created file!
        */

        List<String> content = Arrays.asList(
                "Hello", "World!"
        );

        //Creating a File object with that path of file location.
        File file = new File("text/message.txt");


        // WRITING TO THE FILE
        //write(file, content);


        //READING FILE LINE BY LINE
        for (String message : read(file)) {
            System.out.println(message);
        }

    }

    private static List<String> write(File file, List<String> content) {

        //Try with resources - Opening and closing connection for file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            //Writing String by string with new line between.
            for (String messageToWrite : content) {
                writer.write(messageToWrite);
                writer.newLine();
            }
            writer.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return content;
    }


    /**
     * Reading a file line by line
     *
     * @param file source to read from.
     * @return found String message line by line.
     */
    private static List<String> read(File file) {
        List<String> message = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                message.add(line);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return message;
    }

/*  read method with try-catch-finally without resources.

    private static List<String> read(File file) {
        List<String> message = new ArrayList<>();

        FileReader fileReader = null;
        BufferedReader reader = null;

        try {

            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                message.add(line);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return message;
    }
*/


}
