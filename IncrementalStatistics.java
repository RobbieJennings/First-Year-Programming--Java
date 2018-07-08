/*
 * Write a program which keeps taking in numbers from a user on the command line until the user enters "quit" or "exit".
 * The user should be allowed to enter only one number each time
 * and the system should compute the average and variance of all numbers entered so far each time.
 * To do this WITHOUT storing all the numbers we must use formulas which allow to compute the average and variance
 * based only on the previous values (of the average and variance) together with the latest number entered.
 * 
 * AVERAGEN = AVERAGEN-1 + (NUMBERN - AVERAGEN-1) / N
 * VARIANCEN = ((VARIANCEN-1 * (N-1)) + (NUMBERN - AVERAGEN-1) * (NUMBERN - AVERAGEN)) / N
 */

import java.util.Scanner;

public class IncrementalStatistics

{

	public static void main( String args[] )
	
	{
		
		boolean immediatelyFinished = false;
		boolean firstNumber = false;
		boolean finished = false;
		double number = 0;
		double average = 0;
		double variance = 0;
		double count = 0;
		
		Scanner inputScanner = new Scanner( System.in );
		
		System.out.println( "This program computes the average and variance of all numbers entered." );
		System.out.println();
		System.out.print( "Enter a number (or type 'exit'): " );
	
		while( !immediatelyFinished && !firstNumber )
		{		
			if( inputScanner.hasNextDouble() )
			{		
				number = inputScanner.nextDouble();
				average = number;
				variance = 0;
				count++;
				firstNumber = true;
				
				System.out.println( "So far the average is " + average + " and the variance is " + variance );
				System.out.println();
				System.out.print( "Enter another number (or type 'exit'): " );
			}
			
			else if( inputScanner.hasNext( "exit" ) || inputScanner.hasNext( "quit" ) )
			{
				immediatelyFinished = true;
				finished = true;
			}
			
			else
			{
				System.out.println( inputScanner.next() + " is an invalid input." );
				System.out.println();
				System.out.print( "Enter a number (or type 'exit'): " );
			}
		}
		
		while( !finished )
		{	
			if( inputScanner.hasNextDouble() )
			{		
				number = inputScanner.nextDouble();
				double previousAverage = average;
				double previousVariance = variance;
				count++;
				average = previousAverage + ( number - previousAverage ) / count;
				variance = ( ( previousVariance * ( count - 1 ) ) + ( number - previousAverage ) * ( number - average ) ) / count;
				
				System.out.println( "So far the average is " + average + " and the variance is " + variance );
				System.out.println();
				System.out.print( "Enter another number (or type 'exit'): " );
			}
			
			else if( inputScanner.hasNext( "exit" ) || inputScanner.hasNext( "quit" ) )
			{
				finished = true;
			}
			
			else
			{
				System.out.println( inputScanner.next() + " is an invalid input." );
				System.out.println();
				System.out.print( "Enter a number (or type 'exit'): " );
			}
		}
		
		System.out.println( "Goodbye." );
		inputScanner.close();
		
	}
	
}