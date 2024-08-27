// By: Shathviki Krishnaraj
// This is the assessment file input class. I used a Excel sheet (assessment.csv) to import the questions, possible 
// answers, and correct answers. I refer to this class in the question class & assessment class to print out the quiz on 
// the assessment screen. I used Mr.Fernandes' code from class as a guide here.

// Import all files from Java Scanner
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// This class holds the file input - it starts the array, inputs the data & goes through it, & creates variables to later
// access in other class 
public class AssessmentFileInput {

	// This Constructor uses the try & catch method for the data, inputs the data (questions & answers) from the file, & 
	// loops through it while creating the array 
	public AssessmentFileInput() {

		// Try & catch method for data
		try {

			// Inputs question & answer data from file
			Scanner input = new Scanner(new File("data/assessment.csv"));

			// Uses Delimiter to split up the lines
			input.useDelimiter(",|\r\n");

			// For loop that runs through each row of a question & potential answers
			for (int row = 0; row < Application.questionArray.length; row++) {

				// Variables - inputs each aspect of Laptop csv. into these
				// The question
				String question = input.next();
				// The 4 multiple choice buttons that the user can pick one of 
				String optionA = input.next();
				String optionB = input.next();
				String optionC = input.next();
				String optionD = input.next();
				// The correct character (A/B/C/D) is stored here
				char correct = input.next().charAt(0);

				// Create the array of the survey data 
				Application.questionArray[row] = new Question(question, optionA, optionB, optionC, optionD, correct);
			}

			// Close the file
			input.close();

			// Check for errors
		} catch (FileNotFoundException event) {

			// If there is an error, print this so we can error check & determine what is wrong
			System.out.println("File Error");
		}
	}
}
