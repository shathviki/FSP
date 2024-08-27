// By: Shathviki Krishnaraj
// This is the main menu screen. It holds three buttons that take the user to the concepts screen, activity screen, and 
// assessment screen. The font and background images were taken from Canva. 

// Java Swing Imports that I used 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// This class is called Main Menu Screen - it holds all the labels & buttons that display the main menu page and 
// takes the user to the other pages 
public class MainMenuScreen extends JFrame implements ActionListener {

	// GUI elements - background label & buttons
	JLabel mainMenuImagesLabel = new JLabel(new ImageIcon("images/mainMenuBackground.png"));
	JButton conceptsButton = new JButton("Concepts");
	JButton activityButton = new JButton("Activity");
	JButton assessmentButton = new JButton("Assessment");

	// This is the constructor - Main Menu Screen. It holds the screen elements (Labels & Buttons)
	public MainMenuScreen() {

		// Set the frame
		setLayout(null);

		// Set the title
		setTitle("Main Menu Screen");

		// Set the bounds
		mainMenuImagesLabel.setBounds(-325, -470, 1920, 1680);

		// Add the background
		add(mainMenuImagesLabel);

		// Size of program frame
		setSize(1920, 1080);

		// Set to visible
		setVisible(true);

		// Set concepts button - set bounds, font, background colour, font colour, opacity, focusable, border paint
		conceptsButton.setBounds(600, 1030, 150, 60);
		conceptsButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		conceptsButton.setBackground(Color.WHITE);
		conceptsButton.setForeground(new Color(0, 51, 25));
		conceptsButton.setOpaque(true);
		conceptsButton.setFocusable(false);
		conceptsButton.setBorderPainted(false);

		// Add the concepts button to the screen
		conceptsButton.addActionListener(this);
		mainMenuImagesLabel.add(conceptsButton);

		// Set activity button - set bounds, font, background colour, font colour, opacity, focusable, border paint
		activityButton.setBounds(900, 1030, 150, 60);
		activityButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		activityButton.setBackground(Color.WHITE);
		activityButton.setForeground(new Color(0, 51, 25));
		activityButton.setOpaque(true);
		activityButton.setFocusable(false);
		activityButton.setBorderPainted(false);

		// Add the activity button to the screen
		activityButton.addActionListener(this);
		mainMenuImagesLabel.add(activityButton);

		// Set assessment button - set bounds, font, background colour, font colour, opacity, focusable, border paint
		assessmentButton.setBounds(1200, 1030, 150, 60);
		assessmentButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		assessmentButton.setBackground(Color.WHITE);
		assessmentButton.setForeground(new Color(0, 51, 25));
		assessmentButton.setOpaque(true);
		assessmentButton.setFocusable(false);
		assessmentButton.setBorderPainted(false);

		// Add the assessment button to the screen
		assessmentButton.addActionListener(this);
		mainMenuImagesLabel.add(assessmentButton);
	}

	// This method handles the action of clicking on the buttons (concepts, activity, assessment)
	public void actionPerformed(ActionEvent event) {

		// Connects buttons to different pages
		// If user clicks concepts, take them to that page & dispose of main menu screen
		if (event.getSource() == conceptsButton) {
			new ConceptsScreen();
			dispose();
		}

		// If user clicks activity, take them to that page & dispose of main menu screen
		else if (event.getSource() == activityButton) {
			new ActivityScreen();
			dispose();
		}

		// If user clicks assessment, take them to that page & dispose of main menu
		// screen
		else if (event.getSource() == assessmentButton) {
			new AssessmentScreen();
			dispose();
		}
	}

}
