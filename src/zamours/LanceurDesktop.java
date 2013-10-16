package zamours;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class LanceurDesktop {
            public static void main(String[] args) {
                        new LwjglApplication (new Jeu(),"Zamours",480,800,false);
            }
}