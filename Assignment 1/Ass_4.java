import java.util.Scanner;
public class Ass_4 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Input first number: ");
        int num1 = input.nextInt();
        System.out.print("Input second number: ");
        int num2 = input.nextInt();
        System.out.print("Input third number: ");
        int num3 = input.nextInt();
        System.out.print("Input fourth number: ");
        int num4 = input.nextInt();

        if ((num1 == num2) && (num1 == num3)) {
            if (num1 == num4) {
                System.out.println("Numbers are all equal");
            }
            else System.out.println("Numbers are not equal");
        }
        else
            System.out.println("Numbers are not equal");
    }
}
