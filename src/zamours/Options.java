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

public class Options implements Screen {
	
	boolean maintenu;

	private SpriteBatch batch;
	private Texture retourMenu;
	private Texture background;
	private Texture noteMusique;
	private Texture noteMusiqueBarre;
	private Circle circleBackButton;
	private Rectangle rectangleMusic;
	private Rectangle rectangleSono;
	private Texture sonoOn;
	private Texture sonoOff;

	int screenWidth, screenHeight;
	int spaceBetweenAnswers;
	int spaceBetweenQuestAnswers;
	int positionQuestion1;
	
	private Sound soundTouchDown;
	private Music musicMenu;
	
	private Jeu game;

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


		retourMenu = new Texture(Gdx.files.internal("backbutton1.png"));


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
				if (rectangleMusic.contains(x, y)){
					if(Jeu.getDesactiveMusicMenu()){
						Jeu.setDesactiveMusicMenu(false);
					} else {
						Jeu.setDesactiveMusicMenu(true);
					}
					musicMenu.stop();
				}
				/** couper ou remettre le bruit des touches **/
				if (rectangleSono.contains(x, y)){
					if(Jeu.getDesactiveSoundTouchDown()){
						Jeu.setDesactiveSoundTouchDown(false);
					} else {
						Jeu.setDesactiveSoundTouchDown(true);
					}
				}
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				if(circleBackButton.contains(x, y) || rectangleMusic.contains(x, y)){
					if (Jeu.getDesactiveSoundTouchDown() == false)
						soundTouchDown.play();
				}
				if (circleBackButton.contains(x, y)){
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
		circleBackButton = new Circle(screenWidth/7 + 5 , screenHeight - screenHeight/8 , 28);
		/** note musique **/
		rectangleMusic = new Rectangle(screenWidth/2 - 20, screenHeight/2 - 80, 40, 80);
		/** sono **/
		rectangleSono = new Rectangle(screenWidth/2 - 40, screenHeight/2 +screenHeight/8 - 46, 80,46);

		batch.draw(retourMenu, screenWidth/12, screenHeight/12);		

		if (Jeu.desactiveMusicMenu) {
			batch.draw(noteMusiqueBarre, screenWidth/2 - 20, screenHeight/2);
		} else {
			batch.draw(noteMusique, screenWidth/2 - 20, screenHeight/2);
		}
		if (Jeu.desactiveSoundTouchDown) {
			batch.draw(sonoOff, screenWidth/2 - 20, screenHeight/2 -screenHeight/8);
		} else {
			batch.draw(sonoOn, screenWidth/2 - 20, screenHeight/2 -screenHeight/8);
		}
	}
}