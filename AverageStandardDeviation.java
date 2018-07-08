/*
 * Write a program which takes in three numbers
 * and computes their average
 * and standard deviation 
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class AverageStandardDeviation
	
{
	
	public static void main( String[] args )
		
	{
			
		String input = JOptionPane.showInputDialog( "Enter the value of the first number" );
		Scanner inputScanner = new Scanner ( input );
		double numberA = inputScanner.nextDouble();
		inputScanner.close();
			
		input = JOptionPane.showInputDialog( "Enter the value of the second number" );
		inputScanner = new Scanner ( input );
		double numberB = inputScanner.nextDouble();
		inputScanner.close();
		
		input = JOptionPane.showInputDialog( "Enter the value of the third number" );
		inputScanner = new Scanner ( input );
		double numberC = inputScanner.nextDouble();
		inputScanner.close();
		
		double average = ( numberA + numberB + numberC ) / 3.0;
		
		double newA = ( numberA - average )	* (numberA - average );
		double newB = ( numberB - average ) * (numberB - average );
		double newC = ( numberC - average ) * (numberC - average );
		
		double fraction = ( newA + newB + newC ) / 3.0;
		
		double standardDeviation = Math.sqrt ( fraction );
		
		JOptionPane.showMessageDialog ( null, "the average is " + average + "and the standard deviation is " + standardDeviation);
		
	}
		
}