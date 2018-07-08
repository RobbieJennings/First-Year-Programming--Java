/* A Sports body has decided that to encourage participants in a competition
 * they will award prizes to those in 1st, 2nd and 3rd place AND will also
 * give prizes to anyone whose place number is prime (e.g. the runners in
 * 5th, 7th, 11th, 13th, ... places will also get prizes).
 * Write a program which outputs the list of which competitors should get 
 * prizes for a user supplied number of competitors.  The output must have
 * the following form:  (assuming that the user has entered 25 as the number
 * of competitors...)
 * Prizes should be given to the competitors who come 1st, 2nd, 3rd, 5th, 7th, 11th, 13th, 17th, 19th, 23rd
 * Your solution must check if numbers are prime and must use at least one
 * switch statement.
 */

import java.util.Scanner;

public class PrimePrizes
{

	public static void main ( String args[] )
	{
		
		String output = "Prizes should be given to the competitors who come: 1";
		System.out.print( "Enter the number of participants: ");
		Scanner inputScanner = new Scanner( System.in );
		int numberOfParticipants = inputScanner.nextInt();
		
		for( int count = 2; count <= numberOfParticipants; count++ )
		{
			boolean isPrime = true;
			for( int divisor = 2; divisor < count; divisor++ )
			{
				if( count % divisor == 0)
				{
					isPrime = false;
				}
			}
			if( isPrime )
			{
				output = output + ", " + count;
				if( ( count % 100 ) / 10 == 1 )
				{
					output = output + "th";
				}
				else
				{
					switch( count % 10)
					{
					case 1:
						output = output + "st";
						break;
					case 2:
						output = output + "nd";
						break;
					case 3:
						output = output + "rd";
						break;
					default:
						output = output + "th";
						break;
					}
				}
			}
		}
		
		System.out.println( output );
		
		inputScanner.close();
		
	}
	
}