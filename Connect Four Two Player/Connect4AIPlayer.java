import java.util.ArrayList;
import java.util.Random;

public class Connect4AIPlayer extends Connect4Player
{
	Connect4AIPlayer( char playerPiece )
	{
		super( playerPiece );
	}
	
	void makeMove( Connect4Grid grid )
	{
		if( !grid.isGridFull() )
		{
			System.out.println( "Computer's turn: ");
			ArrayList < Integer > availableColumns = new ArrayList < Integer >();
			int column = 0;
			while( grid.isValidColumn( column ) )
			{
				if( !grid.isColumnFull( column ) )
				{
					availableColumns.add( column );
				}
				column++;
			}
			Random randomGenerator = new Random();
			grid.dropPiece( this, availableColumns.get( randomGenerator.nextInt( availableColumns.size() ) ) );
		}
	}
}