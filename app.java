import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class app {
    public static void main (String [] args) {
        String [] lines = readFile("testFile.txt");
        for (String line : lines) { //python typa for loop
            System.out.println(line);
        }
    }
    public static boolean fileExists (String fileName) { // checks file existence
        File file = new File(fileName);
        return file.exists();
    }

    public static int numLines (String fileName) { // counts lines in the file
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

    public static String[] readFile(String fileName) { // converts the file into an array; each element is a line
        String [] lines = new String [numLines(fileName)];
        try (Scanner reader = new Scanner(new File(fileName))) {
            for (int i = 0; i < lines.length; i++) {
                lines[i] = reader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found yo!");
        }
        return lines;
    }

    public static boolean accountExists(String accountName) { // checks account existence
        return fileExists(accountName);
    }

    public static boolean isAlphanumeric(String input) { // checks if input is alphanumeric; number, uppercase, lowercase
        boolean num = false;
        boolean upp = false;
        boolean low = false;
        char curr;

        for (int i = 0; i < input.length(); i++) {
            curr = input.charAt(i);
            if (Character.isDigit(curr)) {
                num = true;
            }
            if (Character.isUpperCase(curr)) {
                upp = true;
            }
            if (Character.isLowerCase(curr)) {
                low = true;
            }
        }
        return num && upp && low;
    }
}
