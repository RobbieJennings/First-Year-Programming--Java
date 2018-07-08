import java.util.Scanner;

public class MinMax

{
	
	public static void main ( String args[] )
	
	{
		
		System.out.println( "Enter your numbers separated by spaces followed 'exit'" );
		Scanner inputScanner = new Scanner( System.in );

		if( inputScanner.hasNextDouble() )
		{
			double min = inputScanner.nextDouble();
			double max = min;
			
			while( inputScanner.hasNextDouble() )
			{
				double number = inputScanner.nextDouble();
				if( number < min )
					min = number;
				if( number > max )
					max = number;
			}
			if( inputScanner.hasNext( "exit" ) )
				System.out.println( "Min is " + min + "." + " Max is " + max + "." );
			else
				System.out.println( "Error" );
		}	
		else
			System.out.println( "Error" );
		
		inputScanner.close();
		
	}
	
}