/*
 * Write a program which takes in amounts of old Sterling pounds, shillings and pennies
 * and converts it to modern pounds and pennies.
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class PoundsShillingsPennies

{
	
	public static final int NEW_PENNIES_PER_OLD_PENNY = 67;
	public static final int OLD_PENNIES_PER_OLD_SHILLING = 12;
	public static final int OLD_SHILLINGS_PER_OLD_POUND = 20;
	public static final int NEW_PENNIES_PER_NEW_POUND = 100;

	public static void main( String[] args )
	
	{
		
		String input = JOptionPane.showInputDialog( "Enter the amount of old Pounds " );
		Scanner inputScanner = new Scanner( input );
		int oldPounds = inputScanner.nextInt();
		inputScanner.close();
		
		input = JOptionPane.showInputDialog( "Enter the amount of old Shillings " );
		inputScanner = new Scanner( input );
		int oldShillings = inputScanner.nextInt();
		inputScanner.close();
		
		input = JOptionPane.showInputDialog( "Enter the amount of old Pennies " );
		inputScanner = new Scanner( input );
		int oldPennies = inputScanner.nextInt();
		inputScanner.close();
		
		int totalNewPennies = ( int ) ( oldPennies * NEW_PENNIES_PER_OLD_PENNY )
				+ ( oldShillings * OLD_PENNIES_PER_OLD_SHILLING * NEW_PENNIES_PER_OLD_PENNY )
				+ ( oldPounds * OLD_SHILLINGS_PER_OLD_POUND * OLD_PENNIES_PER_OLD_SHILLING * NEW_PENNIES_PER_OLD_PENNY );
		
		int newPounds = ( int ) ( totalNewPennies / NEW_PENNIES_PER_NEW_POUND );
		int newPennies = ( int ) ( totalNewPennies % newPounds );
				
		JOptionPane.showMessageDialog( null, "You have " + newPounds + " new Pounds and " + newPennies + " new Pennies" );
		
	}

}