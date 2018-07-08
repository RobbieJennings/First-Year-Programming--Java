/* Write a program to determine simulate the toss of a coin.  For 10,000 tosses
 * determine how many heads and how many tails are tossed.  Also indicate what the
 * last toss was (tails or heads).
 */

import java.util.Random;

public class TossCoin

{
	
	public static final int TOTAL_TOSSES = 10000;
	public static final int HEADS = 1;
	public static final int TAILS = 0;
	
	public static void main( String[] args )

	{
		int numberOfHeads = 0;
		int numberOfTails = 0;
		boolean heads = false;
		
		for ( int numberOfTosses = 0; numberOfTosses < TOTAL_TOSSES; numberOfTosses++ )
		{
			Random  generator = new Random();
			heads = ( generator.nextInt( 2 ) == HEADS );
			if ( heads )
			{
				numberOfHeads++;
			}
			else
			{
				numberOfTails++;
			}
		}
		
		if( heads )
		{
			System.out.println( "last: Heads" );
		}
		else
		{
			System.out.println( "Last: Tails" );
		}
		
		System.out.println( "Heads: " + numberOfHeads );
		System.out.println( "Tails: " + ( numberOfTails ) );
		
	}
	
}