import java.util.Scanner;

public class Test 
{
	public static void main( String args[] )
	{
		Rational rational1 = new Rational( 0 );
		Rational rational2 = new Rational( 0 );
		Rational sum = new Rational( 0 );
		Rational difference = new Rational( 0 );
		Rational product = new Rational( 0 );
		Rational quotient = new Rational( 0 );
		Scanner inputScanner = new Scanner( System.in );
		System.out.print( "Enter 2 rational numbers separated by a space: " );
		String input = inputScanner.nextLine();
		inputScanner.close();
		String[] inputArray = input.split( " " );
		String[] number1 = inputArray[ 0 ].split( "/" );
		String[] number2 = inputArray[ 1 ].split( "/" );
		if( number1.length >= 2 )
		{
			rational1 = new Rational( Integer.parseInt( number1[ 0 ] ), Integer.parseInt( number1[ 1 ] ) );
		}
		else
		{
			rational1 = new Rational( Integer.parseInt( number1[ 0 ] ) );
		}
		if( number2.length >= 2 )
		{
			rational2 = new Rational( Integer.parseInt( number2[ 0 ] ), Integer.parseInt( number2[ 1 ] ) );
		}
		else
		{
			rational2 = new Rational( Integer.parseInt( number2[ 0 ] ) );
		}
		sum = rational1.add( rational2 );
		product = rational1.multiply( rational2 );
		if( rational2.isLessThan( rational1 ) )
		{
			difference = rational1.subtract( rational2 );
			quotient = rational1.divide( rational2 );
		}
		else
		{
			difference = rational2.subtract( rational1 );
			quotient = rational2.divide( rational1 );
		}
		System.out.println( "The first rational is " + rational1 );
		System.out.println( "The second rational is " + rational2 );
		System.out.println( "The sum of the two rationals is " + sum );
		System.out.println( "the difference between the two rationals is " + difference );
		System.out.println( "The product of the two rationals is " + product );
		System.out.println( "The quotiant of the two rationals is " + quotient );
		if( rational1.equals( rational2 ) )
		{
			System.out.print( "The two rationals are equal" );
		}
		else if( rational1.isLessThan( rational2 ) )
		{
			System.out.print( "the first rational is smaller than the second" );
		}
		else if( rational2.isLessThan( rational1 ) )
		{
			System.out.print( "the first rational is greater than the second" );
		}
	}
}