import java.util.Scanner;
import java.lang.Math;

public class Ass_2_5 {

    public static void main(String[] args){
        //input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int int1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int int2 = input.nextInt();
        System.out.print("Enter first double: ");
        double dbl1 = input.nextDouble();
        System.out.print("Enter second double: ");
        double dbl2 = input.nextDouble();

        //initialization
        int sumOfInt = plusMethod(int1,int2);
        double sumOfDbl = plusMethod(dbl1,dbl2);

        //compute for product
        double product = sumOfInt * sumOfDbl;

        //output
        System.out.println("Result for sum of integers: " + plusMethod(int1,int2));
        System.out.println("Result for sum of doubles: " + plusMethod(dbl1,dbl2));
        System.out.print("Result for product of both sums: " + product);
    }
    static int plusMethod(int x, int y){
        return x + y;
    }
    static double plusMethod(double x, double y){
        return x + y;
    }


}
