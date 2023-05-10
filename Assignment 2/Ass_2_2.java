import java.util.Scanner;

public class Ass_2_2 {



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("1. A password must have at least eight characters.");
        System.out.println("2. A password consists of only letters and digits.");
        System.out.println("3. A password must contain at least two digits" );
        System.out.print("Input a password: ");
        String password = input.nextLine();

        if (is_Valid_Password(password)) {
            System.out.println("Password is valid: " + password);
        } else {
            System.out.println("Not a valid password: " + password);
        }
    }
    public static boolean is_Valid_Password(String password) {

        if (password.length() < 10) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (is_Numeric(ch))
                numCount++;
            else if (is_Letter(ch))
                charCount++;
            else
                return false;
        }
        return (charCount >= 2 && numCount >= 2);
    }
    public static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }
    public static boolean is_Numeric(char ch) {
        return (ch >= '0' && ch <= '9');
    }

}


