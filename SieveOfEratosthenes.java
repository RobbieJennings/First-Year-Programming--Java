import java.util.Scanner;

public class SieveOfEratosthenes
{

	public static void main( String args[] )
	{
		boolean finished = false;
		Scanner inputScanner = new Scanner( System.in );
		while( !finished )
		{
			System.out.print( "Enter int >= 2: " );
			if( inputScanner.hasNextInt() )
			{
				int N = inputScanner.nextInt();
				if( N >= 2 )
				{
					boolean[] sequence = sieve( N );
					System.out.println( sequenceToString( sequence ) );
					finished = true;
				}
				else
				{
					System.out.println( "Invalid Input" );
					System.out.println( "" );
					inputScanner.nextLine();
				}
			}
			else
			{
				System.out.println( "Invalid Input" );
				System.out.println( "" );
				inputScanner.nextLine();
			}
		}
		inputScanner.close();
	}
	
	public static boolean[] createSequence( int N )
	{
		boolean[] sequence = new boolean[ N - 1 ];
		for( int count = 2; count <= N; count++ )
		{
			sequence[ count - 2 ] = true;
		}
		return sequence;
	}
	
	public static void crossOutHigherMultiples( boolean[] sequence, int n )
	{
		if( sequence != null && n >= 0 && n <= sequence.length + 1 )
		{
			for( int count = 2; ( count * n ) - 2 < sequence.length; count++ )
			{
				if( sequence[ ( count * n ) - 2 ] == true )
				{
					sequence[ ( count * n ) - 2 ] = false;
				}
			}
		}
	}
	
	public static boolean[] sieve( int N )
	{
		boolean[] sequence = createSequence( N );
		System.out.println( nonCrossedOutSubSequenceToString( sequence ) );
		for( int count = 0; count + 2 <= Math.sqrt( sequence.length + 1 ); count++ )
		{
			if( sequence[ count ] == true )
			{
				crossOutHigherMultiples( sequence, count + 2 );
				System.out.println( nonCrossedOutSubSequenceToString( sequence ) );
			}
		}
		return sequence;
	}
	
	public static String sequenceToString( boolean[] sequence )
	{
		String sequenceToString = "";
		if( sequence != null )
		{
			sequenceToString += "2";
			for( int count = 1; count < sequence.length; count++ )
			{
				if( sequence[ count ] == true )
				{
					sequenceToString += ", " + ( count + 2 );
				}
			}
		}
		return sequenceToString;
	}
	
	public static String nonCrossedOutSubSequenceToString( boolean[] sequence )
	{
		String nonCrossedOutSubSequenceToString = "";
		if( sequence != null )
		{
			nonCrossedOutSubSequenceToString += "2";
			for( int count = 1; count < sequence.length; count++ )
			{
				if( sequence[ count ] == true )
				{
					nonCrossedOutSubSequenceToString += ", " + ( count + 2 );
				}
				else
				{
					nonCrossedOutSubSequenceToString += ", [" + ( count + 2 ) + "]";
				}
			}
		}
		return nonCrossedOutSubSequenceToString;
	}
	
}