import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class app {
    public static void main (String [] args) {
        String [] lines = readFile("testFile");
        for (String line : lines) { //python typa for loop
            System.out.print(line);
        }
    }
    public static boolean fileExists (String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public static int numLines (String fileName) {
        int count = 0;

        if (fileExists(fileName)) {
            try (Scanner reader = new Scanner (new File(fileName))) { //try with resources closes them when finished
                while (reader.hasNext()) {
                    count++;
                    reader.nextLine();
                }
            } catch (FileNotFoundException err) {
                System.out.println("File " + fileName + " couldn't be found bro!");
            }
        } else {
            System.out.println("File doesn't exist bro!");
        }
        return count;
    }

    public static String[] readFile(String fileName) {
        String [] lines = new String [numLines(fileName)];
        try (Scanner reader = new Scanner(new File(fileName))) {
            for (int i = 0; i < lines.length; i++) {
                lines[i] = reader.nextLine();
                reader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found yo!");
        }
        return lines;
    }
}
