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
				Gdx.files.internal("background_options_s2.png"));
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
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 1:
			spriteChocolatFinal1.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 2:
			spriteChocolatFinal2.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 3:
			spriteChocolatFinal3.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 4:
			spriteChocolatFinal4.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 5:
			spriteChocolatFinal5.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 6:
			spriteChocolatFinal6.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 7:
			spriteChocolatFinal7.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 8:
			spriteChocolatFinal8.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 9:
			spriteChocolatFinal9.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
							0, screenHeight / 3, screenWidth, HAlignment.CENTER);
			break;
		case 10:
			spriteChocolatFinal10.draw(batch);
			fontmessage1.drawMultiLine(batch, "Amazing", 0, screenHeight / 2
					+ screenHeight / 3 - screenHeight / 9, screenWidth,
					HAlignment.CENTER);
			fontmessage1
					.drawMultiLine(
							batch,
							"Felicitations vous vous connaissez sur le bout des doigts,\nc'est un sans faute !",
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