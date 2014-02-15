package zamours;

public class Reponse {
	String newLine = System.getProperty("line.separator");
	private String[][] tabReponse = new String[20][3];

	private int numQuizz;

	Reponse(int numQuizz) {
		this.numQuizz = numQuizz;
	}

	public void reponseQuizz(int numQuestion) {
		switch (numQuizz) {
		case 1:
			tabReponse[0][0] = "La faire rire.";
			tabReponse[0][1] = "Les câlins.";
			tabReponse[0][2] = "Faire à manger.";
			tabReponse[1][0] = "Te faire rire.";
			tabReponse[1][1] = "Les câlins.";
			tabReponse[1][2] = "Faire à manger.";
			tabReponse[2][0] = "Elle est folle.";
			tabReponse[2][1] = "Elle est molle.";
			tabReponse[2][2] = "Quel sex-symbol.";
			tabReponse[3][0] = "Elle est folle.";
			tabReponse[3][1] = "Elle est molle.";
			tabReponse[3][2] = "Quel sex-symbol.";
			tabReponse[4][0] = "Tu ramasses ses affaires et les met dans \nle bac à linge.";
			tabReponse[4][1] = "Surexcité, tu cours pour la rejoindre dans \nla chambre.";
			tabReponse[4][2] = "Ce soir y'a match, tu as d'autres occupations.";
			tabReponse[5][0] = "Tu le regarde mettre tes sous-vêtements dans \nle bac à linge.";
			tabReponse[5][1] = "Il arrive en courant pour te sauter dessus.";
			tabReponse[5][2] = "Ce soir y'a match, tu peux l'attendre encore \nlongtemps.";
			tabReponse[6][0] = "Tu viens de le lui rappeller, il avait oublié \net comptait sortir avec ses amis.";
			tabReponse[6][1] = "Sa chemise préférée est pendue sur la poignée \nde la porte,et le gâteau dans le frigo.";
			tabReponse[6][2] = "Subitement, il fait comme s'il tombait malade \net se prépare à te dire qu'il ne pourra pas \nvenir.";
			tabReponse[7][0] = "Heuresement qu'elle te l'as rappelé, sinon \ndemain t'allais au bowling avec tes amis.";
			tabReponse[7][1] = "Tout est organisé, tu as acheté le dessert \npour ne pas arriver les mains vides et tu as \ndéjà préparé ta tenue pour demain.";
			tabReponse[7][2] = "T'es pas très motivé... tu cherches une excuse\n pour ne pas y aller.";
			tabReponse[8][0] = "Voici la reponse 1 de la question 5 du quizz 1";
			tabReponse[8][1] = "Voici la reponse 2 de la question 5 du quizz 1";
			tabReponse[8][2] = "Voici la reponse 3 de la question 5 du quizz 1";
			tabReponse[9][0] = "Voici la reponse 1 de la question 5 du quizz 1";
			tabReponse[9][1] = "Voici la reponse 2 de la question 5 du quizz 1";
			tabReponse[9][2] = "Voici la reponse 3 de la question 5 du quizz 1";
			tabReponse[10][0] = "Voici la reponse 1 de la question 6 du quizz 1";
			tabReponse[10][1] = "Voici la reponse 2 de la question 6 du quizz 1";
			tabReponse[10][2] = "Voici la reponse 3 de la question 6 du quizz 1";
			tabReponse[11][0] = "Voici la reponse 1 de la question 6 du quizz 1";
			tabReponse[11][1] = "Voici la reponse 2 de la question 6 du quizz 1";
			tabReponse[11][2] = "Voici la reponse 3 de la question 6 du quizz 1";
			tabReponse[12][0] = "Voici la reponse 1 de la question 7 du quizz 1";
			tabReponse[12][1] = "Voici la reponse 2 de la question 7 du quizz 1";
			tabReponse[12][2] = "Voici la reponse 3 de la question 7 du quizz 1";
			tabReponse[13][0] = "Voici la reponse 1 de la question 7 du quizz 1";
			tabReponse[13][1] = "Voici la reponse 2 de la question 7 du quizz 1";
			tabReponse[13][2] = "Voici la reponse 3 de la question 7 du quizz 1";
			tabReponse[14][0] = "Voici la reponse 1 de la question 8 du quizz 1";
			tabReponse[14][1] = "Voici la reponse 2 de la question 8 du quizz 1";
			tabReponse[14][2] = "Voici la reponse 3 de la question 8 du quizz 1";
			tabReponse[15][0] = "Voici la reponse 1 de la question 8 du quizz 1";
			tabReponse[15][1] = "Voici la reponse 2 de la question 8 du quizz 1";
			tabReponse[15][2] = "Voici la reponse 3 de la question 8 du quizz 1";
			tabReponse[16][0] = "Voici la reponse 1 de la question 9 du quizz 1";
			tabReponse[16][1] = "Voici la reponse 2 de la question 9 du quizz 1";
			tabReponse[16][2] = "Voici la reponse 3 de la question 9 du quizz 1";
			tabReponse[17][0] = "Voici la reponse 1 de la question 9 du quizz 1";
			tabReponse[17][1] = "Voici la reponse 2 de la question 9 du quizz 1";
			tabReponse[17][2] = "Voici la reponse 3 de la question 9 du quizz 1";
			tabReponse[18][0] = "Voici la reponse 1 de la question 10 du quizz 1";
			tabReponse[18][1] = "Voici la reponse 2 de la question 10 du quizz 1";
			tabReponse[18][2] = "Voici la reponse 3 de la question 10 du quizz 1";
			tabReponse[19][0] = "Voici la reponse 1 de la question 10 du quizz 1";
			tabReponse[19][1] = "Voici la reponse 2 de la question 10 du quizz 1";
			tabReponse[19][2] = "Voici la reponse 3 de la question 10 du quizz 1";
			break;
		case 2:
			tabReponse[0][0] = "Voici la reponse 1 de la question 1 du quizz 2";
			tabReponse[0][1] = "Voici la reponse 2 de la question 1 du quizz 2";
			tabReponse[0][2] = "Voici la reponse 3 de la question 1 du quizz 2";
			tabReponse[1][0] = "Voici la reponse 1 de la question 2 du quizz 2";
			tabReponse[1][1] = "Voici la reponse 2 de la question 2 du quizz 2";
			tabReponse[1][2] = "Voici la reponse 3 de la question 2 du quizz 2";
			tabReponse[2][0] = "Voici la reponse 1 de la question 3 du quizz 2";
			tabReponse[2][1] = "Voici la reponse 2 de la question 3 du quizz 2";
			tabReponse[2][2] = "Voici la reponse 3 de la question 3 du quizz 2";
			tabReponse[3][0] = "Voici la reponse 1 de la question 4 du quizz 2";
			tabReponse[3][1] = "Voici la reponse 2 de la question 4 du quizz 2";
			tabReponse[3][2] = "Voici la reponse 3 de la question 4 du quizz 2";
			tabReponse[4][0] = "Voici la reponse 1 de la question 5 du quizz 2";
			tabReponse[4][1] = "Voici la reponse 2 de la question 5 du quizz 2";
			tabReponse[4][2] = "Voici la reponse 3 de la question 5 du quizz 2";
			tabReponse[5][0] = "Voici la reponse 1 de la question 6 du quizz 2";
			tabReponse[5][1] = "Voici la reponse 2 de la question 6 du quizz 2";
			tabReponse[5][2] = "Voici la reponse 3 de la question 6 du quizz 2";
			tabReponse[6][0] = "Voici la reponse 1 de la question 7 du quizz 2";
			tabReponse[6][1] = "Voici la reponse 2 de la question 7 du quizz 2";
			tabReponse[6][2] = "Voici la reponse 3 de la question 7 du quizz 2";
			tabReponse[7][0] = "Voici la reponse 1 de la question 8 du quizz 2";
			tabReponse[7][1] = "Voici la reponse 2 de la question 8 du quizz 2";
			tabReponse[7][2] = "Voici la reponse 3 de la question 8 du quizz 2";
			tabReponse[8][0] = "Voici la reponse 1 de la question 9 du quizz 2";
			tabReponse[8][1] = "Voici la reponse 2 de la question 9 du quizz 2";
			tabReponse[8][2] = "Voici la reponse 3 de la question 9 du quizz 2";
			tabReponse[9][0] = "Voici la reponse 1 de la question 10 du quizz 2";
			tabReponse[9][1] = "Voici la reponse 2 de la question 10 du quizz 2";
			tabReponse[9][2] = "Voici la reponse 3 de la question 10 du quizz 2";
			break;
		case 3:
			tabReponse[0][0] = "C’est excellent et stimulant pour la vie de couple.";
			tabReponse[0][1] = "Ça ne concerne que les hommes qui les regardent plus ou moins en cachette.";
			tabReponse[0][2] = "C’est nul et sans intérêt.";
			tabReponse[1][0] = "C’est excellent et stimulant pour la vie de couple.";
			tabReponse[1][1] = "Ça ne concerne que les hommes qui les regardent plus ou moins en cachette.";
			tabReponse[1][2] = "C’est nul et sans intérêt.";
			tabReponse[2][0] = "Carrément indécent Que fait la police !.";
			tabReponse[2][1] = "Tout à fait charmant, c’est bien mieux que les géraniums.";
			tabReponse[2][2] = "Un peu décevant, pourquoi elle a gardé le string.";
			tabReponse[3][0] = "Carrément indécent Que fait la police !.";
			tabReponse[3][1] = "Tout à fait charmant, c’est bien mieux que les géraniums.";
			tabReponse[3][2] = "Un peu décevant, pourquoi elle a gardé le string.";
			tabReponse[4][0] = "Aujourd’hui vous pourriez lui dire, aujourd’hui on part en weekend thalasso !.";
			tabReponse[4][1] = "Allez, on se fait un bon resto !.";
			tabReponse[4][2] = "J’ai acheté du cassoulet, y’avait une promo !.";
			tabReponse[5][0] = "Aujourd’hui vous pourriez lui dire, aujourd’hui on part en weekend thalasso !.";
			tabReponse[5][1] = "Allez, on se fait un bon resto !.";
			tabReponse[5][2] = "J’ai acheté du cassoulet, y’avait une promo !.";
			tabReponse[6][0] = "En voiture.";
			tabReponse[6][1] = "Sous la couette.";
			tabReponse[6][2] = "Dans un magasin de vêtements.";
			tabReponse[7][0] = "En voiture.";
			tabReponse[7][1] = "Sous la couette.";
			tabReponse[7][2] = "Dans un magasin de vêtements.";
			tabReponse[8][0] = "tu l'envoies balader, ce n’est pas ton genre.";
			tabReponse[8][1] = "tu arraches tout en 3 secondes et tu lui saute dessus.";
			tabReponse[8][2] = "tu t’empêtres et finis par terre à tirer sur tes chaussettes.";
			tabReponse[9][0] = "Il vous envoie balader, ce n’est pas son genre.";
			tabReponse[9][1] = "Il arrache tout en 3 secondes et vous saute dessus.";
			tabReponse[9][2] = "Il s’empêtre et finit par terre à tirer sur ces chaussettes.";
			tabReponse[10][0] = "Ma pauvre t’es obligé de te cacher derrière tous ces produits.";
			tabReponse[10][1] = "Ho chérie, ton p’tit côté poupée, ça me chauffe à max !";
			tabReponse[10][2] = "Ho miss monde, laisses-moi la place !";
			tabReponse[11][0] = "Ma pauvre t’es obligé de te cacher derrière tous ces produits.";
			tabReponse[11][1] = "Ho chérie, ton p’tit côté poupée, ça me chauffe à max !";
			tabReponse[11][2] = "Ho miss monde, laisses-moi la place !";
			tabReponse[12][0] = "Crise de jalousie.";
			tabReponse[12][1] = "Crise de rire.";
			tabReponse[12][2] = "Crise d’autorité.";
			tabReponse[13][0] = "Crise de jalousie.";
			tabReponse[13][1] = "Crise de rire.";
			tabReponse[13][2] = "Crise d’autorité.";
			tabReponse[14][0] = "Faire les valises.";
			tabReponse[14][1] = "Faire l’amour.";
			tabReponse[14][2] = "Faire des visites.";
			tabReponse[15][0] = "Faire les valises.";
			tabReponse[15][1] = "Faire l’amour.";
			tabReponse[15][2] = "Faire des visites.";
			tabReponse[16][0] = "Elle est folle.";
			tabReponse[16][1] = "Elle est molle.";
			tabReponse[16][2] = "Quel sex-symbol.";
			tabReponse[17][0] = "Elle est folle.";
			tabReponse[17][1] = "Elle est molle.";
			tabReponse[17][2] = "Quel sex-symbol.";
			tabReponse[18][0] = "il ramasse tes affaires et les met dans le bac à linge.";
			tabReponse[18][1] = "Surexcité, il court pour te rejoindre dans la chambre.";
			tabReponse[18][2] = "Ce soir y'a match, il a d'autres occupations.";
			tabReponse[19][0] = "Tu ramasses ses affaires et les met dans le bac à linge.";
			tabReponse[19][1] = "Surexcité, tu cours pour la rejoindre dans la chambre.";
			tabReponse[19][2] = "Ce soir y'a match, tu as d'autres occupations.";
			break;
		}
	}

	public String afficheReponseQuizz(int q, int n) {
		reponseQuizz(numQuizz);
		return tabReponse[q][n];
	}

}