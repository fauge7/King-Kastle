package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SplashScreen implements Screen{

	SpriteBatch batch;
	OrthographicCamera cam;
	Viewport view;
	Texture t;
	Sprite s;
	BitmapFont font;
	private float alpha = 1f;
	private float time = 0;
	private float timer = 2.5f;
	Game game;
	private boolean skip = false;
	
	public SplashScreen(Game g){
		this.game = g;
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		updateSkip();
		batch.begin();
		s.draw(batch);
		batch.end();
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		//view.update(width, height);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		cam = new OrthographicCamera(1600,900);
		view = new StretchViewport(1600,900,cam);
		cam.position.set(800,450, 0);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		font = new BitmapFont();
		t = new Texture("splash.png");
		s = new Sprite(t);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	public void updateSkip() {
		//detect input
		if(Gdx.input.justTouched()){
			skip = true;
		}
		//if there is input or the time is up change screens
		if(time > timer || skip){
			alpha -= .01f;
			s.setColor(1f, 1f, 1f, alpha);
			if (s.getColor().a == 0.0f) {
				game.setScreen(new GameScreen(game));
			}
		} 
		else {
			time += Gdx.graphics.getDeltaTime();
		}
	}
	public void fadeto() {
		
	}
}
