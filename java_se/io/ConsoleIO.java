package io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleIO {

	public static void consoleOutput() {
		// Outputting to the console.
		
		System.out.println("Message output");
		System.err.println("Error output");
		
		// Logger is used to organize Console output via Levels.
		Logger logger = Logger.getAnonymousLogger();
		logger.log(Level.INFO, "Random message.");
		
		/*
		 * Levels mark the severity of the log:
		 * 
		 * OFF, FINEST, FINER, FINE, CONFIG, INFO, WARNING, SEVERE, ALL.
		 * 
		 * Least important --> Most important.
		 */
		
	}
	
	public static void consoleInput() {

		// Prompting the user for input via the console.
		try {

			System.out.print("Input (InputStreamReader): ");
			InputStreamReader consoleInp = new InputStreamReader(System.in, "UTF-8");
			// Prompts the user only once.

			int intRead = consoleInp.read();
			// Reads a char, returns encoding scheme value, and advances the cursor.

			System.out.println("Output (InputStreamReader): " + intRead + "\n");

			// Scanner is used to read text.
			try (Scanner scanInp = new Scanner(System.in)) {

				System.out.print("Input (Scanner): ");

				String textEntered = scanInp.next();
				// Reads (and returns) a word at a time, and advances the cursor.

				String quitKeyword = "end";

				while (!(textEntered.equals(quitKeyword)) && scanInp.hasNext()) {
					System.out.println("Output (Scanner): " + textEntered);
					textEntered = scanInp.next();
					/*
					 * Once the end of the input from .next is reached, the scanner object asks for
					 * input from the console again.
					 */
				}

			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		consoleInput();
	}
}
