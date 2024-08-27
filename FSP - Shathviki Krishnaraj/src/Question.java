//By: Shathviki Krishnaraj
// This is the Question class. It refers to the Assessment File Input class where I used a Excel sheet (assessment.csv) 
// to import the questions, possible answers, and correct answers. Here, I have a constructor, and get & set methods. This
// data is later used in the assessment class, when I make the multiple choice class. 

// Class - this holds the question & 4 multiple choice options as a String and the correct character as a char
public class Question {
	
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private char correct;

	// Constructor -  holds the question & 4 multiple choice options, passes them along to the get & set methods
	public Question(String question, String optionA, String optionB,
			String optionC, String optionD, char correct) {
		super();
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correct = correct;
	}

	// Get & Set methods - for question, 4 multiple choice options (A, B, C, D) & the correct character
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public char getCorrect() {
		return correct;
	}
	public void setCorrect(char correct) {
		this.correct = correct;
	}
}
