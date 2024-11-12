import java.io.*;
import java.util.Scanner;

public class JFileChooser {
    public static void main(String[] args) {

        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser("src");
        int result = fileChooser.showOpenDialog(null);

        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                processFile(selectedFile);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }

    /**
     * Method to read the file and print its content along with a summary report.
     */
    private static void processFile(File file) throws IOException {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Contents of the file:");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                lineCount++;

                String[] words = line.trim().split("\\s+");
                wordCount += words.length;

                charCount += line.length();
            }
        }

        System.out.println("\n--- Summary Report ---");
        System.out.println("File Name: " + file.getName());
        System.out.println("Number of lines: " + lineCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of characters: " + charCount);
    }
}

