package zamours;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MainMenu implements Screen {
	private float xDoigt, yDoigt;
	boolean maintenu;

	private SpriteBatch batch;
	private Texture background, play, playPressed, options, optionsPressed, quitter, quitterPressed;
	private Sprite spritebackground, spritePlay, spritePlayPressed,
			spriteOptions, spriteOptionsPressed, spriteQuitter, spriteQuitterPressed;
	private Rectangle rectanglePlay, rectangleOptions, rectangleQuitter;
	int screenWidth, screenHeight, posXbuttons, posYPlay, posYOptions, posYQuitter,
			posXrectangles, posYrectPlay, posYrectOptions, posYrectQuitter, rectanglesHeight,
			rectanglesWidth;
	private TweenManager tweenManager;

	Jeu game;

	MainMenu(Jeu game) {
		this.game = game;
	}

	@Override
	public void show() {
		if (Jeu.getDesactiveMusicMenu() == false) {
			Jeu.musicMenu.play();
		} else {
			Jeu.musicMenu.stop();
		}
		Jeu.musicMenu.setVolume(0.5f); // permet de baisser le volume de la
		// musique du menu
		Texture.setEnforcePotImages(false);
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		// j'ai diminue de 50 les Yboutons et Yrect pour mettre les boutons plus bas
		posXbuttons = 400;
		posYPlay = 500;
		posYOptions = 350;
		posYQuitter = 200;
		
		posXrectangles = 443;
		posYrectPlay = 200;
		posYrectOptions = 350;
		posYrectQuitter = 500;
		
		rectanglesWidth = 387;
		rectanglesHeight = 90;

		background = new Texture(
				Gdx.files.internal("background_menu_1280_800.png"));
//		background = new Texture(
//		Gdx.files.internal("background_red_marco_1280_800.png"));
		play = new Texture(Gdx.files.internal("Jouer_480_800.png"));
		playPressed = new Texture(Gdx.files.internal("Jouer_clicked_480_800.png"));
		options = new Texture(Gdx.files.internal("Options_480_800.png"));
		optionsPressed = new Texture(
				Gdx.files.internal("Options_clicked_480_800.png"));
		quitter = new Texture(Gdx.files.internal("Quitter_480_800.png"));
		quitterPressed = new Texture(Gdx.files.internal("Quitter_clicked_480_800.png"));

		batch = new SpriteBatch();

		spritebackground = new Sprite(background);
		spritebackground.setSize(screenWidth, screenHeight);

		/********************************** Placement des boutons ****************************************************************/

		spritePlay = new Sprite(play);
		spritePlayPressed = new Sprite(playPressed);
		spriteOptions = new Sprite(options);
		spriteOptionsPressed = new Sprite(optionsPressed);
		spriteQuitter = new Sprite(quitter);
		spriteQuitterPressed = new Sprite(quitterPressed);

		spritePlay.setPosition(posXbuttons, posYPlay);
		spritePlayPressed.setPosition(posXbuttons, posYPlay);
		spriteOptions.setPosition(posXbuttons, posYOptions);
		spriteOptionsPressed.setPosition(posXbuttons, posYOptions);
		spriteQuitter.setPosition(posXbuttons, posYQuitter);
		spriteQuitterPressed.setPosition(posXbuttons, posYQuitter);

		/*********************************************************************************************************************************/
		/****************************************** Effet **********************************************************************************/
		tweenManager = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());

		Timeline.createSequence()
				.beginSequence()
				.push(Tween.set(spritePlay, ActorAccessor.ALPHA).target(0))
				.push(Tween.set(spriteOptions, ActorAccessor.ALPHA).target(0))
				.push(Tween.set(spriteQuitter, ActorAccessor.ALPHA).target(0))
				.push(Tween.to(spritePlay, ActorAccessor.ALPHA, .6f).target(1))
				.push(Tween.to(spriteOptions, ActorAccessor.ALPHA, .6f).target(1))
				.push(Tween.to(spriteQuitter, ActorAccessor.ALPHA, .6f).target(
						1)).end().start(tweenManager);
		/********************************************************************************************************************************/
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 0);

		manipulerMenu(); // gestion des input

		batch.begin();
		spritebackground.draw(batch);
		afficheBouton();
		batch.end();

		tweenManager.update(delta);

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
		rectanglePlay = new Rectangle(posXrectangles, posYrectPlay,
				rectanglesWidth, rectanglesHeight);
		rectangleOptions = new Rectangle(posXrectangles, posYrectOptions,
				rectanglesWidth, rectanglesHeight);
		rectangleQuitter = new Rectangle(posXrectangles, posYrectQuitter,
				rectanglesWidth, rectanglesHeight);

		if (rectanglePlay.contains(xDoigt, yDoigt) && maintenu) {
			spritePlayPressed.draw(batch);
		} else {
			spritePlay.draw(batch);
		}
		
		if (rectangleOptions.contains(xDoigt, yDoigt) && maintenu) {
			spriteOptionsPressed.draw(batch);
		} else {
			spriteOptions.draw(batch);
		}
		
		if (rectangleQuitter.contains(xDoigt, yDoigt) && maintenu) {
			spriteQuitterPressed.draw(batch);
		} else {
			spriteQuitter.draw(batch);
		}
	}

	public void changementScreen(int x, int y) {
		if (rectanglePlay.contains(x, y) && maintenu) {
			game.setScreen(new ChoixQuiz(game));
		} else if (rectangleOptions.contains(x, y) && maintenu) {
			game.setScreen(new Options(game));
		} else if (rectangleQuitter.contains(x, y) && maintenu) {
			Gdx.app.exit();
		
	}
}

	public void soundTouchDown(int x, int y) {
		if (rectanglePlay.contains(x, y) || rectangleOptions.contains(x, y) || rectangleQuitter.contains(x, y)) {
			if (Jeu.getDesactiveMusicMenu() == false) {
				Jeu.musicMenu.setVolume(0.5f);
			} else {
				Jeu.musicMenu.setVolume(0.f);
			}
			if (Jeu.getDesactiveSoundTouchDown() == false)
				Jeu.soundTouchDown.play();
		}
	}

	public void manipulerMenu() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {
				changementScreen(x, y);
				xDoigt = 0;
				yDoigt = 0;
				maintenu = false;
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {
				soundTouchDown(x, y);
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