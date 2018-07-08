import java.util.Scanner;
import java.awt.Font;
import java.awt.Color;

public class SieveOfEratosthenes
{
	
	public static final Color[] COLORS = { StdDraw.BLUE, StdDraw.CYAN, StdDraw.GREEN, StdDraw.MAGENTA, StdDraw.ORANGE, StdDraw.PINK, StdDraw.RED, StdDraw.YELLOW };
	public static final double MARGIN = 0.75;
	public static final int DELAY = 50;
	
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
					displayNumbers2ToN( N );
					boolean[] sequence = sieve( N );
					System.out.println( sequenceToString( sequence ) );
					System.out.println( "" );
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
	
	public static void crossOutHigherMultiples( boolean[] sequence, int n, int N, int primeCount )
	{
		if( sequence != null && n >= 2 )
		{
			for( int count = 2; ( count * n ) - 2 < sequence.length; count++ )
			{
				if( sequence[ ( count * n ) - 2 ] == true )
				{
					sequence[ ( count * n ) - 2 ] = false;
					displayComposite( count * n, primeCount, N );
				}
			}
		}
	}
	
	public static boolean[] sieve( int N )
	{
		int primeCount = 0;
		boolean[] sequence = createSequence( N );
		System.out.println( nonCrossedOutSubSequenceToString( sequence ) );
		for( int count = 0; count + 2 <= N; count++ )
		{
			if( sequence[ count ] == true && count + 2 <= Math.sqrt( sequence.length + 1 ) )
			{
				displayPrime( N, count + 2, primeCount );
				crossOutHigherMultiples( sequence, count + 2, N, primeCount);
				System.out.println( nonCrossedOutSubSequenceToString( sequence ) );
				primeCount++;
			}
			else if( sequence[ count ] == true )
			{
				displayPrime( N, count + 2, primeCount );
				primeCount++;
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
	
	public static void displayNumber( int n, Color c, int N )
	{
		if( N >= 2 && n >= 2 )
		{
			double matrix = Math.ceil( Math.sqrt( N ) );
			double position = MARGIN / matrix;
			double size = ( position - ( position / matrix ) ) / 2;
			double width = position;
			double height = 1;
			StdDraw.setFont( createFont( size ) );
			for ( int count = 2; count <= N; count++ )
			{
				if( count == n )
				{
					StdDraw.setPenColor( c );
					StdDraw.filledSquare( width + size, height - size, size );
					StdDraw.setPenColor( StdDraw.BLACK );
					StdDraw.text( width + size, height - size, "" + n );
				}
				width += position;
				if( count % matrix == 0 )
				{
					width =0;
					height -= position;
				}
			}
		}
	}
	
	public static void displayNumbers2ToN( int N )
	{
		if( N >= 2 )
		{
			for ( int count = 2; count <= N; count++ )
			{
				displayNumber( count, StdDraw.LIGHT_GRAY, N );
			}
		}
	}
	
	public static void displayComposite( int m, int primeCount, int N )
	{
		if( m >=2 && N >= 2 && primeCount >= 0 )
		{
			Color c = COLORS[ ( primeCount % COLORS.length ) ];
			displayNumber( m, c, N );
			try
			{
				Thread.sleep( DELAY );
			} 
			catch ( InterruptedException e ) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void displayPrime( int N, int p, int primeCount )
	{
		if( p >= 2 && N >= 2 && primeCount >= 0 )
		{
			double matrix = Math.ceil( Math.sqrt( Math.sqrt( N ) ) );
			double position = ( 1 - MARGIN ) / matrix;
			double size = ( position - ( position / matrix ) ) / 2;
			double width = MARGIN + size;
			double height = 1;
			StdDraw.setFont( createFont( size ) );
			StdDraw.setPenColor( StdDraw.BLACK );
			if( primeCount == 0 )
			{
				StdDraw.text( MARGIN + ( ( 1 - MARGIN ) / 2 ), height - size, "Prime Numbers:" );
			}
			height -= position;
			for ( int count = 1; count <= primeCount; count++ )
			{
				if( count % matrix == 0 )
				{
					width = MARGIN + size;
					height -= position;
				}
				else
				{
					width += position;
				}
			}
			StdDraw.text( width + size, height - size, "" + p );
			try
			{
				Thread.sleep( DELAY );
			} 
			catch ( InterruptedException e ) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static Font createFont( double size )
	{
		Font myFont = new Font( "ComicSans", Font.PLAIN, 0 );
		if( size >= 0.05 )
		{
			myFont = new Font( "ComicSans", Font.PLAIN, 25 );
		}
		else if( size >= 0.03 )
		{
			myFont = new Font( "ComicSans", Font.PLAIN, 15 );
		}
		else if( size >= 0.01 )
		{
			myFont = new Font( "ComicSans", Font.PLAIN, 8 );
		}
		else if( size >= 0.005)
		{
			myFont = new Font( "ComicSans", Font.PLAIN, 3 );
		}
		else if( size >= 0.0001 )
		{
			myFont = new Font("ComicSans", Font.PLAIN, 1 );
		}
		return myFont;
	}

}