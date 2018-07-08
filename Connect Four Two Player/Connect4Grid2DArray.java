public class Connect4Grid2DArray implements Connect4Grid
{
	Connect4Grid2DArray()
	{
		emptyGrid();
	}
	
	public void emptyGrid() 
	{
		for( int row = 0; row < grid.length; row++ )
		{
			for( int column = 0; column < grid[ row ].length; column++ )
			{
				grid[ row ][ column ] = BLANK;
			}
		}
	}
	
	public String toString()
	{
		String gridString = new String();
		for( int row = 0; row < NUMBER_OF_ROWS; row++ )
		{
			for( int column = 0; column < NUMBER_OF_COLUMNS; column++ )
			{
				gridString += ( "| " + grid[ row ][ column ] + " " );
				if( column >= NUMBER_OF_COLUMNS - 1 )
				{
					gridString += ( "|" );
				}
			}
			gridString += ( "\n" );
		}
		gridString += ( "-" );
		for( int index = 0; index < NUMBER_OF_COLUMNS; index++ )
		{
			gridString += ( "----" );
		}		
		gridString += ( "\n" );
		for( int index = 1; index <= NUMBER_OF_COLUMNS; index++ )
		{
			gridString += ( "  " + index + " ");
		}
		gridString += ( "\n" );
		return gridString;
	}

	public boolean isValidColumn( int column )
	{
		return column >= 0 && column < NUMBER_OF_COLUMNS;
	}

	public boolean isColumnFull( int column )
	{
		return grid[ 0 ][ column ] != BLANK;
	}

	public void dropPiece( Connect4Player player, int column )
	{
		if( isValidColumn( column ) && !isColumnFull( column ) )
		{
			for( int row = NUMBER_OF_ROWS - 1; row >= 0; row-- )
			{
				if( grid[ row ][ column ] == BLANK )
				{
					grid[ row ][ column ] = player.getPlayerPiece();
					break;
				}
			}
		}
	}

	public boolean didLastPieceConnect4()
	{
		for( int row = 0; row < NUMBER_OF_ROWS; row++ )
		{
			for( int i = 0; i <= NUMBER_OF_COLUMNS - PIECES_IN_A_ROW_TO_WIN; i++ )
			{
				if( grid[ row ][ 0 + i ] == grid[ row ][ 1 + i ] && grid[ row ][ 1 + i ] == grid[ row ][ 2 + i ] && grid[ row ][ 2 + i ] == grid[ row ][ 3 + i ]
						&& grid[ row ][ 0 + i ] != BLANK )
				{
					return true;
				}
			}
		}
		for( int column = 0; column < NUMBER_OF_COLUMNS; column++ )
		{
			for( int i = 0; i <= NUMBER_OF_ROWS - PIECES_IN_A_ROW_TO_WIN; i++ )
			{
				if( grid[ 0 + i ] [ column ] == grid[ 1 + i ][ column ] && grid[ 1 + i ][ column ] == grid[ 2 + i ][ column ] && grid[ 2 + i ][ column ] == grid[ 3 + i ][ column ]
						&& grid[ 0 + i ][ column ] != BLANK )
				{
					return true;
				}
			}
		}
		for( int row = 0; row <= NUMBER_OF_ROWS - PIECES_IN_A_ROW_TO_WIN; row++ )
		{
			for( int i = 0; i <= NUMBER_OF_COLUMNS - PIECES_IN_A_ROW_TO_WIN; i++ )
			{
				if( ( grid[ row ][ 0 + i ] == grid[ row + 1 ][ 1 + i ] && grid[ row + 1 ][ 1 + i ] == grid[ row + 2 ][ 2 + i ] && grid[ row + 2 ][ 2 + i ] == grid[ row + 3 ][ 3 + i ]
						&& grid[ row ][ 0 + i ] != BLANK )
						|| ( grid[ row ][ 6 - i ] == grid[ row + 1 ][ 5 - i ] && grid[ row + 1 ][ 5 - i ] == grid[ row + 2 ][ 4 - i ] && grid[ row + 2 ][ 4 - i ] == grid[ row + 3 ][ 3 - i ]
						&& grid[ row ][ 6 - i ] != BLANK ) )
				{
					return true;
				}
			}
		}
		return false;
	}

	public boolean isGridFull()
	{
		for( int column = 0; column < NUMBER_OF_COLUMNS; column++ )
		{
			if( grid[ 0 ][ column ] == BLANK )
			{
				return false;
			}
		}
		return true;
	}
}