package zamours;

public class Question {

	private String[] tabQuestions = new String[20];

	private int numQuizz;

	Question(int numQuizz) {
		this.numQuizz = numQuizz;
	}

	public String afficheQuestionQuizz(int numQuestion) {
		switch (numQuizz) {
		case 1:
			tabQuestions[0] = "1. De tout les hommes qu'elle connait tu es \nle meilleur pour : ";
			tabQuestions[1] = "1. De tout les hommes que tu connais il est le\n meilleur pour :  ";
			tabQuestions[2] = "2. La première fois qu'il t'a vue sur une piste\n de danse, il s'est dit : ";
			tabQuestions[3] = "2. La première fois que tu l'as vue sur une piste\n de danse, tu t'es dit : ";
			tabQuestions[4] = "3. Elle a déposé dans toute la maison des sous-vêtements\n et t'attends sur le lit";
			tabQuestions[5] = "3. Tu as déposé dans toute la maison des sous-vêtements\n et tu l'attend sur le lit";
			tabQuestions[6] = "4. Demain ton chéri et toi avez rendez-vous chez tes parents\n pour un repas en famille";
			tabQuestions[7] = "4. Demain tu as rendez-vous chez les parents de ta chérie\n pour un repas en famille";
			tabQuestions[8] = "5. Voici la question 5 du Quizz 1";
			tabQuestions[9] = "5. Voici la question 5bis du Quizz 1";
			tabQuestions[10] = "6. Voici la question 6 du Quizz 1";
			tabQuestions[11] = "6. Voici la question 6bis du Quizz 1";
			tabQuestions[12] = "7. Voici la question 7 du Quizz 1";
			tabQuestions[13] = "7. Voici la question 7bis du Quizz 1";
			tabQuestions[14] = "8. Voici la question 8 du Quizz 1";
			tabQuestions[15] = "8. Voici la question 8bis du Quizz 1";
			tabQuestions[16] = "9. Voici la question 9 du Quizz 1";
			tabQuestions[17] = "9. Voici la question 9bis du Quizz 1";
			tabQuestions[18] = "10. Voici la question 10 du Quizz 1";
			tabQuestions[19] = "10. Voici la question 10bis du Quizz 1";
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