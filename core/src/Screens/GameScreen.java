package Screens;

import Player.Player;
import World.world;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen{

	Game kastlegame;
	world w;
	Player p;
	SpriteBatch batch;
	OrthographicCamera cam;
	Viewport view;
	public GameScreen(Game game) {
		// TODO Auto-generated constructor stub
		kastlegame = game;
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		handleInput();
		}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		cam = new OrthographicCamera(1280,720);
		cam.position.set(64*10, 64*6, 0);
		view = new StretchViewport(1280,720,cam);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(view.getCamera().combined);
		w = new world(64, 16);
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
	public void handleInput()
	{
		if(Gdx.input.isKeyPressed(Keys.W))
		{
			cam.translate(0, 8, 0);
		}
		if(Gdx.input.isKeyPressed(Keys.S))
		{
			cam.translate(0, -8, 0);
		}
		if(Gdx.input.isKeyPressed(Keys.A))
		{
			cam.translate(-8, 0, 0);
		}
		if(Gdx.input.isKeyPressed(Keys.D))
		{
			cam.translate(8, 0, 0);
		}
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		w.draw(batch);
		if(Gdx.input.justTouched()){
			Vector3 touchVec= new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
			touchVec = cam.unproject(touchVec);
			touchVec.set((int) touchVec.x/64, (int) touchVec.y/64, 0);
			w.setWorld((int)touchVec.x,(int) touchVec.y, 0, 2);
		}
		if(Gdx.input.isButtonPressed(Buttons.RIGHT))
		{
			Vector3 touchVec= new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
			touchVec = cam.unproject(touchVec);
			touchVec.set((int) touchVec.x/64, (int) touchVec.y/64, 0);
			w.setWorld((int)touchVec.x,(int) touchVec.y, 0, 1);
		
		}
	}
}
