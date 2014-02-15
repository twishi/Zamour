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
			tabQuestions[0] = "Voici la question 1 du Quizz 2";
			tabQuestions[1] = "Voici la question 2 du Quizz 2";
			tabQuestions[2] = "Voici la question 3 du Quizz 2";
			tabQuestions[3] = "Voici la question 4 du Quizz 2";
			return tabQuestions[numQuestion];
		case 3:
			tabQuestions[0] = "1. D’après elle, les films ou les sites internet un peu chauds : ";
			tabQuestions[1] = "1. D’après lui, les films ou les sites internet un peu chauds :  ";
			tabQuestions[2] = "2. Votre jolie voisine d’en face se promène en string sur son balcon. il trouve ce spectacle : ";
			tabQuestions[3] = "2. Votre jolie voisine d’en face se promène en string sur son balcon. tu trouve ce spectacle : ";
			tabQuestions[4] = "3. Le mois dernier, si tu avez mis 10 euros dans une tirelire à chaque fois que vous faisiez l’amour : ";
			tabQuestions[5] = "3. Le mois dernier, si il avait mis 10 euros dans une tirelire à chaque fois que vous faisiez l’amour : ";
			tabQuestions[6] = "4. Où ton sens de l’orientation est-il le plus aiguisé : ";
			tabQuestions[7] = "4. D’après vous où son sens de l’orientation est-il le plus aiguisé : ";
			tabQuestions[8] = "5. Si elle te dit, fait moi un striptease, comment vas-tu réagir ?";
			tabQuestions[9] = "5. Si vous lui dites, fait moi un striptease, comment va-t-il réagir ?";
			tabQuestions[10] = "6. Quand vous passez du temps à vous pouponner dans la salle de bain, il vous dit : ";
			tabQuestions[11] = "6. Quand elle passe du temps à se pouponner dans la salle de bain, tu lui dit : ";
			tabQuestions[12] = "7. On parle beaucoup de la crise, mais tu es plutôt :";
			tabQuestions[13] = "7. On parle beaucoup de la crise, mais il est plutôt :";
			tabQuestions[14] = "8. Pendant les vacances, qu’est-ce qui te fatigue le plus ? ";
			tabQuestions[15] = "8. Pendant les vacances, qu’est-ce qui la fatigue le plus ? ";
			tabQuestions[16] = "9. La premiere fois que tu l'a vue sur une piste de danse, tu t'es dit :";
			tabQuestions[17] = "9. La premiere fois qu'il t'a vue sur une piste de danse, il s'est dit :";
			tabQuestions[18] = "10. tu as déposé dans toute la maison tes sous-vêtements et tu l'attend sur le lit:";
			tabQuestions[19] = "10. Elle a déposé dans toute la maison ses sous-vêtements et t'attends sur le lit:";
			return tabQuestions[numQuestion];
		default:
			return tabQuestions[numQuestion];
		}
	}
}