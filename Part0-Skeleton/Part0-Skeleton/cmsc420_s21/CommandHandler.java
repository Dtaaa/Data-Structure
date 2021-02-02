package cmsc420_s21;

// YOU SHOULD NOT MODIFY THIS FILE

import java.util.Scanner;

/**
 * Command handler. This reads a single command line, processes the command (by
 * invoking the appropriate method(s) on the data structure), and returns the
 * result as a string.
 */

public class CommandHandler {

	Tour<Airport> tour; // the tour data structure

	/**
	 * Default constructor.
	 */
	public CommandHandler() {
		tour = new Tour<Airport>(); // initialize the tour data structure
	}

	/**
	 * Process a single command and return the string output. Each command begins
	 * with a command followed by a list of arguments. The arguments are separated
	 * by colons (":").
	 * 
	 * @param inputLine The input line with the command and parameters.
	 * @return A string summary of the command's execution/result.
	 */
	public String processCommand(String inputLine) {
		Scanner line = new Scanner(inputLine);
		line.useDelimiter(":"); // use ":" to separate arguments
		String output = new String(); // for storing summary output
		String cmd = (line.hasNext() ? line.next() : ""); // next command
		try {
			// -----------------------------------------------------
			// APPEND code name city country x y
			// - append the given city to the tour
			// -----------------------------------------------------
			if (cmd.compareTo("append") == 0) {
				String code = line.next(); // read airport code
				String name = line.next(); // read name
				String city = line.next(); // read city
				String country = line.next(); // read country
				float x = line.nextFloat(); // read x (longitude)
				float y = line.nextFloat(); // read y (latitude)
				Airport ap = new Airport(code, name, city, country, x, y); // create airport object
				output += tour.append(ap) + System.lineSeparator(); // add to 2-Opt structure
			}
			// -----------------------------------------------------
			// LIST-TOUR
			// - list the current tour
			// -----------------------------------------------------
			else if (cmd.compareTo("list-tour") == 0) {
				output += tour.listTour() + System.lineSeparator();
			}
			// -----------------------------------------------------
			// LIST-LABELS
			// - list the airports in the tour and position
			// -----------------------------------------------------
			else if (cmd.compareTo("list-labels") == 0) {
				output += tour.listLabels() + System.lineSeparator();
			}
			// -----------------------------------------------------
			// INDEX-OF code
			// - index of airport in tour
			// -----------------------------------------------------
			else if (cmd.compareTo("index-of") == 0) {
				String code = line.next(); // airport
				output += tour.indexOf(code) + System.lineSeparator();

			}
			// -----------------------------------------------------
			// REVERSE code1 code2
			// - reverses the sub-tour from code1 to code2
			// -----------------------------------------------------
			else if (cmd.compareTo("reverse") == 0) {
				String code1 = line.next(); // first airport
				String code2 = line.next(); // second airport
				output += tour.reverse(code1, code2) + System.lineSeparator();
			}
			// -----------------------------------------------------
			// Unrecognized command
			// -----------------------------------------------------
			else {
				if (cmd.compareTo("") == 0)
					System.err.println("Error: Empty command line (Ignored)");
				else
					System.err.println("Error: Invalid command - \"" + cmd + "\" (Ignored)");
			}
			line.close();
		} catch (Exception | Error e) {
			output = "Unexpected error occurred while running your program: " + e.getMessage() + System.lineSeparator();
			System.err.println("Unexpected error occurred while running your program: " + e.getMessage());
			e.printStackTrace(System.err);
		}
		return output; // return summary output
	}
}
