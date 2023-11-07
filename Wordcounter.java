import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wordcounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = getInputText(scanner);
        int wordCount = countWords(inputText);

        System.out.println("Total word count: " + wordCount);

        // To implement more features, you can use the wordCount and inputText as needed.
        // For example, you can ignore common words, display unique words, or show word frequencies.
        // You can also create a GUI for a user-friendly interface.
    }

    // Get text input from the user (either text input or a file)
    private static String getInputText(Scanner scanner) {
        System.out.print("Enter 'T' for text input or 'F' for file input: ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("t")) {
            System.out.print("Enter the text: ");
            return scanner.nextLine();
        } else if (choice.equals("f")) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                return readTextFromFile(filePath);
            } catch (IOException e) {
                System.err.println("Error reading the file. Please check the file path.");
            }
        } else {
            System.err.println("Invalid choice. Please enter 'T' or 'F'.");
        }
        return "";
    }

    // Count words in the input text
    private static int countWords(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        return words.length;
    }

    // Read text from a file
    private static String readTextFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString();
    }
}
