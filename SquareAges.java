/* Given that no person has ever lived longer than 123 years (and assuming that no one ever will)
 * write a Java application that will determine if it is possible that anyone who is alive today
 * is, has ever been, or will ever be alive in a year that is the square of their age.
 * If it is possible, your program should print out the years in which it happens
 * and the ages that the people concerned will have in those years.
 */

import javax.swing.JOptionPane;
import java.util.Scanner;

public class SquareAges

{

	public static final int SMALLEST_POSSIBLE_AGE = 0;
	public static final int LARGEST_POSSIBLE_AGE = 123;
	
	public static void main( String[] args )
		
	{
		
		String input = JOptionPane.showInputDialog( "what is the present year?" );
		Scanner inputScanner = new Scanner( input );
		int presentYear = inputScanner.nextInt();
		inputScanner.close();
		
		if( presentYear == 0 )
		{
			JOptionPane.showMessageDialog( null, "There is no such thing as year 0" );
		}
		else
		{	
			boolean possible = false;
			for( int age = SMALLEST_POSSIBLE_AGE; age <= LARGEST_POSSIBLE_AGE; age++ )
			{
				int ageSquared = age * age;
				int birthYear = ageSquared - age;
				int smallestPossibleYear = presentYear - LARGEST_POSSIBLE_AGE;
				
				if( ( birthYear >= smallestPossibleYear ) && ( birthYear <= presentYear ) && ( birthYear != 0 ) )
				{
					if( ageSquared < presentYear )
					{
						possible = true;
						JOptionPane.showMessageDialog( null, "If you were born in the year " + ( birthYear )  
							+ " \nyou would have turned " + age + " in the year " + ageSquared + "."
							+ " \nThis would have made your age the square root of the current year." );
					}
					else if( ageSquared == presentYear )
					{
						possible = true;
						JOptionPane.showMessageDialog( null, "If you were born in " + ( birthYear ) 
							+ " \nyou have turned or will turn " + age + " this year."
							+ " \nThis makes or will make your age the square root of the current year." );
					}
					else if( ageSquared > presentYear )
					{
						possible = true;
						JOptionPane.showMessageDialog( null, "If you were born in the year " + ( birthYear )
							+ " \nyou will turn " + age + " in the year " + ageSquared + "."
							+ " \nThis will make your age the square root of the current year." );
					}
				}		
			}
			
			if ( !possible )
			{
				JOptionPane.showMessageDialog( null, "It is not possible for anyone who is alive today"
					+ "\nto turn an age or have turned an age"
					+ "\nthat is the square root of the current year"
					+ "\nat any point in their lives." );
			}

		}
		
	}
	
}