/*
 * Using a WHILE or a DO-WHILE loop write a program which allows the user to play the High-Low Card game.
 * 
 * The High-Low card game is one where the user is presented with an initial card (2 – 10, Jack, Queen, King, or Ace)
 * and has to guess that the next card with be Higher, Lower or Equal to the current card.
 * They must guess successfully 4 times in a row in order to win.
 */

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class HighLow 

{

	public static final int NUMBER_OF_TRIES = 4;
	public static final int NUMBER_OF_CARDS = 13;
	public static final int NUMBER_OF_SUITS = 4;
	
	public static void main ( String args[] )
	
	{
	
		boolean finished = false;
		while( !finished )
		{
			
			Random cardGenerator = new Random();
			Random suitGenerator = new Random();
			int count = 0;
			boolean fail = false;
			boolean guessHigher = false;
			boolean guessLower = false;
			boolean guessEqual = false;
			String cardShown = "Unknown";
			String suitShown = "Unknown";
		
			int cardDrawn = cardGenerator.nextInt( NUMBER_OF_CARDS );
			int nextCard = cardGenerator.nextInt( NUMBER_OF_CARDS );
			int previousCard = cardDrawn;
			
			int suitDrawn = suitGenerator.nextInt( NUMBER_OF_SUITS );
			int nextSuit = suitGenerator.nextInt( NUMBER_OF_SUITS );
			int previousSuit = suitDrawn;
		
			if( cardDrawn == 0 )
				cardShown = "Ace";
			else if( cardDrawn == 1 )
				cardShown = "Two";
			else if( cardDrawn == 2 )
				cardShown = "Three";
			else if( cardDrawn == 3 )
				cardShown = "Four";
			else if( cardDrawn == 4 )
				cardShown = "Five";
			else if( cardDrawn == 5 )
				cardShown = "Six";
			else if( cardDrawn == 6 )
				cardShown = "Seven";
			else if( cardDrawn == 7 )
				cardShown = "Eight";
			else if( cardDrawn == 8 )
				cardShown = "Nine";
			else if( cardDrawn == 9 )
				cardShown = "Ten";
			else if( cardDrawn == 10 )
				cardShown = "Jack";
			else if( cardDrawn == 11 )
				cardShown = "Queen";
			else if( cardDrawn == 12 )
				cardShown = "King";
			
			if( suitDrawn == 0 )
				suitShown = "Spades";
			else if( suitDrawn == 1 )
				suitShown = "Clubs";
			else if( suitDrawn == 2 )
				suitShown = "Hearts";
			else if( suitDrawn == 3 )
				suitShown = "Diamonds";
		
			while( count < 1 && !fail )
			{
				try
				{
					String input = JOptionPane.showInputDialog( null, "The first card is " + cardShown + " of " + suitShown
							+ "\nDo you think the next card will be higher, lower or equal?" );
			
					Scanner inputScanner = new Scanner( input );
				
					String guess = inputScanner.nextLine();
					
					guessHigher = guess.equals( "higher" );
					guessLower = guess.equals( "lower" );
					guessEqual = guess.equals( "equal" );

					if( guessHigher )
					{
						if( nextCard > cardDrawn )
						{
							count++;
						}
						else
						{
							fail = true;
							JOptionPane.showMessageDialog( null, "Fail." );
						}
					}
		
					else if( guessLower )
					{
						if( nextCard < cardDrawn )
						{
							count++;
						}
						else
						{
							fail = true;
							JOptionPane.showMessageDialog( null, "Fail." );
						}
					}
		
					else if( guessEqual )
					{
						if( nextCard == cardDrawn )
						{
							count++;
						}
						else
						{
							fail = true;
							JOptionPane.showMessageDialog( null, "Fail." );
						}
					}
					
					else
					{
						JOptionPane.showMessageDialog( null, "Invalid input." );
						cardDrawn = previousCard;
						suitDrawn = previousSuit;
					}
			
					inputScanner.close();
				}
			
				catch( java.util.NoSuchElementException exception )
				{
					JOptionPane.showMessageDialog( null, "Nothing entered." );
					cardDrawn = previousCard;
					suitDrawn = previousSuit;
				}
				
				catch( java.lang.NullPointerException exception )
				{
					fail = true;
				}
		
			}	
			
			while( count < NUMBER_OF_TRIES && !fail )
			{
				try
				{
					cardDrawn = nextCard;
					nextCard = cardGenerator.nextInt( NUMBER_OF_CARDS );
					previousCard = cardDrawn;
					
					suitDrawn = nextSuit;
					nextSuit = suitGenerator.nextInt( NUMBER_OF_SUITS );
					previousSuit = suitDrawn;
				
					if( cardDrawn == 0 )
						cardShown = "Ace";
					else if( cardDrawn == 1 )
						cardShown = "Two";
					else if( cardDrawn == 2 )
						cardShown = "Three";
					else if( cardDrawn == 3 )
						cardShown = "Four";
					else if( cardDrawn == 4 )
						cardShown = "Five";
					else if( cardDrawn == 5 )
						cardShown = "Six";
					else if( cardDrawn == 6 )
						cardShown = "Seven";
					else if( cardDrawn == 7 )
						cardShown = "Eight";
					else if( cardDrawn == 8 )
						cardShown = "Nine";
					else if( cardDrawn == 9 )
						cardShown = "Ten";
					else if( cardDrawn == 10 )
						cardShown = "Jack";
					else if( cardDrawn == 11 )
						cardShown = "Queen";
					else if( cardDrawn == 12 )
						cardShown = "King";
					
					if( suitDrawn == 0 )
						suitShown = "Spades";
					else if( suitDrawn == 1 )
						suitShown = "Clubs";
					else if( suitDrawn == 2 )
						suitShown = "Hearts";
					else if( suitDrawn == 3 )
						suitShown = "Diamonds";
			
					String input = JOptionPane.showInputDialog( null, "The next card is " + cardShown + " of " + suitShown
							+ "\nDo you think the next card will be higher, lower or equal?" );
			
					Scanner inputScanner = new Scanner( input );
					
					String guess = inputScanner.nextLine();
			
					guessHigher = guess.equals( "higher" );
					guessLower = guess.equals( "lower" );
					guessEqual = guess.equals( "equal" );
				
					if( guessHigher )
					{
						if( nextCard > cardDrawn )
						{
							count++;
						}
						else
						{
							fail = true;
							JOptionPane.showMessageDialog(null, "Fail.");
						}
					}
		
					else if( guessLower )
					{
						if( nextCard < cardDrawn )
						{
							count++;
						}
						else
						{
							fail = true;
							JOptionPane.showMessageDialog(null, "Fail.");
						}
					}
		
					else if( guessEqual )
					{
						if( nextCard == cardDrawn )
						{
							count++;
						}
						else
						{
							fail = true;
							JOptionPane.showMessageDialog( null, "Fail." );
						}	
					}
			
					else
					{
						JOptionPane.showMessageDialog( null, "Invalid input." );
						nextCard = previousCard;
						nextSuit = previousSuit;
					}
					
					inputScanner.close();
				}
			
				catch( java.util.NoSuchElementException exception )
				{
					JOptionPane.showMessageDialog( null, "Nothing entered." );
					nextCard = previousCard;
					nextSuit = previousSuit;
				}
			
				catch( java.lang.NullPointerException exception )
				{
					fail = true;
				}
			}
		
			if( !fail )
			{
				JOptionPane.showMessageDialog( null, "Success!" );
			}

			int playAgain = JOptionPane.showConfirmDialog( null, "Play again?", null, JOptionPane.YES_NO_OPTION );
			if( playAgain == JOptionPane.NO_OPTION || playAgain == JOptionPane.CLOSED_OPTION )
			{
				JOptionPane.showMessageDialog( null, "Goodbye." );
				finished = true;
			}	
			
		}
		
	}
	
}