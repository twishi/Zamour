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

	int screenWidth, screenHeight, posXback, posYback, rayonBack, posXbuttons, 
		posYsound, posYclick, posYRectMusic, posYRectSono, widthRectSono, heightRectSono, widthRectMusic, heightRectMusic;
	
	private Jeu game;

	Options(Jeu game){
		this.game = game;
	}
	

	@Override
	public void show() {
		Texture.setEnforcePotImages(false);
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		if (screenWidth == 480 && screenHeight == 800) {
			
			posXback = screenWidth/7 + 5;
			posYback = screenHeight - screenHeight/8;
			rayonBack = 28;
			posXbuttons = screenWidth/2 - 20;
			posYsound = screenHeight/2;
			posYclick = screenHeight/2 -screenHeight/8;
			posYRectMusic = screenHeight/2 - 80;
			posYRectSono = screenHeight/2 + 50;
			widthRectSono = 80;
			heightRectSono = 50;
			widthRectMusic = 40;
			heightRectMusic = 80;
			
			/****** les boutons pour le son *****/
			noteMusique = new Texture(Gdx.files.internal("pics_note_musique.png"));
			noteMusiqueBarre = new Texture(Gdx.files.internal("pics_note_musique_barre.png"));
			sonoOn = new Texture(Gdx.files.internal("pics_sono_on.png"));
			sonoOff = new Texture(Gdx.files.internal("pics_sono_off.png"));
			

		}
		else if(screenWidth == 720 && screenHeight == 1280){
			posXback = 92;
			posYback = screenHeight - 95;
			rayonBack = 23;
			posXbuttons = screenWidth/2 - 40;
			posYsound = screenHeight/2 + 40;
			posYclick = screenHeight/2 - screenHeight/8;
			posYRectMusic = screenHeight/2 + 100;
			posYRectSono = screenHeight/2 + 265;
			widthRectSono = 100;
			heightRectSono = 55;
			widthRectMusic = 70;
			heightRectMusic = 80;
			
			/****** les boutons pour le son *****/
			noteMusique = new Texture(Gdx.files.internal("pics_note_musique_s3.png"));
			noteMusiqueBarre = new Texture(Gdx.files.internal("pics_note_musique_barre_s3.png"));
			sonoOn = new Texture(Gdx.files.internal("pics_sono_on_s3.png"));
			sonoOff = new Texture(Gdx.files.internal("pics_sono_off_s3.png"));
			
		}
		
		batch = new SpriteBatch();

		background = new Texture(
				Gdx.files.internal("background_options_s2.png"));
		spritebackground = new Sprite(background);
		spritebackground.setSize(screenWidth, screenHeight);

		retourMenu = new Texture(Gdx.files.internal("backbutton1.png"));


		

		
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
		circleBackButton = new Circle( posXback, posYback , rayonBack);
		/** note musique **/
		rectangleMusic = new Rectangle(posXbuttons, posYRectMusic, widthRectMusic, heightRectMusic);
		/** sono **/
		rectangleSono = new Rectangle(posXbuttons, posYRectSono, widthRectSono,heightRectSono);

		batch.draw(retourMenu, screenWidth/12, screenHeight/12);		

		if (Jeu.desactiveMusicMenu) {
			batch.draw(noteMusiqueBarre, posXbuttons, posYsound);
		} else {
			batch.draw(noteMusique, posXbuttons, posYsound);
		}
		if (Jeu.desactiveSoundTouchDown) {
			batch.draw(sonoOff, posXbuttons, posYclick);
		} else {
			batch.draw(sonoOn, posXbuttons, posYclick);
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