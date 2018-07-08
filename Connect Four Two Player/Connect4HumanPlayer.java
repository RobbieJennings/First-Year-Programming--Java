import java.util.Scanner;

public class Connect4HumanPlayer extends Connect4Player
{
	Connect4HumanPlayer(char playerPiece)
	{
		super( playerPiece );
	}

	void makeMove( Connect4Grid grid )
	{
		if( !grid.isGridFull() )
		{
			boolean finished = false;
			Scanner inputScanner = new Scanner( System.in );
			while( !finished )
			{
				System.out.print("Enter move: ");
				String input = inputScanner.nextLine();
				try
				{
					int column = Integer.parseInt( input ) - 1;
					if( !grid.isValidColumn( column ) )
					{
						System.out.println( " Invalid entry.  You must enter a valid column." );
					}
					else if ( grid.isColumnFull( column) )
					{
						System.out.println( " Invalid entry.  This column is already full." );
					}
					else
					{
						grid.dropPiece( this, column );
						finished = true;
					}
				}
				catch( NumberFormatException e )
				{
					System.out.println( " Invalid entry." );
				}
			}
		}
	}
}