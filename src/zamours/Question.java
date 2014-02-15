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
			tabQuestions[2] = "2. La première fois qu'il t'a vue sur \nune piste de danse, il s'est dit : ";
			tabQuestions[3] = "2. La première fois que tu l'as vue sur \nune piste de danse, \ntu t'es dit : ";
			tabQuestions[4] = "3. Elle a déposé dans toute la maison des sous-vêtements \net t'attends sur le lit";
			tabQuestions[5] = "3. Tu as déposé dans toute la maison des sous-vêtements \net tu l'attend sur le lit";
			tabQuestions[6] = "4. Demain ton chéri et toi avez rendez-vous \nchez tes parents pour un repas en famille";
			tabQuestions[7] = "4. Demain tu as rendez-vous chez les parents \nde ta chérie pour un repas en famille";
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
			tabQuestions[0] = "1. Elle écrit un roman érotique dans lequel \nelle dévoile tous ses fantasmes. D’après toi ce serait plutôt du genre : ";
			tabQuestions[1] = "1. Tu écris un roman érotique dans lequel \ntu dévoiles tous tes fantasmes. D’après lui ce serait plutôt du genre :  ";
			tabQuestions[2] = "2. Votre  devez changer de voiture, votre  opterait pour : ";
			tabQuestions[3] = "2. La première fois que tu l'as vue sur \nune piste de danse, \ntu t'es dit : ";
			tabQuestions[4] = "3. Elle a déposé dans toute la maison des sous-vêtements \net t'attends sur le lit";
			tabQuestions[5] = "3. Tu as déposé dans toute la maison des sous-vêtements \net tu l'attend sur le lit";
			tabQuestions[6] = "4. Demain ton chéri et toi avez rendez-vous \nchez tes parents pour un repas en famille";
			tabQuestions[7] = "4. Demain tu as rendez-vous chez les parents \nde ta chérie pour un repas en famille";
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
		default:
			return tabQuestions[numQuestion];
		}
	}
}