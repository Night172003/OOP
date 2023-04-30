import java.util.Scanner;

public class Ass_1 {
    public static void main (String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.print("Input a string in upper case: ");
        String string = myObj.nextLine();
        System.out.println("String in lower case: " + string.toLowerCase());
    }
}
