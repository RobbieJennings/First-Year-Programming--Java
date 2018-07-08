/*
 * Write a Java program which converts (user entered) plain text to cipher text using a substitution cipher
 * (in which plain text letters are randomly assigned to cipher text letters).
 * Note that a Substitution Cipher replaces plain text with cipher text.
 * The most common substitution ciphers replace single characters of plain text with predefined single characters of cipher text
 * (e.g. the plain-text character 'a' might be replaced by cipher text character 'q', 'b' might be replaced by 'x', 'c' by 'k' and so on).
 * Each plain text character should be replaced by a different cipher text character.
 * 
 * As part of your solution you must write and use at least the following functions/methods:
 *  (i)    createCipher() which determines and returns the mapping from plain text to cipher text.
 *         Each plain text character ('a' .. 'z', ' ') must be randomly assigned a cipher text character;
 *         
 *  (ii)   an encrypt() method which takes a plain text phrase (as an array of characters) & the cipher
 *         and returns an encrypted version of the phrase according to the substitution cipher;
 *  
 *  (iii)  decrypt() which takes an encrypted phrase (as an array of characters) & the cipher mapping
 *         and returns a plain text version of the phrase according to the substitution cipher
 *  
 * Hints:
 *   A 27 element 1-D array (26 letters and the space character) can be used for the mapping
 *   where each element is the cipher text character corresponding to a particular letter.
 *  
 *   Given a String called myString you can create an array of characters as follows:
 *  	o   char[] characterArray = myString.toCharArray();
 *  
 *   To convert back to a String:
 *  	o  String anotherString = new String( characterArray );
 *  
 *   To convert a String to lower case:
 *  	o   String lowercaseString = myString.toLowerCase();
 */

import java.util.Random;
import java.util.Scanner;

public class Cipher
{
	
	public static final char[] ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ' };
	
	public static void main( String args[] )
	{
		char cipher[] = createCipher();
		Scanner inputScanner = new Scanner( System.in );
		boolean finished = false;
		while( !finished )
		{	
			System.out.print( "Do you want to encrypt, decrypt or quit?: " );
			if( inputScanner.hasNext( "encrypt" ) )
			{
				inputScanner.nextLine();
				System.out.print( "Enter your message to be encrypted: " );
				String message = inputScanner.nextLine();
				message = message.toLowerCase();
				char[] messageArray = message.toCharArray();
				System.out.println( "The encrypted message is: " + encrypt( messageArray, cipher ) );
				System.out.println( "" );
			}
			else if( inputScanner.hasNext( "decrypt" ) )
			{
				inputScanner.nextLine();
				System.out.print( "Enter your message to be decrypted: " );
				String message = inputScanner.nextLine();
				message = message.toLowerCase();
				char[] messageArray = message.toCharArray();
				System.out.println( "The decrypted message is: " + decrypt( messageArray, cipher ) );
				System.out.println( "" );
			}
			else if( inputScanner.hasNext( "quit" ) )
			{
				System.out.print( "Goodbye." );
				inputScanner.close();
				finished = true;
			}
			else
			{
				System.out.println( "Invalid input" );
				System.out.println( "" );
				inputScanner.nextLine();
			}	
		}
	}
	
	public static char[] createCipher()
	{
		char[] cipher = ALPHABET.clone();
		Random generator = new Random();
		for( int index = 0; index < cipher.length; index++ )
		{
			int otherIndex = generator.nextInt( cipher.length );
			char temp = cipher[index];
			cipher[index] = cipher[otherIndex];
			cipher[otherIndex] = temp;
		}
		return cipher;
	}
	
	public static String encrypt( char[] message, char[] cipher )
	{
		for( int index = 0; index < message.length; index++ )
		{
			char currentLetter = message[index];
			for( int otherIndex = 0; otherIndex < ALPHABET.length; otherIndex++ )
			{
				if( currentLetter == ALPHABET[otherIndex] )
				{
					message[index] = cipher[otherIndex];
				}
			}
		}
		return new String( message );
	}
	
	public static String decrypt( char[] message, char[] cipher )
	{
		for( int index = 0; index < message.length; index++ )
		{
			char currentLetter = message[index];
			for( int otherIndex = 0; otherIndex < cipher.length; otherIndex++ )
			{
				if( currentLetter == cipher[otherIndex] )
				{
					message[index] = ALPHABET[otherIndex];
				}
			}
		}
		return new String( message );
	}
	
}