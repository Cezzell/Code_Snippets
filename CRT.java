/**
 *  Simple Calculator of the chinese remainder theorem
 *  Given a mod p and b mod q, the program calculates
 */
import java.util.Scanner;

public class CRT
{
    // Globals to help with the computations
    public static int a = 0;
    public static int b = 0;
    public static int p = 0;
    public static int q = 0;

    public static void main(String[] args)
    {
        // Integer to hold final result
        int result;

        // Prompting the user on usage, may later be without prompt i.e. connected through another class
        System.out.println("This program will calculate the Chinese remainder Thm");
        System.out.println("The CRT will take the form of a % p, b % q");
        System.out.println("WARNING: p and q should be prime and p != q, no answer will exist otherwise");

        Scanner input = new Scanner(System.in);


        // Repeated prompt for inputs

        System.out.println("Please Enter a value: ");
        while (!input.hasNextInt())
        {
            input.next();
        }
        a = input.nextInt();
        input.nextLine();

        System.out.println("Please Enter p value: ");
        while (!input.hasNextInt())
        {
            input.next();
        }
        p = input.nextInt();
        input.nextLine();

        System.out.println("Please Enter b value: ");
        while (!input.hasNextInt())
        {
            input.next();
        }
        b = input.nextInt();
        input.nextLine();

        System.out.println("Please Enter q value: ");
        while (!input.hasNextInt())
        {
            input.next(); // What happens if you use nextLine() instead?
        }
        q = input.nextInt();
        input.nextLine();


        // Calling helper function to calculate the CRT
        result = Calculate();

        // Printing the result of CRT calculation
        System.out.println("x = " + result);

    }

    // Helper function used for the actual calculation
    public static int Calculate()
    {
        // Check for bad inputs
        if(a >= p || b >= q)
        {
            System.out.println("a must be in range [0, p), b must be in range [0, q)");
            System.exit(0);
        }

        // Calculating the two step CRT sum
        int Qproof;
        int Pproof;
        int qinv = 1;
        int pinv = 1;
        int hold;

        // Making Qproof = 0 % q && a % p so Qproof = a * q * (q^-1 % p)

        Qproof = a * q;
        hold = q/p;
        hold = q-(hold*p);
        while(qinv % hold != 0) {
            qinv += p;
        }
        qinv = qinv / hold;
        Qproof = Qproof * qinv;

        // Making Pproof = 0 % p && b % q so Pproof = b * p * (p^-1 % q)

        Pproof = b * p;
        hold = p/q;
        hold = p - (hold*q);
        while( pinv % hold != 0) {
            pinv += q;
        }
        pinv = pinv / hold;
        Pproof = Pproof * pinv;

        // Reduce to lowest term
        int N = p*q;
        hold = (Pproof+Qproof) / N;
        hold = (Pproof+Qproof) - (hold*N);

        return hold;

    }

}