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
	private Texture retourMenu;
	private Texture background;
	private Sprite spritebackground;
	private Circle circleBackButton;
	private int screenWidth, screenHeight;
	int spaceBetweenAnswers;
	int spaceBetweenQuestAnswers;
	int positionQuestion1;
	
	private Sound soundTouchDown;
	private Music musicMenu;
	
	/************* obligé pour le changement de screen *************/
	Jeu game;

	ResultatDuQuiz(Jeu game){
		this.game = game;
	}
	/***************************************************************/
	
	private Texture chocolatFinal;
	private Sprite spriteChocolatFinal;
	

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
		musicMenu.setVolume(0.5f); // permet de baisser le volume de la musique du menu
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
		
		chocolatFinal = new Texture(Gdx.files.internal("chocolatfinal.png"));
		spriteChocolatFinal = new Sprite(chocolatFinal);
		spriteChocolatFinal.setSize(256, 256);
		spriteChocolatFinal.setPosition(screenWidth/2 - 128, screenHeight/2 - 128);
		
		fontmessage1 = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);

		
	}
	
	public void afficheResultat(){
		switch (Jeu.nbRepJuste) {
		/**case 0:
			batch.draw(chocolat10, screenWidth/2, screenHeight/2);
			break;
		case 1:
			batch.draw(chocolat10, screenWidth/2, screenHeight/2);
			break;
		case 2:
			batch.draw(chocolat10, screenWidth/2, screenHeight/2);
			break;
		case 3:
			batch.draw(chocolat10, screenWidth/2, screenHeight/2);
			break;
		case 4:
			batch.draw(chocolat10, screenWidth/2, screenHeight/2);
			break;
		case 5:
			batch.draw(chocolat10, screenWidth/2, screenHeight/2);
			break;
		case 6:
			batch.draw(chocolat10, screenWidth/2, screenHeight/2);
			break;
		case 7:
			batch.draw(chocolat10, screenWidth/2, screenHeight/2);
			break;
		case 8:
			batch.draw(chocolat10, screenWidth/2, screenHeight/2);
			break;*/
		case 9:
			spriteChocolatFinal.draw(batch);
			fontmessage1.drawMultiLine(batch, "Incredible",
					0, screenHeight/2 + screenHeight/3 - screenHeight/9, screenWidth,
					HAlignment.CENTER);
			fontmessage1.drawMultiLine(batch, "Felicitations vous vous connaissez très bien,\nc'est presque un sans faute !",
					0, screenHeight/3 , screenWidth,
					HAlignment.CENTER);
			break;
		case 10:
			spriteChocolatFinal.draw(batch);
			fontmessage1.drawMultiLine(batch, "Amazing",
					0, screenHeight/2 + screenHeight/3 - screenHeight/9, screenWidth,
					HAlignment.CENTER);
			fontmessage1.drawMultiLine(batch, "Felicitations vous vous connaissez sur le bout des doigts,\nc'est un sans faute !",
					0, screenHeight/3 , screenWidth,
					HAlignment.CENTER);
			break;
		}
	}

	public void manipulerMenu() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {
				if (circleBackButton.contains(x, y) && maintenu){
					game.setScreen(new MainMenu(game));
					musicMenu.stop();
				}
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				if(circleBackButton.contains(x, y)){
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
		circleBackButton = new Circle(screenWidth/7 + 5 , screenHeight - screenHeight/8 , 28);

		batch.draw(retourMenu, screenWidth/12, screenHeight/12);		

	}
}