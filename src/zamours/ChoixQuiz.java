package zamours;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class ChoixQuiz implements Screen {
	
	private float xDoigt, yDoigt;
	boolean maintenu;

	private SpriteBatch batch;
	private Texture retourMenu;
	private Texture background;
	private Texture chocolat1;
	private Rectangle rectangleQuiz1;
	private Circle circleBackButton;
	private int screenWidth, screenHeight;
	int spaceBetweenAnswers;
	int spaceBetweenQuestAnswers;
	int positionQuestion1;
	
	private Sound soundTouchDown;
	private Music musicMenu;
	
	/************* obligé pour le changement de screen *************/
	Jeu game;

	ChoixQuiz(Jeu game){
		this.game = game;
	}
	/***************************************************************/

	@Override
	public void show() {
		retourMenu = new Texture(Gdx.files.internal("backbutton1.png"));
		soundTouchDown = Gdx.audio.newSound(Gdx.files.internal("Sound/sound_click_down.wav"));
		musicMenu = Gdx.audio.newMusic(Gdx.files.internal("Sound/music_menu.wav"));
		if (Jeu.getDesactiveMusicMenu() == false){
			musicMenu.play();
		}else {
			musicMenu.stop();
		}
		musicMenu.setLooping(true);
		/** musicMenu.setVolume(0.5f); **/ // permet de baisser le volume de la musique du menu
		Texture.setEnforcePotImages(false);
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		spaceBetweenAnswers = screenHeight / 6;
		spaceBetweenQuestAnswers = screenHeight / 4;
		positionQuestion1 = screenHeight / 2 + screenHeight / 7;
		batch = new SpriteBatch();
		/**
		 * xhdpi: 640x960 px hdpi: 480x800 px mdpi: 320x480 px ldpi: 240x320 px
		 */
		background = new Texture(
				Gdx.files.internal("background_choix_quiz_s2.png"));


		
		/****** texture chocolat  *****/
		chocolat1 = new Texture(Gdx.files.internal("pics_chocolat_1.jpg"));
		
	}

	public void manipulerMenu() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {
				if (circleBackButton.contains(x, y) && maintenu){
					game.setScreen(new MainMenu(game));
					musicMenu.stop();
				} else if (rectangleQuiz1.contains(x, y) && maintenu){
					game.setScreen(new Quiz1(game));
					musicMenu.stop();
				}
				xDoigt = 0;
				yDoigt = 0;
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				if(circleBackButton.contains(x, y) || rectangleQuiz1.contains(x, y)){
					if (Jeu.getDesactiveSoundTouchDown() == false)
						soundTouchDown.play();
				}
				if (circleBackButton.contains(x, y)){
					game.setScreen(new MainMenu(game));
					musicMenu.stop();
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
		batch.draw(background, 0, 0);
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
		rectangleQuiz1 = new Rectangle(screenWidth/2 - 75, screenHeight/2 - 130, 150, 130);


		batch.draw(retourMenu, screenWidth/15, screenHeight - screenHeight/10);		

		if (rectangleQuiz1.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(chocolat1, screenWidth/2 - 80, screenHeight/2);
		} else {
			batch.draw(chocolat1, screenWidth/2 - 75, screenHeight/2);

		}
	}
}