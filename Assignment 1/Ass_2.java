import java.util.Scanner;

public class Ass_2 {
    public static void main (String[] args) {
        int prod;
        Scanner myObj = new Scanner(System.in);

        System.out.print("Input first number: ");
        int num1 = myObj.nextInt();
        System.out.print("Input second number: ");
        int num2 = myObj.nextInt();

        prod = (num1 * num2);
        System.out.println(num1 + " x " + num2 + " = " + prod);
    }
}