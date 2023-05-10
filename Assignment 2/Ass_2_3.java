import java.util.Scanner;
import java.lang.Math;

public class Ass_2_3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a float number: ");
        Float num1 = input.nextFloat();
        Float value = Math.abs(num1);

        System.out.print("Absolute value: " + value);

    }
}