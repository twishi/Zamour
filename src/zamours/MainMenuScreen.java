/**package zamours;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class MainMenuScreen implements Screen {

	Sound sound = Gdx.audio.newSound(Gdx.files.internal("sound/maracas.wav"));
	private Texture background;

	Skin skin;
	Stage stage;

	MyGame game;

	// constructor to keep a reference to the main Game class
	public MainMenuScreen(MyGame pgame) {

		Texture.setEnforcePotImages(false);
		background = new Texture(Gdx.files.internal("background_blue_s2.png"));
		this.game = pgame;

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		// Texture.setEnforcePotImages(false);
		skin = new Skin(Gdx.files.internal("ui/defaultskin.json"));

		Table table = new Table();
		table.setSize(800, 480);

		final TextButton startGame = new TextButton("Commencer Quizz", skin);
		table.add(startGame).width(200).height(50);
		table.row();

		TextButton options = new TextButton("Options", skin);
		table.add(options).width(150).padTop(10).padBottom(3);
		table.row();

		TextButton credits = new TextButton("Credits", skin);
		table.add(credits).width(150);
		table.row();

		TextButton quit = new TextButton("Quitter", skin);
		table.add(quit).width(100).padTop(10);
		table.row();

		stage.addActor(table);

		startGame.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				sound.play();
				startGame.addAction(Actions.fadeOut(0.5f));
				game.setScreen(game.quizzScreen);
			}
		});
	}

	@Override
	public void render(float delta) {
		// clear the screen
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// let the stage act and draw
		stage.act(delta);
		stage.draw();
		stage.setViewport(800, 480, false);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		// called when this screen is set as the screen with game.setScreen();
	}

	@Override
	public void hide() {
		// called when current screen changes from this to a different screen
		stage.dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		// never called automatically
		stage.dispose();
	}
}*/