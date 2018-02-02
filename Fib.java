import java.util.*;

public class Fib
{
	private int firstTerm;
	private int secondTerm;

	public Fib(int first, int second)
	{
		firstTerm = first;
		secondTerm = second;
	}

	public static void main(String[] args)
	{
		Fib test = new Fib(1,1);
		test.Fib10();
	}
	
	public void Fib10()
	{
		int holdTerm;
		for(int i = 0; i < 10; i++)
		{
			System.out.println(firstTerm);
			holdTerm = secondTerm;
			secondTerm += firstTerm;
			firstTerm = holdTerm;
		}
	}
}