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

public class Options implements Screen {
	
	private float xDoigt, yDoigt;
	boolean maintenu;

	private SpriteBatch batch;
	private Texture retourMenu;
	private Texture options;
	private Texture optionsPressed;
	private Texture play;
	private Texture playPressed;
	private Texture background;
	private Texture noteMusique;
	private Texture noteMusiqueBarre;
	Rectangle rectangleQuest1;
	Rectangle rectangleQuest2;
	Rectangle rectangleQuest3;
	private Texture sonoOn;
	private Texture sonoOff;

	int screenWidth, screenHeight;
	int spaceBetweenAnswers;
	int spaceBetweenQuestAnswers;
	int positionQuestion1;
	
	Sound soundTouchDown;
	Music musicMenu;
	
	Jeu game;

	Options(Jeu game){
		this.game = game;
	}
	

	@Override
	public void show() {
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
				Gdx.files.internal("background_options_s2.png"));



		/********************************** Placement des rectangles ****************************************************************/
		retourMenu = new Texture(Gdx.files.internal("retour.png"));
		options = new Texture(Gdx.files.internal("Options.png"));
		optionsPressed = new Texture(Gdx.files.internal("OptionsPressed.png"));
		/********************************** Placement des 3 rectangles ****************************************************************/
		play = new Texture(Gdx.files.internal("Play.png"));
		playPressed = new Texture(Gdx.files.internal("PlayPressed.png"));



		/*********************************************************************************************************************************/
		
		/****** les boutons pour le son *****/
		noteMusique = new Texture(Gdx.files.internal("pics_note_musique.png"));
		noteMusiqueBarre = new Texture(Gdx.files.internal("pics_note_musique_barre.png"));
		sonoOn = new Texture(Gdx.files.internal("pics_sono_on.png"));
		sonoOff = new Texture(Gdx.files.internal("pics_sono_off.png"));

		
	}

	public void manipulerMenu() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {
				/** couper ou remettre la musique **/
				if (rectangleQuest2.contains(x, y)){
					if(Jeu.getDesactiveMusicMenu()){
						Jeu.setDesactiveMusicMenu(false);
					} else {
						Jeu.setDesactiveMusicMenu(true);
					}
					musicMenu.stop();
				}
				/** couper ou remettre le bruit des touches **/
				if (rectangleQuest3.contains(x, y)){
					if(Jeu.getDesactiveSoundTouchDown()){
						Jeu.setDesactiveSoundTouchDown(false);
					} else {
						Jeu.setDesactiveSoundTouchDown(true);
					}
				}
				xDoigt = 0;
				yDoigt = 0;
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				if(rectangleQuest1.contains(x, y) || rectangleQuest2.contains(x, y)){
					if (Jeu.getDesactiveSoundTouchDown() == false)
						soundTouchDown.play();
				}
				if (rectangleQuest1.contains(x, y)){
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
		// TODO Auto-generated method stub
		
	}

	public void afficheBouton() {
		/** bouton retour **/
		rectangleQuest1 = new Rectangle(screenWidth/10, screenHeight - screenHeight/10, 40, 80);
		/** note musique **/
		rectangleQuest2 = new Rectangle(screenWidth/2 - 20, screenHeight/2, 40, 80);
		/** sono **/
		rectangleQuest3 = new Rectangle(screenWidth/2 - 40, screenHeight/2 +screenHeight/8, 80,46);

		batch.draw(retourMenu, screenWidth/10, screenHeight/10);		

		if (rectangleQuest2.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(noteMusiqueBarre, screenWidth/2 - 20, screenHeight/2);
		} else {
			batch.draw(noteMusique, screenWidth/2 - 20, screenHeight/2);
		}
		if (rectangleQuest3.contains(xDoigt, yDoigt) && maintenu) {
			batch.draw(sonoOff, screenWidth/2 - 20, screenHeight/2 -screenHeight/8);
		} else {
			batch.draw(sonoOn, screenWidth/2 - 20, screenHeight/2 -screenHeight/8);
		}
	}
}