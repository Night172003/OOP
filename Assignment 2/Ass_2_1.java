import java.util.Scanner;

public class Ass_2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your sentence: ");
        String input = scanner.nextLine();

        // Ask user for word to be replaced
        System.out.print("What is the word you want to replace: ");
        String wordToReplace = scanner.nextLine();

        //Ask user for word to be placed
        System.out.print("What word do you want for replacement: ");
        String replacementWord = scanner.nextLine();

        //Count number of words in the string
        int wordCount = countWords(input);
        System.out.println("Result:");
        System.out.println("Number of words in the string: " + wordCount);

        // Replace the specified word in the input string and print the result in uppercase
        String replacedString = replaceWord(input, wordToReplace, replacementWord);
        System.out.println("Revised sentence: " + replacedString.toUpperCase());
    }

    public static int countWords(String input) {
        String[] words = input.split("\\s");
        return words.length;
    }

    public static String replaceWord(String input, String wordToReplace, String replacementWord) {
        return input.replaceAll(wordToReplace, replacementWord);
    }
}
