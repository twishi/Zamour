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
			tabQuestions[2] = "2. S'il était un acteur, il serait :";
			tabQuestions[3] = "2. Si tu étais un acteur, tu serais :";
			tabQuestions[4] = "3. Le voyage qu'elle rêve de faire serait plutôt :";
			tabQuestions[5] = "3. Ton voyage idéal serait :";
			tabQuestions[6] = "4. En discothèque, il serait plutôt :";
			tabQuestions[7] = "4. En discothèque, tu serais plutôt : ";
			tabQuestions[8] = "5. Si elle était un film\nelle serait :";
			tabQuestions[9] = "5. Si tu etais un film tu serais :";
			tabQuestions[10] = "6. S'il ne pouvait partir en voyage\navec qui rêverais-tu de partir :";
			tabQuestions[11] = "6. Si tu ne pouvais partir en voyage\n avec qui rêverait-elle de partir :";
			tabQuestions[12] = "7. A la maison elle est plutôt :";
			tabQuestions[13] = "7. A la maison tu es plutôt :";
			tabQuestions[14] = "8. Sa boisson préférée c'est :";
			tabQuestions[15] = "8. Ta boisson préférée c'est :";
			tabQuestions[16] = "9. Sa meilleure amie est :";
			tabQuestions[17] = "9. Ta meilleure amie est :";
			tabQuestions[18] = "10. S'il était un animal\nil serait :";
			tabQuestions[19] = "10. Si tu étais un animal tu serais :";
			return tabQuestions[numQuestion];
		case 2:
			tabQuestions[0] = "1. Elle écrit un roman érotique dans lequel \nelle dévoile tous ses fantasmes. D'après toi ce serait plutôt du genre : ";
			tabQuestions[1] = "1. Tu écris un roman érotique dans lequel \ntu dévoiles tous tes fantasmes. D'après lui ce serait plutôt du genre :  ";
			tabQuestions[2] = "2. Il doit changer de voiture, il opterait pour : ";
			tabQuestions[3] = "2. Tu dois changer de voiture, d'après elle tu opterais pour : ";
			tabQuestions[4] = "3. Tu dois aller à une émission de télévision ce serait :";
			tabQuestions[5] = "3. Il doit aller à une émission de télévision ce serait :";
			tabQuestions[6] = "4. Quand une fille lui sourit dans la rue, que pense-t-il aussitôt :";
			tabQuestions[7] = "4. Quand une fille te sourit dans la rue, que penses-tu aussitôt :";
			tabQuestions[8] = "5. Au lit dans le feu de l'action, elle déchire un de tes vêtements préférés. Comment réagis-tu ?";
			tabQuestions[9] = "5. Au lit dans le feu de l'action, tu déchires un de ses vêtements préférés. Comment réagit-il ? ";
			tabQuestions[10] = "6. Première journée que tu as passée entièrement avec lui, vous l'avez consacré :";
			tabQuestions[11] = "6. Première journée que tu as passée entièrement avec elle, vous l'avez consacré :";
			tabQuestions[12] = "7. Au restaurant, tu lui dis :";
			tabQuestions[13] = "7. Au restaurant, il te dit :";
			tabQuestions[14] = "8. Lors d'une balade sous un vent glaciale, tu lui demandes sa veste pour te réchauffer, que te dit-il ?";
			tabQuestions[15] = "8. Lors d'une balade sous un vent glaciale, elle te demande sa veste pour se réchauffer, que lui dis-tu ?";
			tabQuestions[16] = "9. Elle est au volant, soudain elle cale, la voiture ne veut pas redémarrer, tout le monde klaxonne. Comment réagis-tu ?";
			tabQuestions[17] = "9. Tu es au volant, soudain tu cales, la voiture ne veut pas redémarrer, tout le monde klaxonne. Comment réagit-il ?";
			tabQuestions[18] = "10. Si un weekend, il t'entraîne dans un sex shop :";
			tabQuestions[19] = "10. Si un weekend, tu l'entraînes dans un sex shop :";
			return tabQuestions[numQuestion];
		case 3:
			tabQuestions[0] = "1. D'après elle, les films ou les sites internet un peu chauds : ";
			tabQuestions[1] = "1. D'après lui, les films ou les sites internet un peu chauds :  ";
			tabQuestions[2] = "2. Votre jolie voisine d'en face se promène en string sur son balcon. il trouve ce spectacle : ";
			tabQuestions[3] = "2. Votre jolie voisine d'en face se promène en string sur son balcon. tu trouves ce spectacle : ";
			tabQuestions[4] = "3. Le mois dernier, si tu avez mis 10 euros dans une tirelire à chaque fois que vous faisiez l'amour : ";
			tabQuestions[5] = "3. Le mois dernier, s'il avait mis 10 euros dans une tirelire à chaque fois que vous faisiez l'amour : ";
			tabQuestions[6] = "4. Où ton sens de l'orientation est-il le plus aiguisé : ";
			tabQuestions[7] = "4. D'après vous où son sens de l'orientation est-il le plus aiguisé : ";
			tabQuestions[8] = "5. Si elle te dit, fais moi un striptease, comment réagis-tu ?";
			tabQuestions[9] = "5. Si vous lui dites, fais moi un striptease, comment réagit-il ?";
			tabQuestions[10] = "6. Quand vous passez du temps à vous pouponner dans la salle de bain, il vous dit : ";
			tabQuestions[11] = "6. Quand elle passe du temps à se pouponner dans la salle de bain, tu lui dit : ";
			tabQuestions[12] = "7. On parle beaucoup de la crise, mais tu es plutôt :";
			tabQuestions[13] = "7. On parle beaucoup de la crise, mais il est plutôt :";
			tabQuestions[14] = "8. Pendant les vacances, qu'est-ce qui te fatigue le plus ? ";
			tabQuestions[15] = "8. Pendant les vacances, qu'est-ce qui la fatigue le plus ? ";
			tabQuestions[16] = "9. La premiere fois que tu l'a vue sur une piste de danse, tu t'es dit :";
			tabQuestions[17] = "9. La premiere fois qu'il t'a vue sur une piste de danse, il s'est dit :";
			tabQuestions[18] = "10. Tu as déposé dans toute la maison tes sous-vêtements et tu l'attend sur le lit:";
			tabQuestions[19] = "10. Elle a déposé dans toute la maison ses sous-vêtements et t'attends sur le lit:";
			return tabQuestions[numQuestion];
		default:
			return tabQuestions[numQuestion];
		}
	}
}