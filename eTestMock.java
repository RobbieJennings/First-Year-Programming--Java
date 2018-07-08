import java.util.Scanner;

public class eTestMock 
{
	
	public static void main( String args[] )
	{
		int size = getSize();
		buildTopOrBottomLine( size );
		buildMiddleLine( size );
		buildTopOrBottomLine( size );
	}
	
	public static int getSize()
	{
		System.out.print( "Enter the size of the box: " );
		Scanner inputScanner = new Scanner( System.in );
		int size = inputScanner.nextInt();
		inputScanner.close();
		return size;
	}
	
	public static void buildTopOrBottomLine( int size )
	{
		String numberOfLines = "";
		for( int count = 0; count < size; count++ )
		{
			numberOfLines += "-";
		}
		System.out.println( "+" + numberOfLines + "+" );
	}
	
	public static void buildMiddleLine( int size )
	{
		String numberOfSpaces = "";
		int numberOfLines = 0;
		for( int count = 0; count < ( size ); count++ )
		{
			numberOfSpaces += " ";
			numberOfLines += 1;
		}
		for( int count = 0; count < ( numberOfLines ); count++ )
		{
			System.out.println( "|" + numberOfSpaces + "|" );
		}
	}
	
}