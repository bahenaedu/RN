import java.awt.*;
import java.util.Scanner;

public class RationalTest {
    //Variables
    static Scanner s = new Scanner(System.in);
    static String int_1, int_2;
    static int testForExc_1, testForExc_2;
    static Rational r;

    public static void main(String[] args) {

        while(true)
        {
            //Asking the user
            System.out.print("Please enter the numerator: ");
            int_1 = s.nextLine();
            System.out.print("Please enter the denominator: ");
            int_2 = s.nextLine();

            try
            {
                //checking for illegal arguments
                testForExc_1 = Integer.parseInt(int_1);
                testForExc_2 = Integer.parseInt(int_2);

                //Calling Constructor
                r = new Rational(testForExc_1,testForExc_2);

                //Calling all methods
                System.out.println("\n" + r.toString() + "\n");
                int gmc = r.reduce(r.getNumerator(), r.getDenominator()); //gmc of first rational number
                System.out.println("This is the simplest form of the rational number: " + (r.getNumerator()/gmc) + "/" + (r.getDenominator()/gmc));
                System.out.println(r.sum(r.getNumerator(), r.getDenominator()));
                System.out.println(r.multiply(r.getNumerator(), r.getDenominator()));

                break;
            }
            catch (NumberFormatException e){
                System.out.println("Ups. You enter illegal arguments.\n");
            }
        }
    }
}
