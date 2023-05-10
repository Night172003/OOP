import java.util.Scanner;
public class Ass_2_4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your multiplicand: ");
        int num1 = input.nextInt();
        System.out.print("Enter your multiplicator: ");
        int num2 = input.nextInt();
        System.out.print("Product: " + multiply(num1,num2));
    }

    public static int multiply(int num1, int num2) {
        if (num2 == 0) {
            return 0;
        } else if (num2 > 0) {
            return num1 + multiply(num1, num2 - 1);
        } else {
            return -multiply(num1, -num2);
        }
    }
}
