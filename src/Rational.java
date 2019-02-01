import java.util.Random;

public class Rational {
    private int numerator;
    private int denominator;
    private static Random rand = new Random();

    public Rational()
    {
        numerator = 1;
        denominator = 1;
    }

    public Rational (int x, int y)
    {
        // the constructor is making sure that either the numerator or denominator fits the conditions
        if(x >= 0 && y > 0)
        {
            numerator = x;
            denominator = y;
        }
        else if (x < 0 && y > 0)
        {
            System.out.println("\nSorry. The numerator cant be " + x +". The program assigned 1 to the numerator.");
            numerator = 1;
            denominator = y;
        }
        else if (x >= 0 && y <= 0)
        {
            System.out.println("\nSorry. The denominator cant be "+ y + ". The program assigned 1 to the denominator.");
            numerator = x;
            denominator = 1;
        }
        else{
            System.out.println("\nSorry. The options that you enter are not valid. The program assigned 1 to " +
                    "the numerator and the denominator. ");
            numerator = 1;
            denominator = 1;
        }
    }

    public int getNumerator(){ return numerator; }
    public int getDenominator() { return  denominator;}

    public String toString()
    {
        return "This is your rational number: " + numerator + "/" + denominator + ". Format n/d.";
    }

    private int gmc (int a, int b) //simplifying the rational number.
    {
        return b == 0 ? a : gmc(b, a % b);
    }

    public int reduce (int a, int b){ // calling from the main
        int  gmc = gmc(a,b);

        return gmc;
    }

    public String sum (int firstNumerator, int firstDenominator) // sum of two rational numbers
    {
        int randomNum = rand.nextInt(101);
        int randomDeno = rand.nextInt(99) + 1; //making sure that denominator is greater than 0

        System.out.println("\nRandom rational number: " + randomNum + "/" + randomDeno);

        int greatDeno = randomDeno * firstDenominator;
        int divFirst = greatDeno / firstDenominator;
        int divSecond = greatDeno / randomDeno;
        int holderDeno = greatDeno;
        int holderNum = (firstNumerator * divFirst) + (randomNum * divSecond);

        int holderGmc = gmc(holderNum, holderDeno);

        return "\nThe sum of " + firstNumerator + "/" + firstDenominator + " plus " +
                 randomNum + "/" + randomDeno + " is " +
                (holderNum/holderGmc) + "/" + (holderDeno/holderGmc + " in the simplest form.");
    }

    public String multiply (int firstNum, int firstDeno) //multiplication of two rational numbers
    {
        int randomNum = rand.nextInt(101);
        int randomDeno = rand.nextInt(99) + 1; //making sure that denominator is greater than 0

        System.out.println("\nRandom rational number: " + randomNum + "/" + randomDeno);

        int holderNum = randomNum * firstNum;
        int holderDeno = randomDeno * firstDeno;
        int holderGmc = gmc(holderNum, holderDeno);

        return "\nThe multiplication of " + firstNum + "/" + firstDeno + " plus " +
                randomNum + "/" + randomDeno + " is " +
                (holderNum/holderGmc) + "/" + (holderDeno/holderGmc + " in the simplest form.");
    }


}
