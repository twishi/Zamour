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
			tabQuestions[0] = "1. Si tu lui donnais le nom d'un plat\nce serait :";
			tabQuestions[1] = "1. S'il te donnait le nom d'un plat\nce serait :  ";
			tabQuestions[2] = "2. La premi�re fois qu'il t'a vu sur\nune piste de danse, il s'est dit : ";
			tabQuestions[3] = "2. La premi�re fois que tu l'as vue sur \nune piste de danse, \ntu t'es dit : ";
			tabQuestions[4] = "3. Elle a d�pos� dans toute la maison des sous-v�tements \net t'attends sur le lit";
			tabQuestions[5] = "3. Tu as d�pos� dans toute la maison des sous-v�tements \net tu l'attendez sur le lit";
			tabQuestions[6] = "4. En discoth�que, il serait plut�t :";
			tabQuestions[7] = "4. En discoth�que, tu serais plut�t : ";
			tabQuestions[8] = "5. Si elle �tait un film\nelle serait :";
			tabQuestions[9] = "5. Si tu etais un film tu serais :";
			tabQuestions[10] = "6. S'il ne pouvait partir en voyage\navec qui r�verais-tu de partir :";
			tabQuestions[11] = "6. Si tu ne pouvais partir en voyage\n avec qui r�verait-elle de partir :";
			tabQuestions[12] = "7. A la maison elle est plut�t :";
			tabQuestions[13] = "7. A la maison tu es plut�t :";
			tabQuestions[14] = "8. Sa boisson pr�f�r�e c'est :";
			tabQuestions[15] = "8. Ta boisson pr�f�r�e c'est :";
			tabQuestions[16] = "9. Sa meilleure amie est :";
			tabQuestions[17] = "9. Ta meilleure amie est :";
			tabQuestions[18] = "10. S'il �tait un animal\nil serait :";
			tabQuestions[19] = "10. Si tu �tais un animal tu serais :";
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