/*
 * Write a program which takes in the coordinates of the three vertices of a triangle
 * and computes their area
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class TriangleArea

{
	
	public static void main( String[] args )
		
	{
			
		String input = JOptionPane.showInputDialog( "Enter the coordinates of the first vertice separated by a colon" );
		Scanner inputScanner = new Scanner( input );
		inputScanner.useDelimiter(":");
		double x1 = inputScanner.nextDouble();
		double y1 = inputScanner.nextDouble();
		inputScanner.close();
			
		input = JOptionPane.showInputDialog( "Enter the coordinates of the second vertice separated by a colon" );
		inputScanner = new Scanner( input );
		inputScanner.useDelimiter(":");
		double x2 = inputScanner.nextDouble();
		double y2 = inputScanner.nextDouble();
		inputScanner.close();
			
		input = JOptionPane.showInputDialog( "Enter the coordinates of the third vertice separated by a colon" );
		inputScanner = new Scanner( input );
		inputScanner.useDelimiter(":");
		double x3 = inputScanner.nextDouble();
		double y3 = inputScanner.nextDouble();
		inputScanner.close();
		
		double area = Math.abs ( ( ( x1 * ( y2 - y3 ) )
				+ ( x2 * ( y3 - y1 ) )
				+ ( x3 * ( y1 - y2 ) )
				/ 2.0 ) );
		
		JOptionPane.showMessageDialog( null, "The area is: " + area ); 
			
	}
		
}