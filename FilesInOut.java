import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String inputFileName = "";
	    String outputFileName = "";
	    File inputFile = null;
	    File outputFile = null;
	    boolean validInputFile = false;
	    boolean validOutputFile = false;
	    while (!validInputFile) {
	        System.out.print("Please enter input file name with the extension: ");
	        inputFileName = scanner.nextLine();
	        inputFile = new File(inputFileName);
	        if (inputFile.exists()) {
	            validInputFile = true;
	        } else {
	            System.out.println("Please enter a valid input file(.txt) or check if its in the root directory as this code");
	        }
	    }
	    while (!validOutputFile) {
	        System.out.print("Please enter output file name with the extension: ");
	        outputFileName = scanner.nextLine();
	        outputFile = new File(outputFileName);
	        if (outputFile.exists()) {
	            System.out.print("Output file already exists, do you want to overwrite it? (y/n) ");
	            String response = scanner.nextLine();
	            if (response.equalsIgnoreCase("y")) {
	                validOutputFile = true;
	            }
	        } else {
	            validOutputFile = true;
	        }
	    }
	    try {
	        Scanner fileScanner = new Scanner(inputFile);
	        PrintWriter writer = new PrintWriter(outputFile);
	        while (fileScanner.hasNextLine()) {
	            String line = fileScanner.nextLine();
	            String[] parts = line.split(" ");
	            String formattedName = "";
	            for (String part : parts) {
	                formattedName += part.substring(0, 1).toUpperCase() + part.substring(1) + " ";
	            }
	            String formattedDate = parts[parts.length - 1].substring(0, 2) + "/" + parts[parts.length - 1].substring(2, 4) + "/" + parts[parts.length - 1].substring(4);
	            formattedName = formattedName.trim();
	            if (args.length > 0 && args[0].equals("-u")) {
	                formattedName = formattedName.toUpperCase();
	            }
	            writer.println(formattedName + "\t" + formattedDate);
	        }
	        fileScanner.close();
	        writer.close();
	        System.out.println("Corrected names have been written to the file name: " + outputFileName);
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("Error while creating the file: " + e.getMessage());
	    }
	} // main
} // FilesInOut
