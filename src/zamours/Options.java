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

public class Options implements Screen {
	
	boolean maintenu;

	private SpriteBatch batch;
	private Texture background, retourMenu, noteMusique, noteMusiqueBarre, sonoOn, sonoOff;
	private Sprite spritebackground;
	private Circle circleBackButton;
	private Rectangle rectangleMusic, rectangleSono;

	int screenWidth, screenHeight, spaceBetweenAnswers, spaceBetweenQuestAnswers, positionQuestion1;
	
	private Jeu game;

	Options(Jeu game){
		this.game = game;
	}
	

	@Override
	public void show() {
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

		retourMenu = new Texture(Gdx.files.internal("backbutton1.png"));


		/****** les boutons pour le son *****/
		noteMusique = new Texture(Gdx.files.internal("pics_note_musique.png"));
		noteMusiqueBarre = new Texture(Gdx.files.internal("pics_note_musique_barre.png"));
		sonoOn = new Texture(Gdx.files.internal("pics_sono_on.png"));
		sonoOff = new Texture(Gdx.files.internal("pics_sono_off.png"));

		
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
	
	public void soundTouchDown(int x, int y){
		if(circleBackButton.contains(x, y) || rectangleMusic.contains(x, y) || rectangleSono.contains(x,y)){
			if (Jeu.getDesactiveSoundTouchDown() == false)
				Jeu.soundTouchDown.play();
		}
		if (circleBackButton.contains(x, y)){
			game.setScreen(new MainMenu(game));
			Jeu.musicMenu.setVolume(0.5f);
		}
		/** couper ou remettre la musique **/
		if (rectangleMusic.contains(x, y)){
			if(Jeu.getDesactiveMusicMenu()){
				Jeu.setDesactiveMusicMenu(false);
				Jeu.musicMenu.setVolume(0.5f);
			} else {
				Jeu.setDesactiveMusicMenu(true);
				Jeu.musicMenu.setVolume(0.f);
			}
		}
		/** couper ou remettre le bruit des touches **/
		if (rectangleSono.contains(x, y)){
			if(Jeu.getDesactiveSoundTouchDown()){
				Jeu.setDesactiveSoundTouchDown(false);
			} else {
				Jeu.setDesactiveSoundTouchDown(true);
			}
		}
	}
	
	
	public void manipulerMenu() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				soundTouchDown(x, y);
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