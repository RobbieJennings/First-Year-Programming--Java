/*
 * A �star number�, s, is a number defined by the formula:  s = 6n(n-1) + 1 where n is the index of the star number. 
 * Thus the star numbers are:   1, 13, 37, 73, 121, 181, 253, �
 *
 * A �triangle number�, t, is the sum of the numbers from 1 to n:   t = 1 + 2 + � + (n-1) + n. 
 * Thus the triangle numbers are:  1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 153, 171, 190, 210, 231, 253, �
 *
 * Write a Java application that produces a list of all the values of type int that are simultaneously star numbers and triangle numbers. 
 * 
 * As part of this problem you must write and use the following functions:
 * 		An isStarNumber() routine which determines if the passed number is a star number or not.
 * 		A determineStarNumber() function which returns the star number of a passed index (i.e. value of n). 
 */

public class TriangularStars
{
	
	public static void main( String args[] )
	{
		for( int number = 1; determineTriangleNumber( number ) > 0; number++ )
		{
			int solution = determineTriangleNumber( number );
			if( isStarNumber( solution ) )
				System.out.println( solution );
		}
	}
	
	public static int determineTriangleNumber( int number )
	{
		int triangleNumber = 0;
		for( int count = 0; count <= number; count++ )
		{
			triangleNumber += count; 
		}
		return triangleNumber;
	}
	
	public static int determineStarNumber( int number )
	{
		return ( 6 * number * ( number - 1 ) ) + 1;
	}
	
	public static boolean isStarNumber( int number )
	{
		boolean isStarNumber = false;
		for( int index = 1; number >= determineStarNumber( index ); index++ )
		{
			if( number == determineStarNumber( index ) )
				isStarNumber = true;
		}
		return isStarNumber;
	}
	
}