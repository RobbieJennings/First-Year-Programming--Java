import java.util.Scanner;

public class Connect4Game
{	
	public static final char CROSS = 'X';
	public static final char NOUGHT = 'O';
	
	public static void main( String args[] )
	{
		Connect4Grid grid = new Connect4Grid2DArray();
		Connect4Player player1 = new Connect4HumanPlayer( CROSS );
		Connect4Player player2 = new Connect4HumanPlayer( NOUGHT );
		Scanner inputScanner = new Scanner( System.in );
		boolean finished = false;
		while( !finished )
		{
			System.out.print( "Do you want player1 to be a human or the computer?: " );
			String input = inputScanner.nextLine();
			if( input.equals( "human" ) )
			{
				player1 = new Connect4HumanPlayer( CROSS );
				finished = true;
			}
			else if( input.equals( "computer" ) )
			{
				player1 = new Connect4AIPlayer( CROSS );
				finished = true;
			}
			else
			{
				System.out.println( " Invalid Input" );
			}
		}
		Connect4Player thisPlayer = player1;
		finished = false;
		while( !finished )
		{
			System.out.print( "Do you want player2 to be a human or the computer?: " );
			String input = inputScanner.nextLine();
			if( input.equals( "human" ) )
			{
				player2 = new Connect4HumanPlayer( NOUGHT );
				finished = true;
			}
			else if( input.equals( "computer" ) )
			{
				player2 = new Connect4AIPlayer( NOUGHT );
				finished = true;
			}
			else
			{
				System.out.println( " Invalid Input" );
			}
		}
		System.out.println( grid );
		boolean winner = false;
		finished = false;
		while( !finished )
		{
			thisPlayer.makeMove( grid );
			System.out.println( grid );
			if( thisPlayer == player1 )
			{
				if( grid.didLastPieceConnect4() )
				{
					System.out.print( "The Winner was Player 1." );
					finished = true;
					winner = true;
				}
				thisPlayer = player2;
			}
			else if( thisPlayer == player2 )
			{
				if( grid.didLastPieceConnect4() )
				{
					System.out.print( "The Winner was Player 2." );
					finished = true;
					winner = true;
				}
				thisPlayer = player1;
			}
			if( grid.isGridFull() )
			{
				finished = true;
				if( !winner )
				{
					System.out.print( "It was a tie.");
				}
			}
		}
	}
}