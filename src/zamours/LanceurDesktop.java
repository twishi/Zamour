package zamours;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class LanceurDesktop {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Love Quiz";
		cfg.useGL20 = true;
		cfg.width = 1280;
		cfg.height = 800;
		
		new LwjglApplication(new Jeu(), cfg);
	}
}