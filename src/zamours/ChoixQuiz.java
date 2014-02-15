package zamours;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class ChoixQuiz implements Screen {

	private float xDoigt, yDoigt;
	boolean maintenu;

	private SpriteBatch batch;
	private Texture background, retourMenu, chocolat1, chocolat2, chocolat3,
			chocolat1Clicked, chocolat2Clicked, chocolat3Clicked;
	private Sprite spritebackground;
	private Rectangle rectangleQuiz1, rectangleQuiz2, rectangleQuiz3;
	private Circle circleBackButton;
	int screenWidth, screenHeight, posXchoc, posYchoc1, posYchoc2, posYchoc3,
			posXclick, posYclickChoc1, posYclickChoc2, posYclickChoc3, widthChoc,
			heightChoc, posXback, posYback, rayonBack;

	/************* obligé pour le changement de screen *************/
	Jeu game;

	ChoixQuiz(Jeu game) {
		this.game = game;
	}

	/***************************************************************/

	@Override
	public void show() {
		if (Jeu.getDesactiveMusicMenu() == false) {
			Jeu.musicMenu.setVolume(0.5f); // permet de baisser le volume de la
											// musique du menu
		} else {
			Jeu.musicMenu.setVolume(0.f);
		}

		Texture.setEnforcePotImages(false);

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		// j'ai diminue de 50 les Yboutons et Yrect pour mettre les boutons plus bas
		posXchoc = 400;
		posYchoc1 = 500;
		posYchoc2 = 350;
		posYchoc3 = 200;
		
		posXclick = 443;
		posYclickChoc1 = 200;
		posYclickChoc2 = 350;
		posYclickChoc3 = 500;
		widthChoc = 387;
		heightChoc = 90;

		posXback = 70;
		posYback = 710;
		rayonBack = 35;

		chocolat1 = new Texture(Gdx.files.internal("Quiz1_480_800.png"));
		chocolat2 = new Texture(Gdx.files.internal("Quiz2_480_800.png"));
		chocolat3 = new Texture(Gdx.files.internal("Quiz3_480_800.png"));

		background = new Texture(
				Gdx.files.internal("background_red_marco_1280_800.png"));

		batch = new SpriteBatch();
		retourMenu = new Texture(Gdx.files.internal("backbutton1.png"));

		spritebackground = new Sprite(background);
		spritebackground.setSize(screenWidth, screenHeight);

		/****** texture chocolat *****/

		chocolat1Clicked = new Texture(
				Gdx.files.internal("Quiz1_clicked_480_800.png"));
		chocolat2Clicked = new Texture(
				Gdx.files.internal("Quiz2_clicked_480_800.png"));
		chocolat3Clicked = new Texture(
				Gdx.files.internal("Quiz3_clicked_480_800.png"));

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
		circleBackButton = new Circle(posXback, posYback, rayonBack);

		rectangleQuiz1 = new Rectangle(posXchoc + 43, posYclickChoc1, widthChoc,
				heightChoc);
		rectangleQuiz2 = new Rectangle(posXchoc + 43, posYclickChoc2, widthChoc,
				heightChoc);
		rectangleQuiz3 = new Rectangle(posXchoc + 43, posYclickChoc3, widthChoc,
				heightChoc);

		batch.draw(retourMenu, 50, 50);

		if (rectangleQuiz1.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(chocolat1Clicked, posXchoc, posYchoc1);
		} else {
			batch.draw(chocolat1, posXchoc, posYchoc1);
		}
		if (rectangleQuiz2.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(chocolat2Clicked, posXchoc, posYchoc2);
		} else {
			batch.draw(chocolat2, posXchoc, posYchoc2);
		}
		if (rectangleQuiz3.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(chocolat3Clicked, posXchoc, posYchoc3);
		} else {
			batch.draw(chocolat3, posXchoc, posYchoc3);
		}

	}

	public void screenTouchUp(int x, int y) {
		if (rectangleQuiz1.contains(x, y) && maintenu) {
			game.setScreen(new Quiz1(game));
			Jeu.musicMenu.stop();
		}
		if (rectangleQuiz2.contains(x, y) && maintenu) {
			game.setScreen(new Quiz2(game));
			Jeu.musicMenu.stop();
		}
		if (rectangleQuiz3.contains(x, y) && maintenu) {
			game.setScreen(new Quiz3(game));
			Jeu.musicMenu.stop();
		}
	}

	public void manipulerMenu() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {
				screenTouchUp(x, y);
				xDoigt = 0;
				yDoigt = 0;
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				if (circleBackButton.contains(x, y)
						|| rectangleQuiz1.contains(x, y)
						|| rectangleQuiz2.contains(x, y)
						|| rectangleQuiz3.contains(x, y)) {
					if (Jeu.getDesactiveSoundTouchDown() == false)
						Jeu.soundTouchDown.play();
				}
				if (circleBackButton.contains(x, y)) {
					game.setScreen(new MainMenu(game));
				}
				xDoigt = x;
				yDoigt = y;
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