package zamours;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class Jeu implements ApplicationListener {

	private SpriteBatch batch;
	private Texture background;
	private BitmapFont fontmessage1 ;
	Question quest1;
	Reponse rep1;
	int screenWidth, screenHeight;

	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("background_blue_s2.png"));
		fontmessage1 = new BitmapFont();
		quest1 = new Question(2);
		rep1 = new Reponse(2);

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0,0);
		fontmessage1.draw(batch, quest1.afficheQuestionQuizz(0), screenWidth/5, screenHeight - screenHeight/10);
		fontmessage1.draw(batch, rep1.afficheReponseQuizz(0), 100, 300);
		fontmessage1.draw(batch, rep1.afficheReponseQuizz(1), 100, 200);
		fontmessage1.draw(batch, rep1.afficheReponseQuizz(2), 100, 100);
		batch.end();
	}


	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	public void gestionDesEntrees() {
		Gdx.input.setInputProcessor(new InputProcessor() {

			public boolean mouseMoved(int x, int y) {

				return false;
			}

			@Override
			public boolean touchUp(int x, int y, int arg2, int arg3) {

				return false;
			}

			@Override
			public boolean touchDragged(int x, int y, int arg2) {
				return false;
			}

			@Override
			public boolean touchDown(int x, int y, int arg2, int arg3) {
				return false;
			}

			@Override
			public boolean scrolled(int arg0) {
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