/*
 * Write a program which gets the height and weight of a person from the user
 * and then computes the BMI of that person.
 * BMI is the weight in kilograms divided by the height squared in metres.
 * Input should be obtained and results should be displayed using dialog boxes.
 */

import javax.swing.JOptionPane;
import java.util.Scanner;

public class bmi

{

	public static void main(String[] args)
	
	{

		String heightInput = JOptionPane.showInputDialog( "What is your height in metres?" );
		Scanner heightScanner = new Scanner( heightInput );
		double height = heightScanner.nextDouble();
		heightScanner.close();
		
		String weightInput = JOptionPane.showInputDialog( "What is your weight in kilograms?" );
		Scanner weightScanner = new Scanner( weightInput );
		double weight = weightScanner.nextDouble();
		weightScanner.close();

		double bmi = weight / (height * height);

		JOptionPane.showMessageDialog( null, "Your Body Mass Index is " + bmi );

	}

}