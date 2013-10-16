package zamours;

public class Question {
	private String[] tabQuestions = new String[20];
	
	private int numQuizz;

	Question(int numQuizz) {
		this.numQuizz = numQuizz;
	}

	public String afficheQuestionQuizz(int numQuestion) {
		switch (numQuizz){
		case 1:
			tabQuestions[0] = "Voici la question 1 du Quizz 1";
			tabQuestions[1] = "Voici la question 2 du Quizz 1";
			tabQuestions[2] = "Voici la question 3 du Quizz 1";
			tabQuestions[3] = "Voici la question 4 du Quizz 1";
			return tabQuestions[numQuestion];
		case 2:
			tabQuestions[0] = "Voici la question 1 du Quizz 2";
			tabQuestions[1] = "Voici la question 2 du Quizz 2";
			tabQuestions[2] = "Voici la question 3 du Quizz 2";
			tabQuestions[3] = "Voici la question 4 du Quizz 2";
			return tabQuestions[numQuestion];
		default:
			return tabQuestions[numQuestion];
		}
	}
}