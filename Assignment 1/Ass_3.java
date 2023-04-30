import java.util.Scanner;
public class Ass_3 {
    public static void main(String[] args){

        int prod;
        Scanner myObj = new Scanner(System.in);

        System.out.print("Input a number: ");
        int num1 = myObj.nextInt();

        for(int i = 1; i <= 10; i++){
            prod = (num1 * i);
            System.out.println(num1 + " x " + i + " = " + prod);
        }
    }
}
