package zamours;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MainMenu implements Screen {
	private float xDoigt, yDoigt;
	boolean maintenu;

	private SpriteBatch batch;
	private Texture play;
	private Texture playPressed;
	private Texture options;
	private Texture optionsPressed;
	private Texture background;
	Rectangle rectangleQuest1;
	Rectangle rectangleQuest2;
	int screenWidth, screenHeight;
	int spaceBetweenAnswers;
	int spaceBetweenQuestAnswers;
	int positionQuestion1;
	
	Sound soundTouchDown;
	Music musicMenu;
	
	
	Jeu game;

	MainMenu(Jeu game){
		this.game = game;
	}
	

	@Override
	public void show() {
		soundTouchDown = Gdx.audio.newSound(Gdx.files.internal("Sound/sound_click_down.wav"));
		musicMenu = Gdx.audio.newMusic(Gdx.files.internal("Sound/music_menu.wav"));
		musicMenu.setLooping(true);
		if (Jeu.getDesactiveMusicMenu() == false){
			musicMenu.play();
		}else {
			musicMenu.stop();
		}
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
				Gdx.files.internal("menu1.png"));



		/********************************** Placement des 3 rectangles ****************************************************************/


		play = new Texture(Gdx.files.internal("Play.png"));
		playPressed = new Texture(Gdx.files.internal("PlayPressed.png"));
		options = new Texture(Gdx.files.internal("Options.png"));
		optionsPressed = new Texture(Gdx.files.internal("OptionsPressed.png"));


		/*********************************************************************************************************************************/
	}

	public void manipulerMenu() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {
				if (rectangleQuest1.contains(x, y) && maintenu){
					game.setScreen(new ChoixQuiz(game));
					musicMenu.setVolume(0.f);
				} else if (rectangleQuest2.contains(x, y) && maintenu){
					game.setScreen(new Options(game));
					musicMenu.setVolume(0.f);
				}
				xDoigt = 0;
				yDoigt = 0;
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				if(rectangleQuest1.contains(x, y) || rectangleQuest2.contains(x, y)){
					if (Jeu.getDesactiveMusicMenu() == false){
						musicMenu.setVolume(0.5f);
					}else {
						musicMenu.setVolume(0.f);
					}
					if (Jeu.getDesactiveSoundTouchDown() == false)
						soundTouchDown.play();
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
		// TODO Auto-generated method stub
		
	}

	public void afficheBouton() {
		rectangleQuest1 = new Rectangle(67, screenHeight - 544 - 71, 348, 58);
		rectangleQuest2 = new Rectangle(67, screenHeight - 383 - 80, 348, 58);


		if (rectangleQuest1.contains(xDoigt, yDoigt) && maintenu) {

			batch.draw(playPressed, 32, 550);

		} else {
			batch.draw(play, 32, 550);
		}
		if (rectangleQuest2.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(optionsPressed, 32, 400);
		} else {
			batch.draw(options, 32, 400);

		}
	}
}