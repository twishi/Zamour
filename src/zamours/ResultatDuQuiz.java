package zamours;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

public class ResultatDuQuiz implements Screen {

	private boolean maintenu;
	private BitmapFont fontmessage1;
	private SpriteBatch batch;
	private Texture background, retourMenu, chocolatFinal0, chocolatFinal1,
			chocolatFinal2, chocolatFinal3, chocolatFinal4, chocolatFinal5,
			chocolatFinal6, chocolatFinal7, chocolatFinal8, chocolatFinal9,
			chocolatFinal10;
	private Sprite spritebackground, spriteChocolatFinal0,
			spriteChocolatFinal1, spriteChocolatFinal2, spriteChocolatFinal3,
			spriteChocolatFinal4, spriteChocolatFinal5, spriteChocolatFinal6,
			spriteChocolatFinal7, spriteChocolatFinal8, spriteChocolatFinal9,
			spriteChocolatFinal10;
	private Circle circleBackButton;
	int screenWidth, screenHeight, spaceBetweenAnswers,
			spaceBetweenQuestAnswers, positionQuestion1;

	private Sound soundTouchDown;
	private Music musicMenu;

	/************* obligé pour le changement de screen *************/
	Jeu game;

	ResultatDuQuiz(Jeu game) {
		this.game = game;
	}

	/***************************************************************/

	@Override
	public void show() {
		retourMenu = new Texture(Gdx.files.internal("backbutton1.png"));
		soundTouchDown = Gdx.audio.newSound(Gdx.files
				.internal("Sound/sound_click_down.wav"));
		musicMenu = Gdx.audio.newMusic(Gdx.files
				.internal("Sound/music_menu.wav"));
		if (Jeu.getDesactiveMusicMenu() == false) {
			musicMenu.play();
		} else {
			musicMenu.stop();
		}
		musicMenu.setLooping(true);
		musicMenu.setVolume(0.5f); // permet de baisser le volume de la musique
									// du menu
		Texture.setEnforcePotImages(false);
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		spaceBetweenAnswers = screenHeight / 6;
		spaceBetweenQuestAnswers = screenHeight / 4;
		positionQuestion1 = screenHeight / 2 + screenHeight / 7;

		batch = new SpriteBatch();
		background = new Texture(
				Gdx.files.internal("background_options_choix_quiz_1280_800.png"));
		spritebackground = new Sprite(background);
		spritebackground.setSize(screenWidth, screenHeight);

		chocolatFinal0 = new Texture(Gdx.files.internal("0_rep_ok.png"));
		chocolatFinal1 = new Texture(Gdx.files.internal("1_rep_ok.png"));
		chocolatFinal2 = new Texture(Gdx.files.internal("2_rep_ok.png"));
		chocolatFinal3 = new Texture(Gdx.files.internal("3_rep_ok.png"));
		chocolatFinal4 = new Texture(Gdx.files.internal("4_rep_ok.png"));
		chocolatFinal5 = new Texture(Gdx.files.internal("5_rep_ok.png"));
		chocolatFinal6 = new Texture(Gdx.files.internal("6_rep_ok.png"));
		chocolatFinal7 = new Texture(Gdx.files.internal("7_rep_ok.png"));
		chocolatFinal8 = new Texture(Gdx.files.internal("8_rep_ok.png"));
		chocolatFinal9 = new Texture(Gdx.files.internal("9_rep_ok.png"));
		chocolatFinal10 = new Texture(Gdx.files.internal("10_rep_ok.png"));
		spriteChocolatFinal0 = new Sprite(chocolatFinal0);
		spriteChocolatFinal1 = new Sprite(chocolatFinal1);
		spriteChocolatFinal2 = new Sprite(chocolatFinal2);
		spriteChocolatFinal3 = new Sprite(chocolatFinal3);
		spriteChocolatFinal4 = new Sprite(chocolatFinal4);
		spriteChocolatFinal5 = new Sprite(chocolatFinal5);
		spriteChocolatFinal6 = new Sprite(chocolatFinal6);
		spriteChocolatFinal7 = new Sprite(chocolatFinal7);
		spriteChocolatFinal8 = new Sprite(chocolatFinal8);
		spriteChocolatFinal9 = new Sprite(chocolatFinal9);
		spriteChocolatFinal10 = new Sprite(chocolatFinal10);

		spriteChocolatFinal0.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal1.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal2.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal3.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal4.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal5.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal6.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal7.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal8.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal9.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);
		spriteChocolatFinal10.setPosition(screenWidth / 2 - 128,
				screenHeight / 2 - 128);

		fontmessage1 = new BitmapFont(Gdx.files.internal("font/white.fnt"),
				false);

	}

	public void afficheResultat() {
		switch (Jeu.nbRepJuste) {
		case 0:
			spriteChocolatFinal0.draw(batch);
			fontmessage1.drawMultiLine(batch, "0/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Ola... votre score est de 0 reponse juste. Il y a surement des moments où l'un a du mal à comprendre\n"
							+ "l'autre et même à le supporter, mais cela n'empêche pas du tout d'envisager une union positive,\nle couple "
							+ "construit avec le temps des bases solides. Peut-être que vous n'êtes pas tombés sur des questions\nqui étaient "
							+ "en votre faveur. En attendant, c'est le pire score qui soit ! Essayez un autre Quiz, il sera difficile\nde faire"
							+ " moins bien !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 1:
			spriteChocolatFinal1.draw(batch);
			fontmessage1.drawMultiLine(batch, "1/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							":/ ... Votre score est de 1 reponse juste. Vous n'avez pas pris le temps de réfléchir,\n"
							+ "ou alors votre partenaire cache bien son jeu ! Vous êtes peut être sur la même longueur d'onde,\n"
							+ "mais ne connaissez pas encore votre partenaire comme il se doit.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 2:
			spriteChocolatFinal2.draw(batch);
			fontmessage1.drawMultiLine(batch, "2/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							":/ ... Votre score est de 2 reponse juste. Vous n'avez pas pris le temps de réfléchir,\n"
									+ "ou alors votre partenaire cache bien son jeu ! Vous êtes peut être sur la même longueur d'onde,\n"
									+ "mais ne connaissez pas encore votre partenaire comme il se doit.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 3:
			spriteChocolatFinal3.draw(batch);
			fontmessage1.drawMultiLine(batch, "3/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							":/ ... Votre score est de 3 reponse juste. Vous n'avez pas pris le temps de réfléchir,\n"
									+ "ou alors votre partenaire cache bien son jeu ! Vous êtes peut être sur la même longueur d'onde,\n"
									+ "mais ne connaissez pas encore votre partenaire comme il se doit.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 4:
			spriteChocolatFinal4.draw(batch);
			fontmessage1.drawMultiLine(batch, "4/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							":/ ... Votre score est de 4 reponse juste. Vous n'avez pas pris le temps de réfléchir,\n"
									+ "ou alors votre partenaire cache bien son jeu ! Vous êtes peut être sur la même longueur d'onde,\n"
									+ "mais ne connaissez pas encore votre partenaire comme il se doit.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 5:
			spriteChocolatFinal5.draw(batch);
			fontmessage1.drawMultiLine(batch, "5/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"C'est tout juste la moyenne, votre score est de 5 reponses juste.\n"
							+ "Vous vous connaissez plutot bien, mais il reste encore des parties chez votre\n"
							+ "partenaire à découvrir.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 6:
			spriteChocolatFinal6.draw(batch);
			fontmessage1.drawMultiLine(batch, "6/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"A peine plus que la moyenne, votre score est de 6 reponses juste.\n"
							+ "C'est pas mal, mais vous pouvez surement faire mieux !\n"
							+ "Vous êtes plutot proche l'un de l'autre mais manquez peut être encore d'experience.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 7:
			spriteChocolatFinal7.draw(batch);
			fontmessage1.drawMultiLine(batch, "7/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"C'est très bien, votre score est de 7 reponses juste.\n"
							+ "Vous vous comprennez, et vous avez appris à vous connaître avec le temps.\n"
							+ "Votre couple doit faire envier vos amis, vous êtes très proche.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 8:
			spriteChocolatFinal8.draw(batch);
			fontmessage1.drawMultiLine(batch, "8/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"C'est très bien, votre score est de 8 reponses juste.\n"
									+ "Vous vous comprennez, et vous avez appris à vous connaître avec le temps.\n"
									+ "Votre couple doit faire envier vos amis, vous êtes très proche.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 9:
			spriteChocolatFinal9.draw(batch);
			fontmessage1.drawMultiLine(batch, "9/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"C'est presque un sans faute ! Votre score est de 9 reponses juste, c'est dommage\n"
							+ "il ne manquait pas grand chose pour atteindre le score parfait.\n"
							+ "Vous êtes très proche et connaissez très bien les réactions de votre partenaire\n"
							+ "suivant la situation. Vous êtes sans doute ensemble depuis un moment.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 10:
			spriteChocolatFinal10.draw(batch);
			fontmessage1.drawMultiLine(batch, "10/10", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Bravo !! c'est un sans faute ! Votre score est de 10 reponses juste, vous vous connaissez\n"
							+ "sur le bout des doigts. Rien ne vous échappe, vous êtes très complices et sur la même\n"
							+ "longueur d'onde. Votre couple forme l'association parfaite.\n"
							+ "Une très longue histoire est envisageable.",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void render(float arg0) {

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);

		manipulerMenu(); // gestion des input
		batch.begin();
		spritebackground.draw(batch);
		afficheBouton();
		afficheResultat();
		batch.end();

	}

	@Override
	public void resize(int arg0, int arg1) {
	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {
		dispose();

	}

	public void afficheBouton() {
		circleBackButton = new Circle(screenWidth / 7 + 5, screenHeight
				- screenHeight / 8, 28);

		batch.draw(retourMenu, screenWidth / 12, screenHeight / 12);

	}

	public void manipulerMenu() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {
				if (circleBackButton.contains(x, y) && maintenu) {
					game.setScreen(new MainMenu(game));
					musicMenu.stop();
				}
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				if (circleBackButton.contains(x, y)) {
					if (Jeu.getDesactiveSoundTouchDown() == false)
						soundTouchDown.play();
				}
				if (circleBackButton.contains(x, y)) {
					game.setScreen(new MainMenu(game));
					musicMenu.stop();
				}
				maintenu = true;
				return false;
			}

			@Override
			public boolean touchDragged(int arg0, int arg1, int arg2) {
				return false;
			}

			@Override
			public boolean scrolled(int arg0) {
				return false;
			}

			@Override
			public boolean mouseMoved(int arg0, int arg1) {
				return false;
			}

			@Override
			public boolean keyUp(int arg0) {
				return false;
			}

			@Override
			public boolean keyTyped(char arg0) {
				return false;
			}

			@Override
			public boolean keyDown(int arg0) {
				return false;
			}
		});
	}

}