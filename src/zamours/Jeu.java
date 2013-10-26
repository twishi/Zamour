/*****************************Raccourcis claviers***************************************************

Indenter : Ctrl + Shift + f;
Enlever import qui servent pas : Ctrl + Shift + o;
Deplacer lignes : Alt + Haut/Bas;
Recherche mot selectionné: Ctrl + k;
Supprimer ligne: Ctrl + d;
Dupliquer lignes = Ctrl + Alt + Haut;

 */
package zamours;

import com.badlogic.gdx.Game;


public class Jeu extends Game
{
	static boolean desactiveMusicMenu = false;
	static boolean desactiveSoundTouchDown  = false;
	static int numeroQuestionQuiz;
	static int nbRepJuste;
	
	public static boolean getDesactiveMusicMenu(){
		return desactiveMusicMenu;
	}
	
	public static void setDesactiveMusicMenu(boolean b){
		desactiveMusicMenu = b;
	}
	
	public static boolean getDesactiveSoundTouchDown(){
		return desactiveSoundTouchDown;
	}
	
	public static void setDesactiveSoundTouchDown(boolean b){
		desactiveSoundTouchDown = b;
	}
	
	public static boolean quizTermine(){
		return numeroQuestionQuiz == 21;
	}
	

	@Override
	public void create() {
		setScreen(new ImageDebut(this));

	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void resume() {
		super.resume();
	}

}