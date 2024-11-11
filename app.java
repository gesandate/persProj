import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class app {
    public static void main (String [] args) {
        
    }
    public static boolean fileExists (String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public static int numLines (String fileName) {
        int count = 0;

        if (fileExists(fileName)) {
            try (Scanner reader = new Scanner (new File(fileName))) {
                while (reader.hasNext()) {
                    count++;
                    reader.nextLine();
                }
            } catch (FileNotFoundException err) {
                System.out.print("File " + fileName + " couldn't be found bro!");
            }
        } else {
            System.out.print("File doesn't exist bro!");
        }
        return count;
    }
}
