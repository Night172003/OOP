import java.util.Scanner;
public class Ass_5 {

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);

        System.out.print("Input first number: ");
        Double num1 = myObj.nextDouble();
        System.out.print("Input second number: ");
        Double num2 = myObj.nextDouble();

        boolean result = (num1 > 0 && num1 < 1) && (num2 > 0 && num2 < 1);
        System.out.print(result);
    }
}
