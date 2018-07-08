/*
 * Write a program to maintain a list of the high scores obtained in a game.
 * The program should first ask the user how many scores they want to maintain
 * and then repeatedly accept new scores from the user and should add the score to the list of high scores 
 * (in the appropriate position) if it is higher than any of the existing high scores.
 * 
 * You must include the following functions:
 *  
 * initialiseHighScores () which sets all high scores to zero.
 * 
 * printHighScores() which prints the high scores in the format: 
 * “The high scores are 345, 300, 234”, for all existing high scores in the list 
 * (remember that sometimes it won’t be full).
 * 
 * higherThan() which takes the high scores and a new score and returns whether the passed score
 * is higher than any of those in the high score list.
 * 
 * insertScore() which takes the current high score list  and a new score and updates it
 * by inserting the new score at the appropriate position in the list
 */

import javax.swing.JOptionPane;
import java.util.Scanner;

public class HighScores
{
	
	public static void main( String args[] )
	{	
		printHighScores( getScores( getNumberOfHighScores() ) );
	}
	
	public static int getNumberOfHighScores( )
	{
		String input = JOptionPane.showInputDialog( null, "Enter the number of high scores: " );
		boolean finished = false;
		int numberOfHighScores = 0;
		while( !finished )
		{
			try
			{
				Scanner inputScanner = new Scanner( input );
				numberOfHighScores = inputScanner.nextInt();
				inputScanner.close();
				finished = true;
			}
			catch( NullPointerException exception )
			{
				System.exit(0);
			}
			catch( java.util.NoSuchElementException exception )
			{
				input = JOptionPane.showInputDialog( null, "Invalid input, try again: ");
			}
		}
		return numberOfHighScores;
	}
	
	public static int[] getScores( int numberOfHighScores )
	{
		int[] scores = new int[ numberOfHighScores ];
		initialiseHighScores( scores );
		String input = JOptionPane.showInputDialog( null, "Enter the scores separated by spaces: " );
		boolean finished = false;
		while(!finished)
		{
			try
			{
				Scanner inputScanner = new Scanner( input );
				while( inputScanner.hasNext() )
				{
					int currentScore = inputScanner.nextInt();
					if( higherThan( currentScore, scores ) )
					{
						insertScore( currentScore, scores );
					}
				}
				inputScanner.close();
				finished = true;
			}
			catch( NullPointerException exception )
			{
				System.exit(0);
			}
			catch( java.util.NoSuchElementException exception )
			{
				initialiseHighScores( scores );
				input = JOptionPane.showInputDialog( null, "Input error, try again: " );
			}
		}
		return scores;
	}

	public static void initialiseHighScores( int[] scores )
	{
		if( scores != null )
		{
			for( int index = 0; index < scores.length; index++ )
			{
				scores[ index ] = 0;
			}
		}
	}
	
	public static boolean higherThan( int currentScore, int[] scores )
	{
		for( int index = 0; index < scores.length; index++ )
		{
			if( currentScore > scores[index] )
			{
				return true;
			}
		}
		return false;
	}
	
	public static void insertScore( int currentScore, int[] scores )
	{
		int position = 0;
		boolean positionFound = false;
		while( !positionFound )
		{
			if( currentScore > scores[position] )
			{
				positionFound = true;
			}
			else
			{
				position++;
			}
		}
		for( int count = scores.length - 1; count > position; count-- )
		{
			scores[count] = scores[count - 1];
		}
		scores[position] = currentScore;
	}
	
	public static void printHighScores( int[] scores )
	{
		String output = ( "The High Scores are: " );
		for( int count = 0; count < scores.length; count++ )
		{
			if( ( count == 0 && scores.length == 1 ) || ( count == 0 && scores[count + 1] == 0 ) )
			{
				output = "The high score is " + scores[count];
			}
			else
			{
				if ( count < scores.length - 1 )
				{
					if( scores[count + 1] > 0 )
					{
						output += ( scores[count] + " " );
					}
					else if( scores[count] > 0 )
					{
						output += ( "and " + scores[count] );
					}
				}
				else if( scores[count] > 0 )
				{
					output += ( "and " + scores[count] );
				}
			}
		}
		JOptionPane.showMessageDialog( null, output );
	}
	
}