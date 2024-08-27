import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

@SuppressWarnings("serial")
public class AssessmentScreen extends JFrame implements ActionListener {
    String sound = "sounds/assessment.wav";
    public static final Color blue = new Color(225, 246, 255);
    public static final Color darkGreen = new Color(0, 51, 25);
    int score = 0;
    int again = 0;

    JLabel assessmentLabel = new JLabel(new ImageIcon("images/assessmentImage.png"));
    JLabel flowersLabel = new JLabel(new ImageIcon("images/flowers.png"));
    JLabel flowers2Label = new JLabel(new ImageIcon("images/flowers.png"));
    JLabel flowers3Label = new JLabel(new ImageIcon("images/flowers.png"));

    JButton mainMenuButton = new JButton("Main Menu");
    JButton conceptsButton = new JButton("Concepts");
    JButton activityButton = new JButton("Activity");
    JButton submitButton = new JButton("Submit");

    JLabel questionLabel, question1Label, question2Label, question3Label, question4Label, question5Label,
            question6Label, question7Label, question8Label, question9Label, question10Label;

    JLabel[] questionsLabelArray = new JLabel[] { questionLabel, question1Label, question2Label, question3Label,
            question4Label, question5Label, question6Label, question7Label, question8Label, question9Label,
            question10Label };

    JRadioButton questionARadioButton, questionBRadioButton, questionCRadioButton, questionDRadioButton,
            question1aRadioButton, question1bRadioButton, question1cRadioButton, question1dRadioButton,
            question2aRadioButton, question2bRadioButton, question2cRadioButton, question2dRadioButton,
            question3aRadioButton, question3bRadioButton, question3cRadioButton, question3dRadioButton,
            question4aRadioButton, question4bRadioButton, question4cRadioButton, question4dRadioButton,
            question5aRadioButton, question5bRadioButton, question5cRadioButton, question5dRadioButton,
            question6aRadioButton, question6bRadioButton, question6cRadioButton, question6dRadioButton,
            question7aRadioButton, question7bRadioButton, question7cRadioButton, question7dRadioButton,
            question8aRadioButton, question8bRadioButton, question8cRadioButton, question8dRadioButton,
            question9aRadioButton, question9bRadioButton, question9cRadioButton, question9dRadioButton,
            question10aRadioButton, question10bRadioButton, question10cRadioButton, question10dRadioButton;

    JRadioButton[] aRadioButtonArray = new JRadioButton[] { questionARadioButton, question1aRadioButton,
            question2aRadioButton, question3aRadioButton, question4aRadioButton, question5aRadioButton,
            question6aRadioButton, question7aRadioButton, question8aRadioButton, question9aRadioButton,
            question10aRadioButton };

    JRadioButton[] bRadioButtonArray = new JRadioButton[] { questionBRadioButton, question1bRadioButton,
            question2bRadioButton, question3bRadioButton, question4bRadioButton, question5bRadioButton,
            question6bRadioButton, question7bRadioButton, question8bRadioButton, question9bRadioButton,
            question10bRadioButton };

    JRadioButton[] cRadioButtonArray = new JRadioButton[] { questionCRadioButton, question1cRadioButton,
            question2cRadioButton, question3cRadioButton, question4cRadioButton, question5cRadioButton,
            question6cRadioButton, question7cRadioButton, question8cRadioButton, question9cRadioButton,
            question10cRadioButton };

    JRadioButton[] dRadioButtonArray = new JRadioButton[] { questionDRadioButton, question1dRadioButton,
            question2dRadioButton, question3dRadioButton, question4dRadioButton, question5dRadioButton,
            question6dRadioButton, question7dRadioButton, question8dRadioButton, question9dRadioButton,
            question10dRadioButton };

    ButtonGroup buttonGroup, buttonGroup1, buttonGroup2, buttonGroup3, buttonGroup4, buttonGroup5, buttonGroup6,
            buttonGroup7, buttonGroup8, buttonGroup9, buttonGroup10;

    ButtonGroup[] groupButtonArray = new ButtonGroup[] { buttonGroup, buttonGroup1, buttonGroup2, buttonGroup3,
            buttonGroup4, buttonGroup5, buttonGroup6, buttonGroup7, buttonGroup8, buttonGroup9, buttonGroup10 };

    Object[][] questionArray = new Object[11][5];

    JScrollPane scrollPane;
    JPanel mainPanel = new JPanel();
    JPanel q, question1Panel, question2Panel, question3Panel, question4Panel, question5Panel, question6Panel,
            question7Panel, question8Panel, question9Panel, question10Panel;

    JPanel[] questionPanelArray = new JPanel[] { q, question1Panel, question2Panel, question3Panel, question4Panel,
            question5Panel, question6Panel, question7Panel, question8Panel, question9Panel, question10Panel };

    JTextPane imageTextPane = new JTextPane();
    JScrollPane imageScrollPane;
    JPanel imagePanel = new JPanel();

    public AssessmentScreen() {
        PlayAssessmentMusic(sound);
        setSize(1500, 800);
        setTitle("Assessment Screen");
        setLayout(null);
        getContentPane().setBackground(blue);

        assessmentLabel.setBounds(390, -170, 500, 500);
        flowersLabel.setBounds(0, 475, 500, 500);
        flowers2Label.setBounds(500, 475, 500, 500);
        flowers3Label.setBounds(1000, 475, 500, 500);

        add(assessmentLabel);
        add(flowersLabel);
        add(flowers2Label);
        add(flowers3Label);

        mainPanel.setBackground(blue);
        mainPanel.setBounds(0, 100, 700, 400);
        mainPanel.setLayout(new GridLayout(16, -10));

        for (int index = 1; index <= questionPanelArray.length - 1; index++) {
            questionPanelArray[index] = new JPanel();
            questionPanelArray[index].setBackground(darkGreen);
            questionPanelArray[index].setLayout(null);
            questionPanelArray[index].setPreferredSize(new Dimension(20, 180));
            mainPanel.add(questionPanelArray[index]);
        }

        mainMenuButton.setBounds(940, 10, 100, 60);
        mainMenuButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        mainMenuButton.setBackground(Color.WHITE);
        mainMenuButton.setForeground(darkGreen);
        mainMenuButton.setOpaque(true);
        mainMenuButton.setFocusable(false);
        mainMenuButton.setBorderPainted(false);
        mainMenuButton.addActionListener(this);
        add(mainMenuButton);

        conceptsButton.setBounds(1050, 10, 100, 60);
        conceptsButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        conceptsButton.setBackground(Color.WHITE);
        conceptsButton.setForeground(darkGreen);
        conceptsButton.setOpaque(true);
        conceptsButton.setFocusable(false);
        conceptsButton.setBorderPainted(false);
        conceptsButton.addActionListener(this);
        add(conceptsButton);

        activityButton.setBounds(1160, 10, 100, 60);
        activityButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        activityButton.setBackground(Color.WHITE);
        activityButton.setForeground(darkGreen);
        activityButton.setOpaque(true);
        activityButton.setFocusable(false);
        activityButton.setBorderPainted(false);
        activityButton.addActionListener(this);
        add(activityButton);

        submitButton.setBounds(600, 640, 150, 35);
        submitButton.setFont(new Font("Times New Roman", Font.BOLD, 21));
        submitButton.setBackground(Color.WHITE);
        submitButton.setForeground(darkGreen);
        submitButton.setBorder(BorderFactory.createLineBorder(darkGreen));
        submitButton.setOpaque(true);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        add(submitButton);

        for (int numQuestion = 1; numQuestion <= questionsLabelArray.length - 1; numQuestion++) {
            questionsLabelArray[numQuestion] = new JLabel(Application.questionArray[numQuestion].getQuestion());
            questionsLabelArray[numQuestion].setBounds(10, 70, 800, 20);
            questionsLabelArray[numQuestion].setFont(new Font("Times New Roman", Font.BOLD, 18));
            questionsLabelArray[numQuestion].setForeground(Color.WHITE);
            questionPanelArray[numQuestion].add(questionsLabelArray[numQuestion]);

            aRadioButtonArray[numQuestion] = new JRadioButton(Application.questionArray[numQuestion].getOptionA());
            aRadioButtonArray[numQuestion].setBounds(10, 100, 300, 20);
            aRadioButtonArray[numQuestion].setFont(new Font("Times New Roman", Font.PLAIN, 18));
            aRadioButtonArray[numQuestion].setBackground(darkGreen);
            aRadioButtonArray[numQuestion].setForeground(Color.WHITE);
            aRadioButtonArray[numQuestion].setSelected(false);
            questionPanelArray[numQuestion].add(aRadioButtonArray[numQuestion]);

            bRadioButtonArray[numQuestion] = new JRadioButton(Application.questionArray[numQuestion].getOptionB());
            bRadioButtonArray[numQuestion].setBounds(10, 120, 300, 20);
            bRadioButtonArray[numQuestion].setFont(new Font("Times New Roman", Font.PLAIN, 18));
            bRadioButtonArray[numQuestion].setBackground(darkGreen);
            bRadioButtonArray[numQuestion].setForeground(Color.WHITE);
            bRadioButtonArray[numQuestion].setSelected(false);
            questionPanelArray[numQuestion].add(bRadioButtonArray[numQuestion]);

            cRadioButtonArray[numQuestion] = new JRadioButton(Application.questionArray[numQuestion].getOptionC());
            cRadioButtonArray[numQuestion].setBounds(10, 140, 300, 20);
            cRadioButtonArray[numQuestion].setFont(new Font("Times New Roman", Font.PLAIN, 18));
            cRadioButtonArray[numQuestion].setBackground(darkGreen);
            cRadioButtonArray[numQuestion].setForeground(Color.WHITE);
            cRadioButtonArray[numQuestion].setSelected(false);
            questionPanelArray[numQuestion].add(cRadioButtonArray[numQuestion]);

            dRadioButtonArray[numQuestion] = new JRadioButton(Application.questionArray[numQuestion].getOptionD());
            dRadioButtonArray[numQuestion].setBounds(10, 160, 300, 20);
            dRadioButtonArray[numQuestion].setFont(new Font("Times New Roman", Font.PLAIN, 18));
            dRadioButtonArray[numQuestion].setBackground(darkGreen);
            dRadioButtonArray[numQuestion].setForeground(Color.WHITE);
            dRadioButtonArray[numQuestion].setSelected(false);
            questionPanelArray[numQuestion].add(dRadioButtonArray[numQuestion]);

            groupButtonArray[numQuestion] = new ButtonGroup();
            groupButtonArray[numQuestion].add(aRadioButtonArray[numQuestion]);
            groupButtonArray[numQuestion].add(bRadioButtonArray[numQuestion]);
            groupButtonArray[numQuestion].add(cRadioButtonArray[numQuestion]);
            groupButtonArray[numQuestion].add(dRadioButtonArray[numQuestion]);
        }

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(darkGreen);
        scrollPane.setBounds(30, 120, 715, 500);
        scrollPane.setViewportView(mainPanel);
        add(scrollPane);

        imageTextPane.insertIcon(new ImageIcon("images/methodsAssessment.png"));
        imageTextPane.setEditable(false);
        imageTextPane.setBackground(Color.WHITE);

        imageScrollPane = new JScrollPane(imageTextPane);
        imageScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        imageScrollPane.setBackground(Color.WHITE);
        imageScrollPane.setBounds(378, 20, 870, 500);

        imagePanel.setBounds(378, 100, 870, 550);
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setLayout(null);

        imagePanel.add(imageScrollPane);
        imagePanel.setBackground(blue);
        add(imagePanel);

        setVisible(true);
    }

    private void PlayAssessmentMusic(String sound) {
        try {
            File path = new File(sound);
            if (path.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("Can't find file ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == mainMenuButton) {
            new MainMenuScreen();
            dispose();
        } else if (event.getSource() == conceptsButton) {
            new ConceptsScreen();
            dispose();
        } else if (event.getSource() == activityButton) {
            new ActivityScreen();
            dispose();
        }

        if (event.getSource() == submitButton) {
            for (int index = 1; index <= Application.questionArray.length - 1; index++) {
                if (aRadioButtonArray[index].isSelected() && Application.questionArray[index].getCorrect() == 'A')
                    score++;
                else if (bRadioButtonArray[index].isSelected() && Application.questionArray[index].getCorrect() == 'B')
                    score++;
                else if (cRadioButtonArray[index].isSelected() && Application.questionArray[index].getCorrect() == 'C')
                    score++;
                else if (dRadioButtonArray[index].isSelected() && Application.questionArray[index].getCorrect() == 'D')
                    score++;
            }
            again = JOptionPane.showConfirmDialog(this, (String.format("Your score is " + score + "/10!\nTry again?")),
                    "Try Again?", JOptionPane.YES_NO_OPTION);
            if (again == JOptionPane.YES_OPTION) {
                dispose();
                new AssessmentScreen();
            } else {
                dispose();
                new MainMenuScreen();
            }
        }
    }
}
