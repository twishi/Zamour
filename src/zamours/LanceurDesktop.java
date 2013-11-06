package zamours;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class LanceurDesktop {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Love Quiz";
		cfg.useGL20 = true;
		cfg.width = 720;
		cfg.height = 1280;
		
		new LwjglApplication(new Jeu(), cfg);
	}
}