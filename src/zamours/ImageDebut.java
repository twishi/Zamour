package zamours;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImageDebut implements Screen{
	private SpriteBatch batch;
	private Texture imageDebut;
	private Sprite spriteImageDebut;
	private TweenManager tweenManager;
	int screenWidth, screenHeight;
	Music musicDebut;
	
	Jeu game;
	
	ImageDebut(Jeu game){
		this.game = game;
	}

	@Override
	public void dispose() {
		batch.dispose();
		spriteImageDebut.getTexture().dispose();
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		
		batch.begin();
		spriteImageDebut.draw(batch);
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
	public void show() {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		musicDebut = Gdx.audio.newMusic(Gdx.files.internal("Sound/music_debut.wav"));
		musicDebut.play();
		
		batch = new SpriteBatch();
		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new ImageDebutEffet());
		imageDebut=new Texture(Gdx.files.internal("hommefemme.png"));
		spriteImageDebut = new Sprite(imageDebut);
		spriteImageDebut.setSize(screenWidth, screenHeight);
		
		
		Tween.set(spriteImageDebut, ImageDebutEffet.ALPHA).target(0).start(tweenManager);
		Tween.to(spriteImageDebut, ImageDebutEffet.ALPHA, 2).target(1).repeatYoyo(1, 2).setCallback(new TweenCallback(){
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				game.setScreen(new MainMenu(game));
				
			}
			
		}).start(tweenManager);
	}

}
