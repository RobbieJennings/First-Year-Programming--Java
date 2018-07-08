import java.util.Scanner;

public class NoughtsAndCrosses 
{
	public static final char BLANK = ' ';
	public static final char NOUGHT = 'O';
	public static final char CROSS = 'X';
	public static final int BOARD_SIZE = 3;
	
	public static void main(String[] args) 
	{
		char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
		clearBoard( board );
		char currentPlayerPiece = CROSS;
		Scanner input = new Scanner(System.in);
		while ((!isBoardFull(board)) && (winner(board) == BLANK))
		{
			printBoard(board);
			int row=-1;
			int column=-1;
			do
			{
				System.out.print("Enter move for " + currentPlayerPiece + ": ");
				char[] inputCharacters = input.next().toCharArray();
				if ((inputCharacters.length >= 2) &&
						(inputCharacters[0] >= 'A') && (inputCharacters[0] <= 'C') &&
						(inputCharacters[1] >= '1') && (inputCharacters[1] <= '3'))
				{
					row = (int) (inputCharacters[0]-'A');
					column = (int) (inputCharacters[1]-'1');
					if (!canMakeMove(board,row,column))
						System.out.println(" Invalid entry. This location is already"
								+ " occupied.");
				}
				else System.out.println(" Invalid entry. You must enter a row and column"
						+ "( e.g. B2 is the center piece on the board).");
			} 
			while ((row == -1) || (!canMakeMove(board,row,column)));
			makeMove(board,currentPlayerPiece,row,column);
			currentPlayerPiece = (currentPlayerPiece==CROSS)?NOUGHT:CROSS;
		}
		printBoard(board);
		if (winner(board) == BLANK)
			System.out.println("It was a draw.");
		else 
			System.out.println("The winner was " + winner(board));
		input.close();
	}
	
	public static void clearBoard( char[][] board )
	{
		for( int row = 0; row < board.length; row++ )
		{
			for( int column = 0; column < board[ row ].length; column++ )
			{
				board[ row ][ column ] = BLANK;
			}
		}
	}
	
	public static void printBoard( char[][] board )
	{
		for( int row = 0; row < board.length; row++ )
		{
			switch( row )
			{
			case 0:
				System.out.print( "A " );
				break;
			case 1:
				System.out.print( "B " );
				break;
			case 2:
				System.out.print( "C " );
				break;
			}
			for( int column = 0; column < board[ row ].length; column++ )
			{
				System.out.print( " " + board[ row ][ column ] );
				if( column < board[ row ].length - 1 )
				{
					System.out.print( " |" );
				}
			}
			System.out.println( "" );
			if( row < board.length - 1 )
			{
				System.out.println( "  ---|---|---" );
			}
		}
		System.out.println( "   1   2   3" );
	}
	
	public static boolean canMakeMove( char[][] board, int row, int column )
	{
		if( board[ row ][ column ] == BLANK )
		{
			return true;
		}
		return false;
	}
	
	public static void makeMove( char[][] board, char playerPiece, int row, int column )
	{
		board[ row ][ column ] = playerPiece;
	}
	
	public static boolean isBoardFull( char[][] board )
	{
		for( int row = 0; row < board.length; row++ )
		{
			for( int column = 0; column < board[ row ].length; column++ )
			{
				if( board[ row ][ column ] == BLANK )
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static char winner( char[][] board )
	{
		for( int row = 0; row < board.length; row++ )
		{
			if( board[ row ] [ 0 ] == board[ row ][ 1 ] && board[ row ][ 1 ] == board[ row ][ 2 ] )
			{
				return board[ row ][ 0 ];
			}
		}
		for( int column = 0; column < board[ 1 ].length; column++ )
		{
			if( board[ 0 ] [ column ] == board[ 1 ][ column ] && board[ 1 ][ column ] == board[ 2 ][ column ] )
			{
				return board[ 0 ][ column ];
			}
		}
		if( board[ 0 ][ 0 ] == board[ 1 ][ 1 ] && board[ 1 ][ 1 ] == board[ 2 ][ 2 ] 
				|| board[ 0 ][ 2 ] == board[ 1 ][ 1 ] && board[ 1 ][ 1 ] == board[ 2 ][ 0 ] )
		{
			return board[ 1 ][ 1 ];
		}
		return BLANK;
	}
	
}