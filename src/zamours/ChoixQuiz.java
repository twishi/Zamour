package zamours;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
	private Texture retourMenu;
	private Texture background;
	private Sprite spritebackground;
	private Texture chocolat1;
	private Texture chocolat2;
	private Texture chocolat3;
	private Texture chocolat4;
	private Texture chocolat5;
	private Texture resteChocolat;
	private Rectangle rectangleQuiz1;
	private Rectangle rectangleQuiz2;
	private Rectangle rectangleQuiz3;
	private Rectangle rectangleQuiz4;
	private Rectangle rectangleQuiz5;
	private Circle circleBackButton;
	private int screenWidth, screenHeight;
	int spaceBetweenAnswers;
	int spaceBetweenQuestAnswers;
	int positionQuestion1;
	
	
	/************* obligé pour le changement de screen *************/
	Jeu game;

	ChoixQuiz(Jeu game){
		this.game = game;
	}
	/***************************************************************/

	@Override
	public void show() {
		retourMenu = new Texture(Gdx.files.internal("backbutton1.png"));
		if(Jeu.getDesactiveMusicMenu() == false){
			Jeu.musicMenu.setVolume(0.5f); // permet de baisser le volume de la musique du menu
		} else {
			Jeu.musicMenu.setVolume(0.f);
		}
		
		Texture.setEnforcePotImages(false);
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		spaceBetweenAnswers = screenHeight / 6;
		spaceBetweenQuestAnswers = screenHeight / 4;
		positionQuestion1 = screenHeight / 2 + screenHeight / 7;
		batch = new SpriteBatch();

		background = new Texture(
				Gdx.files.internal("background_choix_quiz_s2.png"));
		spritebackground = new Sprite(background);
		spritebackground.setSize(screenWidth, screenHeight);

		
		/****** texture chocolat  *****/
		chocolat1 = new Texture(Gdx.files.internal("chocolat1.png"));
		chocolat2 = new Texture(Gdx.files.internal("chocolat2.png"));
		chocolat3 = new Texture(Gdx.files.internal("chocolat3.png"));
		chocolat4 = new Texture(Gdx.files.internal("chocolat4.png"));
		chocolat5 = new Texture(Gdx.files.internal("chocolat5.png"));
		resteChocolat = new Texture(Gdx.files.internal("restechocolat.png"));
		
	}

	public void manipulerMenu() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {
				if (circleBackButton.contains(x, y) && maintenu){
					game.setScreen(new MainMenu(game));
				} else if (rectangleQuiz1.contains(x, y) && maintenu){
					game.setScreen(new Quiz1(game));
					Jeu.musicMenu.stop();
				}
				xDoigt = 0;
				yDoigt = 0;
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				if(circleBackButton.contains(x, y) || rectangleQuiz1.contains(x, y) || rectangleQuiz2.contains(x, y) || rectangleQuiz3.contains(x, y)
						|| rectangleQuiz4.contains(x, y) || rectangleQuiz5.contains(x, y)){
					if (Jeu.getDesactiveSoundTouchDown() == false)
						Jeu.soundTouchDown.play();
				}
				if (circleBackButton.contains(x, y)){
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
		
	}

	public void afficheBouton() {
		circleBackButton = new Circle( screenWidth/15 + 34, 47, 26);
		
		rectangleQuiz1 = new Rectangle(20, screenHeight/2 - 80 - 128, 128, 128);
		rectangleQuiz2 = new Rectangle(170, screenHeight/2 - 80 - 128, 128, 128);
		rectangleQuiz3 = new Rectangle(320, screenHeight/2 - 80 - 128, 128, 128);
		rectangleQuiz4 = new Rectangle(95, screenHeight/2 + 80 - 128, 128, 128);
		rectangleQuiz5 = new Rectangle(245, screenHeight/2 + 80 - 128, 128, 128);


		batch.draw(retourMenu, screenWidth/15, screenHeight - screenHeight/10);		

		if (rectangleQuiz1.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(resteChocolat, 20, screenHeight/2 + 80);
		} else {
			batch.draw(chocolat1, 20, screenHeight/2 + 80);
		}
		if (rectangleQuiz2.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(resteChocolat, 170, screenHeight/2 + 80);
		} else {
			batch.draw(chocolat2, 170, screenHeight/2 + 80);
		}
		if (rectangleQuiz3.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(resteChocolat, 320, screenHeight/2 + 80);
		} else {
			batch.draw(chocolat3, 320, screenHeight/2 + 80);
		}
		if (rectangleQuiz4.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(resteChocolat, 95, screenHeight/2 - 80);
		} else {
			batch.draw(chocolat4, 95, screenHeight/2 - 80);
		}
		if (rectangleQuiz5.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(resteChocolat, 245, screenHeight/2 - 80);
		} else {
			batch.draw(chocolat5, 245, screenHeight/2 - 80);
		}
	}
}