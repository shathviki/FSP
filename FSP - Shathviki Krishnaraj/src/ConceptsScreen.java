// By: Shathviki Krishnaraj
// This is the concepts screen. There are three buttons at the corner that lead to the main menu, activity, and assessments 
// screens respectively. Below that, when the user presses the "Terms" and "How to Use" Buttons, the scroll pane fills up with HTML
// text. Below that there are buttons that link to external websites, for further information. 

// Java Swing Imports that I used 
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

// This class holds my background color, the String of HTML, background labels, buttons, textpanes, and scrollpanes that I used
public class ConceptsScreen extends JFrame implements ActionListener {

	// I created a custom colour that matched my theme 
	public static final Color green = new Color(224, 241, 156);
	
	// This  holds the terms in HTML. I used HTML to accessorize font, aligns, decorations (underline, bold, italics), and colour 
	// schemeing with ease. I used paragraphs, orders & unordered lists, heading tags, and added images. 
	// Source: https://docs.oracle.com/javase/tutorial/uiswing/components/html.html
	
	// This String holds the terms regarding methods 
	public static final String termsHTML = "<html>"
			+ "<style> p{font-family: Garamond; text-align: center; font-size: 16px; text-decoration: underline;} </style>"
			+ "<style> ul{font-family: Garamond; color:purple; text-align: left; font-size: 15px;} </style>"
			+ "<p style=\"color:green\">A method is a block of code which only runs when it is called.</p><br>" + "<ul>"
			+ "<li><b>Enumeration:</b> A symbolic name for a set of values (months/years) </li>"
			+ "<li><b>Constant:</b> Data values that remain the same every time a program is executed</li>"
			+ "<li><b>Java API:</b> A collection of prewritten packages, classes & interfaces with their respective methods, fields & constructors (ex. javax.swing, java.util.Scanner)</li>"
			+ "<li><b>Scope:</b>  a concept that refers to where methods, variables, values & functions can be accessed (private or public, global and local)</li>"
			+ "<li><b>Static:</b> The Java keyword used to make an item belong to a class rather than an instance of the class</li>"
			+ "<li><b>Modular:</b> Using this design is the best way to develop & maintain a large program</li>"
			+ "<li><b>Final:</b> Keyword used to define an entity that cannot be changed nor derived from later </li>" 
			+ "<li><b>Casting:</b> Used to convert a value from one data type to another</li>"
			+ "<li><b>Concatenation:</b> Operation of joining two strings together</li>"
			+ "<li><b>Stack:</b> This method call is a structure that stores active methods in the main memory using the LIFO principle</li>"
			+ "<li><b>Parameter:</b> A variable that accepts values into a method</li>" + "</ul>" + "</html>";

	// This String lets users know how to use methods (with key components, rules, and diagrams) & how they work essentially
	// Source that I used to instruct people: https://www.geeksforgeeks.org/methods-in-java/
	public static final String useHTML = "<html>" 
			+ "<style> p{font-family: Garamond; text-align: left; font-size: 15px;} </style>"
			+ "<style> ol{font-family: Garamond; text-align: left; font-size: 15px;} </style>"
			+ "<style> ul{font-family: Garamond; text-align: left; font-size: 15px;} </style>"
			+ "<p style=\"color:green\">First, declare a method.</p>"
			+"<img src =\"file:images\\useMethod2.png\" style=\"width:5px;\">"
			+"<p style=\"color:green\">Methods have 6 components</p>"
			+"<p><b>Modifier:</b> This defines the access type of the method & where it can be <br> accessed in the application)</p>"
			+"<ol>"
			+"<li><b>public:</b> accessible in all classes of the application</li>"
			+"<li><b>private:</b> accessible <i>only</i> within the class it is defined in</li>"
			+"<li><b>default:</b> declared/defined without using a modifier. It is accessible <br> within the same class & package where the class is defined</li>"
			+"</ol>"
			+"<p><b>The return type:</b> The data type of the value returned by the method/void if it <br>does not return a value</p>"
			+"<p><b>Method Name:</b> More about this further down the page</p>"
			+"<p><b>Parameter List:</b> A comma-seperated list of defined input parameters & their <br> data type, within the parenthesis. With no parameters, leave the parantheses <br>empty</p>"
			+"<p><b>Exception List:</b> This includes exceptions you expect the method to throw, <br> so specify these</p>"
			+"<p><b>Method Body:</b> This is enclosed between braces, with the code you need to be <br> executed for your operation</p>"
			+"<p style=\"color:green\"><u>There are 2 types of methods in Java:</u></p>"
			+"<ol>"
			+"<li><b>Predefined Method:</b> These are methods that are already defined in <br> the Java class libraries. We can use these by calling them in the program at <br>any point</li>"
			+"<li><b>User-defined Method:</b> These are written by the programmer & are <br>modified according to <br> the requirement(s)</li>"
			+"</ol>"
			+"<p style=\"color:green\"><u>Rules to Naming a Method</u></p>"
			+"<ul>"
			+"<li>The method name should be a <u>verb</u> and start with a <u>lowercase letter</u></li>"
			+"<li>If there are two words (or more), the <u>first name</u> must be a <u>verb</u> followed <br>by an <u>adjective/noun</u></li>"
			+"</ul>"
			+"<p style=\"color:green\"><u>A method returns to the code that called it when:</u></p>"
			+"<ul>"
			+"<li>It completes all statements in the method</li>"
			+"<li>It reaches a return statement</li>"
			+"<li>It throws an exception</li>"
			+"</ul>"
			+ "<img src =\"file:images\\useMethod.png\" width= \100\">" 
			+ "</html>";
	
	// These are the GUI elements I used 
	// I created a background label, isntructions label & a conceptsLabel (which
	// simply holds the font & flowers that I designed on Canva)
	JLabel backgroundLabel = new JLabel("");
	JLabel conceptsLabel = new JLabel(new ImageIcon("images/conceptsImage.png"));
	JLabel instructionsLabel = new JLabel("Press a button to get started!");

	// These are the buttons that lead users to the other pages 
	JButton mainMenuButton = new JButton("Main Menu");
	JButton activityButton = new JButton("Activity");
	JButton assessmentButton = new JButton("Assessment");

	// Everything I used to create the terms section - there is a button, text pane, scroll pane, & panel to add everything to
	JButton termsButton = new JButton("Terms");
	JTextPane termsTextPane = new JTextPane();
	JScrollPane termsScrollPane;
	JPanel termsPanel = new JPanel();
	
	// Everything I used to create the "How to Use" section - there's a button, text pane, scroll pane, & panel to add everything to
	JButton useButton = new JButton("How to Use");
	JTextPane useTextPane = new JTextPane();
	JScrollPane useScrollPane;
	JPanel usePanel = new JPanel();
	
	// These are the buttons that lead to external websites 
	JButton externalButton = new JButton("External Site - javatpoint.com");
	JButton external2Button = new JButton("External Site - programiz.com");
	JButton external3Button = new JButton("External Site - w3schools.com");

	// The Constructor - this sets up the frame, and adds all the components (panels, scroll panes, text panes, buttons)
	public ConceptsScreen() {

		// Setup the frame - set the size, title background colour, and layout 
		setSize(1500, 800);
		setTitle("Concepts Screen");
		getContentPane().setBackground(green);
		setLayout(null); 

		// Add the concepts label - set the bounds & add it for a nice title
		conceptsLabel.setBounds(390, -170, 500, 500);
		add(conceptsLabel);

		// The following buttons navigate to other screens 
		// Set main menu button - set bounds, font, background colour, font colour
		mainMenuButton.setBounds(940, 10, 100, 60);
		mainMenuButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mainMenuButton.setBackground(Color.WHITE);
		mainMenuButton.setForeground(new Color(0, 51, 25));
		mainMenuButton.setOpaque(true);
		mainMenuButton.setFocusable(false);
		mainMenuButton.setBorderPainted(false);
		// Add the main menu button to the screen
		mainMenuButton.addActionListener(this);
		add(mainMenuButton);
		
		// Set concepts button - set bounds, font, background colour, font colour
		activityButton.setBounds(1050, 10, 100, 60);
		activityButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		activityButton.setBackground(Color.WHITE);
		activityButton.setForeground(new Color(0, 51, 25));
		activityButton.setOpaque(true);
		activityButton.setFocusable(false);
		activityButton.setBorderPainted(false);
		// Add the concepts button to the screen
		activityButton.addActionListener(this);
		add(activityButton);
		
		// Set assessment button - set bounds, font, background colour, font colour
		assessmentButton.setBounds(1160, 10, 100, 60);
		assessmentButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		assessmentButton.setBackground(Color.WHITE);
		assessmentButton.setForeground(new Color(0, 51, 25));
		assessmentButton.setOpaque(true);
		assessmentButton.setFocusable(false);
		assessmentButton.setBorderPainted(false);
		// Add the assessment button to the screen
		assessmentButton.addActionListener(this);
		add(assessmentButton);

		// Set instructions label - set bounds, font, font colour & add it to screen 
		instructionsLabel.setBounds(529, 104, 300, 40);
		instructionsLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		instructionsLabel.setForeground(Color.BLACK);
		add(instructionsLabel);
		
		// Onto the components of the concepts page
		// Set terms button - set bounds, font, background colour, font colour, opacity, border paint
		// Then add the Action Listener (so when user presses it content is added) & add it to the page
		termsButton.setBounds(530, 140, 100, 40);
		termsButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		termsButton.setBackground(Color.WHITE);
		termsButton.setForeground(Color.BLACK);
		termsButton.setOpaque(true);
		termsButton.setFocusable(false);
		termsButton.setBorderPainted(false);
		termsButton.addActionListener(this);
		add(termsButton);
		
		// Set use button - set bounds, font, background colour, font colour, opacity, border paint
		// Then add the Action Listener (so when user presses it content is added) & add it to the page
		useButton.setBounds(640, 140, 130, 40);
		useButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		useButton.setBackground(Color.WHITE);
		useButton.setForeground(Color.BLACK);
		useButton.setOpaque(true);
		useButton.setFocusable(false);
		useButton.setBorderPainted(false);
		useButton.addActionListener(this);
		add(useButton);

		// Set external button - set bounds, font, background colour, font colour, opacity, border paint
		// Then add the Action Listener (so when user presses it, there are lead to the link) 
		externalButton.setBounds(160, 655, 300, 40);
		externalButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		externalButton.setBackground(Color.WHITE);
		externalButton.setForeground(Color.BLACK);
		externalButton.setOpaque(true);
		externalButton.setFocusable(false);
		externalButton.setBorderPainted(false);
		externalButton.addActionListener(this);
		add(externalButton);
		
		// Set second external button - set bounds, font, background colour, font colour, opacity, border paint
		// Then add the Action Listener (so when user presses it, there are lead to the link) 
		external2Button.setBounds(480, 655, 300, 40);
		external2Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		external2Button.setBackground(Color.WHITE);
		external2Button.setForeground(Color.BLACK);
		external2Button.setOpaque(true);
		external2Button.setFocusable(false);
		external2Button.setBorderPainted(false);
		external2Button.addActionListener(this);
		add(external2Button);
		
		// Set third external button - set bounds, font, background colour, font colour, opacity, border paint
		// Then add the Action Listener (so when user presses it, there are lead to the link) 
		external3Button.setBounds(800, 655, 300, 40);
		external3Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		external3Button.setBackground(Color.WHITE);
		external3Button.setForeground(Color.BLACK);
		external3Button.setOpaque(true);
		external3Button.setFocusable(false);
		external3Button.setBorderPainted(false);
		external3Button.addActionListener(this);
		add(external3Button);
		
		// Create the text pane for terms, set the text, content type to HTML, and background 
		termsTextPane.setText(termsHTML);
		termsTextPane.setContentType("text/html");
		termsTextPane.setEditable(false);
		termsTextPane.setBackground(Color.WHITE);

		// Create the scroll pane for terms - add the vertical scroll bar, background, & bounds
		termsScrollPane = new JScrollPane(termsTextPane);
		termsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		termsScrollPane.setBackground(Color.WHITE);
		termsScrollPane.setBounds(20, 10, 585, 450);

		// Create the terms panel - set bounds, background, and layout
		termsPanel.setBounds(-5, 185, 635, 500);
		termsPanel.setBackground(Color.WHITE);
		termsPanel.setLayout(null);

		// Add the scroll pane to the panel, & the panel to the screen. Set the background to green 
		termsPanel.add(termsScrollPane);
		termsPanel.setBackground(green);
		add(termsPanel);

		// Create the text pane for usage, set the text, content type to HTML, and background 
		useTextPane.setText(useHTML);
		useTextPane.setContentType("text/html");
		useTextPane.setEditable(false);
		useTextPane.setBackground(Color.WHITE);

		// Create the scroll pane for usage - add the vertical scroll bar, background, & bounds
		useScrollPane = new JScrollPane(useTextPane);
		useScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		useScrollPane.setBackground(Color.WHITE);
		useScrollPane.setBounds(298, 15, 1040, 450);

		// Create the usage panel - set bounds, background, and layout
		usePanel.setBounds(308, 180, 935, 500);
		usePanel.setBackground(Color.WHITE);
		usePanel.setLayout(null);
	
		// Add the scroll pane to the panel, & the panel to the screen. Set the background to green 
		usePanel.add(useScrollPane);
		usePanel.setBackground(green);
		add(usePanel);
	
		// Make sure that the frame is visible 
		setVisible(true);

	}

	// This method leads the user to the first external website. It checks if the button was pressed, and leads them accordingly 
	// Source: https://www.youtube.com/watch?v=pIwHGjo3Lqs
	@SuppressWarnings("unused")
	private void externalButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// Used a try & catch method in case of errors 
		try {
			// This holds the URL link 
			Desktop.getDesktop().browse(new URL("https://www.javatpoint.com/method-in-java").toURI());
		} catch (Exception e) {

		}
	}
	
	// This method leads the user to the second external website. It checks if the button was pressed, and leads them accordingly 
	@SuppressWarnings("unused")
	private void external2ButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// Used a try & catch method in case of errors 
		try {
			// This holds the URL link 
			Desktop.getDesktop().browse(new URL("https://www.programiz.com/java-programming/methods").toURI());
		} catch (Exception e) {

		}
	}

	// This method leads the user to the third external website. It checks if the button was pressed, and leads them accordingly 
	@SuppressWarnings("unused")
	private void external3ButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// Used a try & catch method in case of errors 
		try {
			// This holds the URL link 
			Desktop.getDesktop().browse(new URL("https://www.w3schools.com/java/java_methods.asp").toURI());
		} catch (Exception e) {

		}
	}

	// Action Performed method - if a button is pressed, a specific outcome will occur 
	public void actionPerformed(ActionEvent event) {

		// Connects buttons to different pages
		// If user clicks main menu, take them to that page & dispose of concepts screen
		if (event.getSource() == mainMenuButton) {
			new MainMenuScreen();
			dispose();
		// Connects buttons to different pages
		// If user clicks activity, take them to that page & dispose of concepts screen
		} else if (event.getSource() == activityButton) {
			new ActivityScreen();
			dispose();
		// Connects buttons to different pages
		// If user clicks assessment, take them to that page & dispose of concepts screen
		} else if (event.getSource() == assessmentButton) {
			new AssessmentScreen();
			dispose();

		// Connect terms button to the terms text pane, so if the user presses on the button, the content shows up
		} else if (event.getSource() == termsButton) {
			termsTextPane.setText(termsHTML);
		// Connect usage button to the usage text pane, so if the user presses on the button, the content shows up
		} else if (event.getSource() == useButton) {
			useTextPane.setText(useHTML);

		// Connect external site 1 button to the method, that will later pull up that page 
		} else if (event.getSource() == externalButton) {
			externalButtonActionPerformed(event);
		// Connect external site 2 button to the method, that will later pull up that page 
		} else if (event.getSource() == external2Button) {
			external2ButtonActionPerformed(event);
		// Connect external site 3 button to the method, that will later pull up that page 
		} else if (event.getSource() == external3Button) {
			external3ButtonActionPerformed(event);
		}

	}
}
