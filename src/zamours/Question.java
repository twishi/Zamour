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
			tabQuestions[2] = "2. S'il �tait un acteur, il serait :";
			tabQuestions[3] = "2. Si tu �tais un acteur, tu serais :";
			tabQuestions[4] = "3. Le voyage qu'elle r�ve de faire serait plut�t :";
			tabQuestions[5] = "3. Ton voyage id�al serait :";
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
			tabQuestions[0] = "1. Elle �crit un roman �rotique dans lequel \nelle d�voile tous ses fantasmes. D'apr�s toi ce serait plut�t du genre : ";
			tabQuestions[1] = "1. Tu �cris un roman �rotique dans lequel \ntu d�voiles tous tes fantasmes. D'apr�s lui ce serait plut�t du genre :  ";
			tabQuestions[2] = "2. Il doit changer de voiture, il opterait pour : ";
			tabQuestions[3] = "2. Tu dois changer de voiture, d'apr�s elle tu opterais pour : ";
			tabQuestions[4] = "3. Tu dois aller � une �mission de t�l�vision ce serait :";
			tabQuestions[5] = "3. Il doit aller � une �mission de t�l�vision ce serait :";
			tabQuestions[6] = "4. Quand une fille lui sourit dans la rue, que pense-t-il aussit�t :";
			tabQuestions[7] = "4. Quand une fille te sourit dans la rue, que penses-tu aussit�t :";
			tabQuestions[8] = "5. Au lit dans le feu de l'action, elle d�chire un de tes v�tements pr�f�r�s. Comment r�agis-tu ?";
			tabQuestions[9] = "5. Au lit dans le feu de l'action, tu d�chires un de ses v�tements pr�f�r�s. Comment r�agit-il ? ";
			tabQuestions[10] = "6. Premi�re journ�e que tu as pass�e enti�rement avec lui, vous l'avez consacr� :";
			tabQuestions[11] = "6. Premi�re journ�e que tu as pass�e enti�rement avec elle, vous l'avez consacr� :";
			tabQuestions[12] = "7. Au restaurant, tu lui dis :";
			tabQuestions[13] = "7. Au restaurant, il te dit :";
			tabQuestions[14] = "8. Lors d'une balade sous un vent glaciale, tu lui demandes sa veste pour te r�chauffer, que te dit-il ?";
			tabQuestions[15] = "8. Lors d'une balade sous un vent glaciale, elle te demande sa veste pour se r�chauffer, que lui dis-tu ?";
			tabQuestions[16] = "9. Elle est au volant, soudain elle cale, la voiture ne veut pas red�marrer, tout le monde klaxonne. Comment r�agis-tu ?";
			tabQuestions[17] = "9. Tu es au volant, soudain tu cales, la voiture ne veut pas red�marrer, tout le monde klaxonne. Comment r�agit-il ?";
			tabQuestions[18] = "10. Si un weekend, il t'entra�ne dans un sex shop :";
			tabQuestions[19] = "10. Si un weekend, tu l'entra�nes dans un sex shop :";
			return tabQuestions[numQuestion];
		case 3:
			tabQuestions[0] = "1. D'apr�s elle, les films ou les sites internet un peu chauds : ";
			tabQuestions[1] = "1. D'apr�s lui, les films ou les sites internet un peu chauds :  ";
			tabQuestions[2] = "2. Votre jolie voisine d'en face se prom�ne en string sur son balcon. il trouve ce spectacle : ";
			tabQuestions[3] = "2. Votre jolie voisine d'en face se prom�ne en string sur son balcon. tu trouves ce spectacle : ";
			tabQuestions[4] = "3. Le mois dernier, si tu avez mis 10 euros dans une tirelire � chaque fois que vous faisiez l'amour : ";
			tabQuestions[5] = "3. Le mois dernier, s'il avait mis 10 euros dans une tirelire � chaque fois que vous faisiez l'amour : ";
			tabQuestions[6] = "4. O� ton sens de l'orientation est-il le plus aiguis� : ";
			tabQuestions[7] = "4. D'apr�s vous o� son sens de l'orientation est-il le plus aiguis� : ";
			tabQuestions[8] = "5. Si elle te dit, fais moi un striptease, comment r�agis-tu ?";
			tabQuestions[9] = "5. Si vous lui dites, fais moi un striptease, comment r�agit-il ?";
			tabQuestions[10] = "6. Quand vous passez du temps � vous pouponner dans la salle de bain, il vous dit : ";
			tabQuestions[11] = "6. Quand elle passe du temps � se pouponner dans la salle de bain, tu lui dit : ";
			tabQuestions[12] = "7. On parle beaucoup de la crise, mais tu es plut�t :";
			tabQuestions[13] = "7. On parle beaucoup de la crise, mais il est plut�t :";
			tabQuestions[14] = "8. Pendant les vacances, qu'est-ce qui te fatigue le plus ? ";
			tabQuestions[15] = "8. Pendant les vacances, qu'est-ce qui la fatigue le plus ? ";
			tabQuestions[16] = "9. La premiere fois que tu l'a vue sur une piste de danse, tu t'es dit :";
			tabQuestions[17] = "9. La premiere fois qu'il t'a vue sur une piste de danse, il s'est dit :";
			tabQuestions[18] = "10. Tu as d�pos� dans toute la maison tes sous-v�tements et tu l'attend sur le lit:";
			tabQuestions[19] = "10. Elle a d�pos� dans toute la maison ses sous-v�tements et t'attends sur le lit:";
			return tabQuestions[numQuestion];
		default:
			return tabQuestions[numQuestion];
		}
	}
}