package zamours;

public class Reponse {
	private String[][] tabReponse = new String[20][60];

	private int numQuizz;

	Reponse(int numQuizz){
		this.numQuizz = numQuizz;
	}

	public void reponseQuizz(int numQuestion) {
		switch (numQuizz) {
		case 1:
			tabReponse[0][0] = "Voici la reponse 1 du Quizz 1";
			tabReponse[0][1] = "Voici la reponse 2 du Quizz 1";
			tabReponse[0][2] = "Voici la reponse 3 du Quizz 1";
		case 2:
			tabReponse[0][0] = "Voici la reponse 1 du Quizz 2";
			tabReponse[0][1] = "Voici la reponse 2 du Quizz 2";
			tabReponse[0][2] = "Voici la reponse 3 du Quizz 2";
		}
	}


	public String afficheReponseQuizz(int n){
		reponseQuizz(numQuizz);
		return tabReponse[0][n];
	}

}