/**package zamours;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class MyGame extends Game {

	MainMenuScreen mainMenuScreen;

	Jeu quizzScreen;

	@Override
	public void create() {
		// quizzScreen = new Jeu(this);
		mainMenuScreen = new MainMenuScreen(this);
		setScreen(mainMenuScreen);

	}
}*/