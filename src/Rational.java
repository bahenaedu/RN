import java.util.Random;

public class Rational {
    private int numerator;
    private int denominator;
    private static Random rand = new Random();

    /**
     * The default constructor automatically set the numerator and denominator to 1
     */
    public Rational()
    {
        numerator = 1;
        denominator = 1;
    }

    /**
     * The constructor ask for two parameters. User choose the numerator and denominator
     * and check if they are valid
     * @param num  numerator has to be greater or equal to 0
     * @param denom denominator has to be greater than 0
     */
    public Rational (int num, int denom)
    {
        // the constructor is making sure that either the numerator or denominator fits the conditions
        if(num >= 0 && denom > 0)
        {
            numerator = num;
            denominator = denom;
        }
        else if (num < 0 && denom > 0)
        {
            System.out.println("\nSorry. The numerator cant be " + num +". The program assigned 1 to the numerator.");
            numerator = 1;
            denominator = denom;
        }
        else if (num >= 0 && denom <= 0)
        {
            System.out.println("\nSorry. The denominator cant be "+ denom + ". The program assigned 1 to the denominator.");
            numerator = num;
            denominator = 1;
        }
        else{
            System.out.println("\nSorry. The options that you enter are not valid. The program assigned 1 to " +
                    "the numerator and the denominator. ");
            numerator = 1;
            denominator = 1;
        }
    }

    /**
     * The getter returns the value of numerator
     * @return int
     */
    public int getNumerator(){ return numerator; }

    /**
     * The getter return the value of denominator
     * @return int
     */
    public int getDenominator() { return  denominator;}

    /**
     * The method return a string of the irrational number format n/d
     * @return String
     */
    public String toString()
    {
        return "This is your rational number: " + numerator + "/" + denominator + ". Format n/d.";
    }

    /**
     * The method private is a retrieve function to find the GMC
     * @param a numerator
     * @param b denominator
     * @return GMC value
     */
    private int gmc (int a, int b) //simplifying the rational number.
    {
        return b == 0 ? a : gmc(b, a % b);
    }

    /**
     * The method is called in RationalTest class to get the GMC
     * @param a numerator
     * @param b denominator
     * @return value of GMC
     */
    public int reduce (int a, int b){ // calling from the main
        int  gmc = gmc(a,b);

        return gmc;
    }

    /**
     * The public method is called in RationalTest. it creates a random irrational number
     * and makes the sum of user's choice and the random irrational number, and then
     * the result is reduce by using the gmc method and return it.
     * @param firstNumerator users's numerator
     * @param firstDenominator user's denominator
     * @return String
     */
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

    /**
     * The public method is called in RationalTest. it creates one random rational number
     * and multiply with the uses's choice of rational number and
     * call the gmc to to reduce the irrational as result of the multiplication.
     * @param firstNum user's numerator
     * @param firstDeno user's denominator
     * @return String
     */
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
