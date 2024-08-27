// By: Shathviki Krishnaraj
// This is the activity screen. The game is jeopardy! There is intro music at the start. There are 3 rows, with 
// multiple choice, fill in the blank, and term questions. The code checks whether or not the answer is correct, 
// then displays an appropriate message. There is also a score variable that updates the score periodically. 

// The Java Swing imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

// This class holds my sound string, variable, image icons frame & labels, as well as the panels & arrays that store all the question
public class ActivityScreen extends JFrame implements ActionListener {

	// Source that I used for the activity:
	// http://ibcomp.fis.edu/Strings/Jeopardy.html

	// This String holds the sound that we later use in the method to play Jeopardy music 
	String sound = "sounds/jeopardyMusic.wav";

	// GUI elements - frame, background label & buttons
	JFrame activityFrame = new JFrame();
	JLabel activityImagesLabel = new JLabel(new ImageIcon("images/activityBackground.png"));
	JLabel jeopardyImageLabel = new JLabel(new ImageIcon("images/jeopardy.png"));

	// Everything necessary for basics
	// This panel will display the questions when they are pressed 
	JPanel questionPanel = new JPanel();

	// This array holds all the statements for the basics row of the activity 
	String basicsStatementArray[] = new String[5];
	{
		basicsStatementArray[0] = "A method is a block of code which only runs when it is called"; // True
		basicsStatementArray[1] = "Methods use parameters OR arguments"; // False
		basicsStatementArray[2] = "An argument is a way to provide more information to a function"; // True
		basicsStatementArray[3] = "Pop adds an element to a collection"; // False
		basicsStatementArray[4] = "Constants change every time a program is executed"; // False
	}

	// This array holds the answers for the basics row - so we can compare it to the user input & check if it is correct 
	int[] basicsAnswerArray = { 0, 1, 0, 1, 1 };

	// This label holds the statement for the basics question 
	JLabel statementLabel = new JLabel();
	
	// This button group & array holds the buttons for the responses of the basics' question
	// The options are "true" or "false"
	ButtonGroup guessButtonGroup1 = new ButtonGroup();
	JRadioButton[] guessArray = new JRadioButton[2];
	
	// Variable - used for guesses that the user writes (when we compare it to what's in our data base)
	private String guess;

	// Everything necessary for terms
	// This array holds all the statements for the terms row of the activity 
	String guessTermsArray[] = new String[5];
	{
		guessTermsArray[0] = "The Java keyword __________ is used to make an item belong to a class rather than an instance of the class";
		guessTermsArray[1] = "The best way to develop and maintain a large program is to use a __________ design";
		guessTermsArray[2] = " __________ is used to convert a value from one data type to another";
		guessTermsArray[3] = "The method call ____________ is a structure that stores active methods in the main memory using the LIFO principle";
		guessTermsArray[4] = "A __________ is a variable that accepts values into a method";
	}
	
	// This array holds the answers for the terms  row - so we can compare it to the user input & check if it is correct 
	String termsAnswerArray[] = new String[5];
	{
		termsAnswerArray[0] = "static";
		termsAnswerArray[1] = "modular";
		termsAnswerArray[2] = "casting";
		termsAnswerArray[3] = "stack";
		termsAnswerArray[4] = "parameter";
	}

	// Everything necessary for fill in the blank
	// This array holds all the statements for the fill in the blank row of the activity 
	String guessFillArray[] = new String[5];
	{
		guessFillArray[0] = "C_n_st_ _ts are data values that remain the same every time a program is executed\n"
				+ "[Type in full term]";
		guessFillArray[1] = "J_v_a  A_ _ is a collection of prewritten packages, classes & interfaces with"
				+ " their respective methods, fields & constructors (ex. javax.swing, java.util.Scanner)\n"
				+ "[Type in full term]";
		guessFillArray[2] = "S_ _ pe is a concept that refers to where methods, variables, values & functions can be"
				+ "accessed (private/public, global &  local)\n" + "[Type in full term]";
		guessFillArray[3] = "F_ _al is a keyword used to define an entity that cannot be changed nor derived from later"
				+ "[Type in full term]";
		guessFillArray[4] = "C_nc_aten_ _ _ _ n is the operation of joining two strings together\r\n"
				+ "[Type in full term]";
	}

	// This array holds the answers for the fill in the blank  row - so we can compare it to the user input & check if it is correct 
	String fillAnswerArray[] = new String[5];
	{
		fillAnswerArray[0] = "constants";
		fillAnswerArray[1] = "java api";
		fillAnswerArray[2] = "scope";
		fillAnswerArray[3] = "final";
		fillAnswerArray[4] = "concatenation";
	}

	// Toolbar buttons - to navigate users to the other pages 
	JButton mainMenuButton = new JButton("Main Menu");
	JButton conceptsButton = new JButton("Concepts");
	JButton assessmentButton = new JButton("Assessment");

	// Variable - keeps ongoing track of the score
	public static int score;
	// JLabel - Displays the score & updates it periodically 
	static JLabel ScoreLabel = new JLabel("Score: " + Integer.toString(score));

	// Variables - These integers are used to determine how many questions of each array the user has answered 
	private int currentQuestionNumber; //basics
	private int currentQuestionNumber1; //terms
	private int currentQuestionNumber2; //fill in the blank 
	
	// Variable - to check if the user wants to play again when they are done 
	int again = 0;

	// The ImageIcons hold the images that will display in the JOptionPane when the user gets a question correct/incorrect 
	// Source: https://www.youtube.com/watch?v=Gy3odNyYzhg
	ImageIcon smileyIcon = new ImageIcon("images/smiley.jpg");
	ImageIcon wiltedIcon = new ImageIcon("images/wilted.jpg");

	// Buttons - for basics & corresponding label
	JLabel basicsLabel = new JLabel("Basics");
	JButton basics100Button = new JButton("$100");
	JButton basics200Button = new JButton("$200");
	JButton basics300Button = new JButton("$300");
	JButton basics400Button = new JButton("$400");
	JButton basics500Button = new JButton("$500");

	// Buttons - for terms & corresponding label
	JLabel termsLabel = new JLabel("Terms");
	JButton terms100Button = new JButton("$100");
	JButton terms200Button = new JButton("$200");
	JButton terms300Button = new JButton("$300");
	JButton terms400Button = new JButton("$400");
	JButton terms500Button = new JButton("$500");

	// Buttons - for "fill in the blank" & corresponding label
	JLabel fillLabel = new JLabel("Fill in the Blank");
	JButton fill100Button = new JButton("$100");
	JButton fill200Button = new JButton("$200");
	JButton fill300Button = new JButton("$300");
	JButton fill400Button = new JButton("$400");
	JButton fill500Button = new JButton("$500");

	// Constructor - this sets up the frame, and adds all the components (panels, labels, buttons)
	public ActivityScreen() {

		// Size of program frame
		setSize(1920, 1080);
		// Set the title
		setTitle("Activity Screen");
		// Set the frame
		setLayout(null);
		// Close when exited
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set to visible
		setVisible(true);

		// Set the bounds of the background
		activityImagesLabel.setBounds(-325, -470, 1920, 1680);
		// Add the background
		add(activityImagesLabel);

		// Set the bounds of the jeopardy image
		jeopardyImageLabel.setBounds(-440, 30, 1920, 1680);
		// Add it to the existing image 
		activityImagesLabel.add(jeopardyImageLabel);

		// Set question panel - bounds, background colour & add it
		questionPanel.setBounds(1175, 725, 400, 300);
		questionPanel.setBackground(new Color(0, 51, 25));
		activityImagesLabel.add(questionPanel);

		// Set main menu button - set bounds, font, background colour, font colour
		mainMenuButton.setBounds(1260, 475, 100, 60);
		mainMenuButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mainMenuButton.setBackground(new Color(0, 51, 25));
		mainMenuButton.setForeground(Color.WHITE);
		mainMenuButton.setOpaque(true);
		mainMenuButton.setFocusable(false);
		mainMenuButton.setBorderPainted(false);
		// Add the main menu button to the screen
		mainMenuButton.addActionListener(this);
		activityImagesLabel.add(mainMenuButton);
		
		// Set concepts button - set bounds, font, background colour, font colour
		conceptsButton.setBounds(1370, 475, 100, 60);
		conceptsButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		conceptsButton.setBackground(new Color(0, 51, 25));
		conceptsButton.setForeground(Color.WHITE);
		conceptsButton.setOpaque(true);
		conceptsButton.setFocusable(false);
		conceptsButton.setBorderPainted(false);
		// Add the concepts button to the screen
		conceptsButton.addActionListener(this);
		activityImagesLabel.add(conceptsButton);
		
		// Set assessment button - set bounds, font, background colour, font colour
		assessmentButton.setBounds(1480, 475, 100, 60);
		assessmentButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		assessmentButton.setBackground(new Color(0, 51, 25));
		assessmentButton.setForeground(Color.WHITE);
		assessmentButton.setOpaque(true);
		assessmentButton.setFocusable(false);
		assessmentButton.setBorderPainted(false);
		// Add the assessment button to the screen
		assessmentButton.addActionListener(this);
		activityImagesLabel.add(assessmentButton);

		// Set the basics label & add it to screen
		basicsLabel.setBounds(755, 670, 100, 60);
		basicsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		basicsLabel.setForeground(new Color(0, 51, 25));
		activityImagesLabel.add(basicsLabel);
		// Set the basics 100 button & add it to screen
		basics100Button.setBounds(706, 725, 150, 60);
		basics100Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		basics100Button.setBackground(Color.WHITE);
		basics100Button.setForeground(new Color(0, 51, 25));
		basics100Button.addActionListener(this);
		activityImagesLabel.add(basics100Button);
		// Set the basics 200 button & add it to screen
		basics200Button.setBounds(706, 785, 150, 60);
		basics200Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		basics200Button.setBackground(Color.WHITE);
		basics200Button.setForeground(new Color(0, 51, 25));
		basics200Button.addActionListener(this);
		activityImagesLabel.add(basics200Button);
		// Set the basics 300 button & add it to screen
		basics300Button.setBounds(706, 845, 150, 60);
		basics300Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		basics300Button.setBackground(Color.WHITE);
		basics300Button.setForeground(new Color(0, 51, 25));
		basics300Button.addActionListener(this);
		activityImagesLabel.add(basics300Button);
		// Set the basics 400 button & add it to screen
		basics400Button.setBounds(706, 905, 150, 60);
		basics400Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		basics400Button.setBackground(Color.WHITE);
		basics400Button.setForeground(new Color(0, 51, 25));
		basics400Button.addActionListener(this);
		activityImagesLabel.add(basics400Button);
		// Set the basics 500 button & add it to screen
		basics500Button.setBounds(706, 965, 150, 60);
		basics500Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		basics500Button.setBackground(Color.WHITE);
		basics500Button.setForeground(new Color(0, 51, 25));
		basics500Button.addActionListener(this);
		activityImagesLabel.add(basics500Button);

		// Set the terms label & add it to screen
		termsLabel.setBounds(905, 670, 100, 60);
		termsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		termsLabel.setForeground(new Color(0, 51, 25));
		activityImagesLabel.add(termsLabel);
		// Set the terms 100 button & add it to screen
		terms100Button.setBounds(855, 725, 150, 60);
		terms100Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		terms100Button.setBackground(Color.WHITE);
		terms100Button.setForeground(new Color(0, 51, 25));
		terms100Button.addActionListener(this);
		activityImagesLabel.add(terms100Button);
		// Set the terms 200 button & add it to screen
		terms200Button.setBounds(855, 785, 150, 60);
		terms200Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		terms200Button.setBackground(Color.WHITE);
		terms200Button.setForeground(new Color(0, 51, 25));
		terms200Button.addActionListener(this);
		activityImagesLabel.add(terms200Button);
		// Set the terms 300 button & add it to screen
		terms300Button.setBounds(855, 845, 150, 60);
		terms300Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		terms300Button.setBackground(Color.WHITE);
		terms300Button.setForeground(new Color(0, 51, 25));
		terms300Button.addActionListener(this);
		activityImagesLabel.add(terms300Button);
		// Set the terms 400 button & add it to screen
		terms400Button.setBounds(855, 905, 150, 60);
		terms400Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		terms400Button.setBackground(Color.WHITE);
		terms400Button.setForeground(new Color(0, 51, 25));
		terms400Button.addActionListener(this);
		activityImagesLabel.add(terms400Button);
		// Set the terms 500 button & add it to screen
		terms500Button.setBounds(855, 965, 150, 60);
		terms500Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		terms500Button.setBackground(Color.WHITE);
		terms500Button.setForeground(new Color(0, 51, 25));
		terms500Button.addActionListener(this);
		activityImagesLabel.add(terms500Button);

		// Set the fill label & add it to screen
		fillLabel.setBounds(1027, 670, 100, 60);
		fillLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fillLabel.setForeground(new Color(0, 51, 25));
		activityImagesLabel.add(fillLabel);
		// Set the fill 100 button & add it to screen
		fill100Button.setBounds(1004, 725, 150, 60);
		fill100Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fill100Button.setBackground(Color.WHITE);
		fill100Button.setForeground(new Color(0, 51, 25));
		fill100Button.addActionListener(this);
		activityImagesLabel.add(fill100Button);
		// Set the fill 200 button & add it to screen
		fill200Button.setBounds(1004, 785, 150, 60);
		fill200Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fill200Button.setBackground(Color.WHITE);
		fill200Button.setForeground(new Color(0, 51, 25));
		fill200Button.addActionListener(this);
		activityImagesLabel.add(fill200Button);
		// Set the fill 300 button & add it to screen
		fill300Button.setBounds(1004, 845, 150, 60);
		fill300Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fill300Button.setBackground(Color.WHITE);
		fill300Button.setForeground(new Color(0, 51, 25));
		fill300Button.addActionListener(this);
		activityImagesLabel.add(fill300Button);
		// Set the fill 400 button & add it to screen
		fill400Button.setBounds(1004, 905, 150, 60);
		fill400Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fill400Button.setBackground(Color.WHITE);
		fill400Button.setForeground(new Color(0, 51, 25));
		fill400Button.addActionListener(this);
		activityImagesLabel.add(fill400Button);
		// Set the fill 500 button & add it to screen
		fill500Button.setBounds(1004, 965, 150, 60);
		fill500Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fill500Button.setBackground(Color.WHITE);
		fill500Button.setForeground(new Color(0, 51, 25));
		fill500Button.addActionListener(this);
		activityImagesLabel.add(fill500Button);

		// Add the statement label - set the bounds, font, colour, & add it to the screen
		statementLabel.setBounds(150, 730, 500, 300);
		statementLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		statementLabel.setForeground(Color.WHITE);
		questionPanel.add(statementLabel);

		// Set the radio button texts & add the action listener so we can record the actions & show a message accordingly
		guessArray[0] = new JRadioButton("True");
		guessArray[0].addActionListener(this);
		guessArray[1] = new JRadioButton("False");
		guessArray[1].addActionListener(this);

		// Score: Label - set bounds, font, colour
		ScoreLabel.setBounds(1490, 665, 100, 100);
		ScoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		ScoreLabel.setForeground(Color.BLACK);
		// Add the score label to the screen
		activityImagesLabel.add(ScoreLabel);

		// Calls the methods that plays the intro music 
		PlayActivityMusic(sound);

		// Add all components to the screen
		setVisible(true);
	}

	// If a specific action is performed (going to menu, pressing on a question button (and the true & false buttons if applicable)
	// display the correlating action
	@Override
	public void actionPerformed(ActionEvent event) {

		// If user clicks main menu, concepts, or assessment page,
		// take them to that page & dispose of activity screen
		if (event.getSource() == mainMenuButton) {
			new MainMenuScreen();
			dispose();
		} else if (event.getSource() == conceptsButton) {
			new ConceptsScreen();
			dispose();
		} else if (event.getSource() == assessmentButton) {
			new AssessmentScreen();
			dispose();

		// If the user presses basics 100 & so on, the method with that question will open & the button will be disabled
		} else if (event.getSource() == basics100Button) {
			basics();
			basics100Button.setEnabled(false);
		} else if (event.getSource() == basics200Button) {
			basics();
			basics200Button.setEnabled(false);
		} else if (event.getSource() == basics300Button) {
			basics();
			basics300Button.setEnabled(false);
		} else if (event.getSource() == basics400Button) {
			basics();
			basics400Button.setEnabled(false);
		} else if (event.getSource() == basics500Button) {
			basics();
			basics500Button.setEnabled(false);

		// If the user presses terms 100 & so on, the method with that question will open & the button will be disabled
		} else if (event.getSource() == terms100Button) {
			terms();
			terms100Button.setEnabled(false);
		} else if (event.getSource() == terms200Button) {
			terms();
			terms200Button.setEnabled(false);
		} else if (event.getSource() == terms300Button) {
			terms();
			terms300Button.setEnabled(false);
		} else if (event.getSource() == terms400Button) {
			terms();
			terms400Button.setEnabled(false);
		} else if (event.getSource() == terms500Button) {
			terms();
			terms500Button.setEnabled(false);

		// If the user presses fill 100 & so on, the method with that question will open & the button will be disabled
		} else if (event.getSource() == fill100Button) {
			fill();
			fill100Button.setEnabled(false);
		} else if (event.getSource() == fill200Button) {
			fill();
			fill200Button.setEnabled(false);
		} else if (event.getSource() == fill300Button) {
			fill();
			fill300Button.setEnabled(false);
		} else if (event.getSource() == fill400Button) {
			fill();
			fill400Button.setEnabled(false);
		} else if (event.getSource() == fill500Button) {
			fill();
			fill500Button.setEnabled(false);
		}

		// If all the buttons are disabled, then the user is complete the game!
		if (!basics100Button.isEnabled() && !basics200Button.isEnabled() && !basics300Button.isEnabled()
				&& !basics400Button.isEnabled() && !basics500Button.isEnabled() && !terms100Button.isEnabled()
				&& !terms200Button.isEnabled() && !terms300Button.isEnabled() && !terms400Button.isEnabled()
				&& !terms500Button.isEnabled() && !fill100Button.isEnabled() && !fill200Button.isEnabled()
				&& !fill300Button.isEnabled() && !fill400Button.isEnabled() && !fill500Button.isEnabled()) {

			// Displays the user's final score & asks them if they want to play again 
			again = JOptionPane.showConfirmDialog(this, (String.format("Your score is " + score + "\nTry again?")),
					"Try Again?", JOptionPane.YES_NO_OPTION);
			// If yes, dispose the screen and open a new one
			if (again == JOptionPane.YES_OPTION) {
				dispose();
				new ActivityScreen();
			// If not, go back to the main screen 
			} else {
				dispose();
				new MainMenuScreen();
			}
		}

		// If the user presses true or false, calls the method to check their answer against the correct one 
		if (event.getSource() == guessArray[0])
			checkBasicsAnswer(0);
		else if (event.getSource() == guessArray[1])
			checkBasicsAnswer(1);
	}

	// Method - basics - opens when user presses on that question & allows them to pick true/false
	public void basics() {

		// Displaying the radio buttons for question
		for (int index = 0; index < guessArray.length; index++) {

			// Add the buttons to a group
			guessButtonGroup1.add(guessArray[index]);

			// Position and add the radio buttons to the background (bounds, font, background, foreground, etc)
			guessArray[index].setBounds(1050, 900, 300, 300);
			guessArray[index].setFont(new Font("Times New Roman", Font.PLAIN, 15));
			guessArray[index].setBackground(new Color(0, 51, 25));
			guessArray[index].setForeground(Color.WHITE);
			guessArray[index].setOpaque(true);
			guessArray[index].setFocusable(false);
			questionPanel.add(guessArray[index]);
		}

		// Set the statement label text to that of the current question 
		statementLabel.setText(basicsStatementArray[currentQuestionNumber] + "\n");
	}

	// Method - checks the user's answer for basics against the correct one
	public void checkBasicsAnswer(int choice) {

		// If the answer is correct, add to the score & display a corresponding message 
		if (choice == basicsAnswerArray[currentQuestionNumber]) {
			score += (currentQuestionNumber * 100);
			JOptionPane.showMessageDialog(null, "Correct!", "Results", JOptionPane.INFORMATION_MESSAGE, smileyIcon);
		// Otherwise, subtract 100 & display corresponding message
		} else {
			score -= (currentQuestionNumber + 1) * 100;
			JOptionPane.showMessageDialog(null, "Incorrect!", "Results", JOptionPane.INFORMATION_MESSAGE, wiltedIcon);
		}
		//Add to the current question number to keep track & update the current score
		currentQuestionNumber++;
		currentScore(score);
	}

	// Method - terms - opens when user presses on that question & allows them to enter their input with the JOPtionPane
	public void terms() {
		guess = JOptionPane.showInputDialog(guessTermsArray[currentQuestionNumber1]);
		// Call the method that checks the answer & pass on the guess as a parameter 
		checkTermsAnswer(guess);
	}

	// Method - checks the user's answer for terms against the correct one
	public void checkTermsAnswer(String guess) {
		// If the answer is correct (there is entered to begin with), 
		// add to the score & display a corresponding message 		
		if (guess != null && guess.equalsIgnoreCase(termsAnswerArray[currentQuestionNumber1])) {
			score += (currentQuestionNumber1 + 1) * 100;
			JOptionPane.showMessageDialog(null, "Correct!", "Results", JOptionPane.INFORMATION_MESSAGE, smileyIcon);
		// Otherwise, subtract 100 & display corresponding message
		} else {
			score -= (currentQuestionNumber1 + 1) * 100;
			JOptionPane.showMessageDialog(null, "Incorrect!", "Results", JOptionPane.INFORMATION_MESSAGE, wiltedIcon);
		}
		//Add to the current question number to keep track & update the current score
		currentQuestionNumber1++;
		currentScore(score);
	}

	// Method - fill in the blank - opens when user presses on that question & allows them to enter their input with the JOPtionPane
	public void fill() {
		guess = JOptionPane.showInputDialog(guessFillArray[currentQuestionNumber2]);
		// Call the method that checks the answer & pass on the guess as a parameter 
		checkfillAnswer(guess);
	}

	// Method - checks the user's answer for fill in the blank against the correct one
	public void checkfillAnswer(String guess) {

		// If the answer is correct (there is entered to begin with), 
		// add to the score & display a corresponding message 
		if (guess != null && guess.equalsIgnoreCase(fillAnswerArray[currentQuestionNumber2])) {
			score += (currentQuestionNumber2 + 1) * 100;
			JOptionPane.showMessageDialog(null, "Correct!", "Results", JOptionPane.INFORMATION_MESSAGE, smileyIcon);
		// Otherwise, subtract 100 & display corresponding message
		} else {
			score -= (currentQuestionNumber2 + 1) * 100;
			JOptionPane.showMessageDialog(null, "Incorrect!", "Results", JOptionPane.INFORMATION_MESSAGE, wiltedIcon);
		}
		//Add to the current question number to keep track & update the current score
		currentQuestionNumber2++;
		currentScore(score);
	}

	// Method - takes in the score as an argument and updates the score periodically by setting the text 
	public static void currentScore(int score) {
		ScoreLabel.setText("Score: " + score);
	}

	// Method - this method plays the intro music!
	private void PlayActivityMusic(String sound) {

		// Use try and catch for errors
		try {
			File path = new File(sound);

			// If the path exists, play the audio (get, open and start it)
			if (path.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			// Error message in case we cannot find the file 
			} else {
				System.out.println("Can't find file ");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}