/* Name: Shathviki Krishnaraj  
Date: January 20, 2023
Course Code: ICS3U1-02. Mr.Fernandes
Title: Final Summative Project - Methods 

Description: This project is a website containing content regarding the topic of "Methods". There are buttons to 
				navigate among the 4 pages: main menu screen, concepts screen, activity screen, and the assessment 
				screen. The concepts page teaches the user some key terms about methods and teaches them how to use
				it. There are also buttons that link to external webpages. The activity screen is a game of jeopardy.
				There are true & false questions, terms questions, and fill in the blank questions. These allow users
				to practice what they know about the basics of methods and allows them to get accustomed to the key
				terms. Afterwards, the assessment screen has 10 questions, regarding terms, basics, and a "fill in the
				code" 

Features: 
   	- Using Java Net URL (the content page buttons link to web pages) 
   	- Using HTML to style the scroll panes of "terms" & "how to use" in the content screen 
		- I styled font size & colour, and added images 
   	
   	- Using audio (there is intro music to the activity & assessment page!)
   	- Using file input and a question class to create the assessment screen 
   	- Created a jeopardy game for the activity screen

Major Skills: 
   	- Methods
   	- Arrays
   	- Classes
   	- Constructors, get and set methods
   	- Conditional statements
   	- For loops & while loops 
   	- Using audio
   	- Swing GUI components 
   	- JButton, JFrame, JOptionPane, JLabel, JPanel, JRadioButton (also JColor, JFont, other styling), JScrollPane, 
   		ActionListener, JTextArea, ButtonGroups

Areas of Concern:
 	- Concepts Screen: The "How to Use" scroll pane works (I can scroll down to view the content), but the actual 
   					scroll pane bar does not show up. I have the same issue with the image in the assessment pane.
   	- Assessment Screen: The frame of the question goes "past" the content (the scroll pane is too long).
   	- The score of the activity does not update properly (depending on the order in which the user presses the buttons)
*/

// This class runs the other files - the main menu, concepts, activity, & assessment screen 
public class Application {

	// This holds the question array that we use in the assessment frame to print out each of the questions
	public static Question[] questionArray = new Question[11];

	// Main method - runs the files
	public static void main(String[] args) {
		
		new AssessmentFileInput();
		
		//new ExternalSite();
		
		new MainMenuScreen(); 
		
		//new ConceptsScreen();
		
		//new ActivityScreen();
		
		//new AssessmentScreen();
		
	}
	
}
