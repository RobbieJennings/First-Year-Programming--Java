import java.util.Scanner;

public class ChuckALuckDiceGame
{

	public static void main( String args[] )
	{
		Scanner inputScanner = new Scanner( System.in );
		Wallet playerWallet = new Wallet();
		double startingCash = getStartingCash( playerWallet, inputScanner );
		boolean finished = false;
		while( !finished )
		{
			if( playerWallet.check() > 0 )
			{
				String betType = getBetType( inputScanner );
				if( betType.equals( "quit" ) )
				{
					System.out.println( "" );
					finished = true;
				}
				else
				{
					resolveBet( betType, playerWallet, inputScanner );
					System.out.println( "" );
				}
			}
			else
			{
				finished = true;
			}
		}
		inputScanner.close();
		endGame( startingCash, playerWallet.check() );
	}
	
	public static double getStartingCash( Wallet playerWallet, Scanner inputScanner )
	{
		double startingCash = 0;
		boolean finished = false;
		while( !finished )
		{
			System.out.print( "Enter the amount of cash you have to play with: " );
			if( inputScanner.hasNextDouble() )
			{
				startingCash = inputScanner.nextDouble();
				finished = true;
			}
			else
			{
				System.out.println( "Invalid Input" );
				inputScanner.nextLine();
			}
		}
		inputScanner.nextLine();
		playerWallet.put( startingCash );
		return startingCash;
	}
	
	public static String getBetType( Scanner inputScanner )
	{
		String betType = "";
		boolean finished = false;
		while( !finished )
		{
			System.out.print( "Enter the type of bet you wish to make or type 'quit': " );
			String input = inputScanner.nextLine();
			input = input.toLowerCase();
			if( input.equals( "triple" ) || input.equals( "field" ) || input.equals( "high" ) || input.equals( "low" ) || input.equals( "quit" ) )
			{
				betType = input;
				finished = true;
			}
			else
			{
				System.out.println( "Invalid Input" );
			}
		}
		return betType;
	}
	
	public static double getBet( Scanner inputScanner )
	{
		double bet = 0;
		boolean finished = false;
		while( !finished )
		{
			System.out.print( "Enter the amount of money you wish to bet: " );
			if( inputScanner.hasNextDouble() )
			{
				bet = inputScanner.nextDouble();
				finished = true;
			}
			else
			{
				System.out.println( "Invalid Input" );
				inputScanner.nextLine();
			}
		}
		inputScanner.nextLine();
		return bet;
	}
	
	public static void resolveBet( String betType, Wallet playerWallet, Scanner inputScanner )
	{
		double bet = getBet( inputScanner );
		boolean play = playerWallet.get( bet );
		if( play )
		{
			Dice gameDice1 = new Dice();
			Dice gameDice2 = new Dice();
			Dice gameDice3 = new Dice();
			if( betType.equals( "triple" ) )
			{
				triple( gameDice1.topFace(), gameDice2.topFace(), gameDice3.topFace(), bet, playerWallet );
			}
			else if( betType.equals( "field" ) )
			{
				field( gameDice1.topFace(), gameDice2.topFace(), gameDice3.topFace(), bet, playerWallet );
			}
			else if( betType.equals( "high" ) )
			{
				high( gameDice1.topFace(), gameDice2.topFace(), gameDice3.topFace(), bet, playerWallet );
			}	
			else if( betType.equals( "low" ) )
			{
				low( gameDice1.topFace(), gameDice2.topFace(), gameDice3.topFace(), bet, playerWallet );
			}
		}
		else
		{
			System.out.println( "Insufficient Funds" );
		}
	}
	
	public static void triple( int firstDice, int secondDice, int thirdDice, double bet, Wallet playerWallet )
	{
		if( firstDice != 1 && firstDice != 6 && firstDice == secondDice && secondDice == thirdDice )
		{
			playerWallet.put( bet * 31 );
			System.out.println( firstDice + " " + secondDice + " " + thirdDice + " - You Win!" );
			System.out.println( "New Balance = " + playerWallet.check() );
		}
		else
		{
			System.out.println( firstDice + " " + secondDice + " " + thirdDice + " - You Lose!" );
			System.out.println( "New Balance = " + playerWallet.check() );
		}
	}
	
	public static void field( int firstDice, int secondDice, int thirdDice, double bet, Wallet playerWallet )
	{
		if( firstDice + secondDice + thirdDice < 8 || firstDice + secondDice + thirdDice > 12 )
		{
			playerWallet.put( bet * 2 );
			System.out.println( firstDice + " " + secondDice + " " + thirdDice + " - You Win!" );
			System.out.println( "New Balance = " + playerWallet.check() );
		}
		else
		{
			System.out.println( firstDice + " " + secondDice + " " + thirdDice + " - You Lose!" );
			System.out.println( "New Balance = " + playerWallet.check() );
		}
	}
	
	public static void high( int firstDice, int secondDice, int thirdDice, double bet, Wallet playerWallet )
	{
		if( firstDice + secondDice + thirdDice > 10 && !( firstDice != 1 && firstDice != 6 && firstDice == secondDice && secondDice == thirdDice ) )
		{
			playerWallet.put( bet * 2 );
			System.out.println( firstDice + " " + secondDice + " " + thirdDice + " - You Win!" );
			System.out.println( "New Balance = " + playerWallet.check() );
		}
		else
		{
			System.out.println( firstDice + " " + secondDice + " " + thirdDice + " - You Lose!" );
			System.out.println( "New Balance = " + playerWallet.check() );
		}
	}
	
	public static void low( int firstDice, int secondDice, int thirdDice, double bet, Wallet playerWallet )
	{
		if( firstDice + secondDice + thirdDice < 11 && !( firstDice != 1 && firstDice != 6 && firstDice == secondDice && secondDice == thirdDice ) )
		{
			playerWallet.put( bet * 2 );
			System.out.println( firstDice + " " + secondDice + " " + thirdDice + " - You Win!" );
			System.out.println( "New Balance = " + playerWallet.check() );
		}
		else
		{
			System.out.println( firstDice + " " + secondDice + " " + thirdDice + " - You Lose!" );
			System.out.println( "New Balance = " + playerWallet.check() );
		}
	}
	
	public static void endGame( double startingCash, double finishingCash )
	{
		if( startingCash == finishingCash )
		{
			System.out.println( "You broke even");
			System.out.print( "You started with " + startingCash + " and you still have " + finishingCash );
		}
		else if( startingCash > finishingCash )
		{
			System.out.println( "You lost " + ( startingCash - finishingCash ) );
			System.out.print( "You started with " + startingCash + " and you now have " + finishingCash );
		}
		else if( startingCash < finishingCash )
		{
			System.out.println( "You won " + ( finishingCash - startingCash ) );
			System.out.print( "You started with " + startingCash + " and you now have " + finishingCash );
		}
	}

}