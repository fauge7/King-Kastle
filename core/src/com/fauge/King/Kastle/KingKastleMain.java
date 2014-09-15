package com.fauge.King.Kastle;

import Screens.GameScreen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class KingKastleMain extends Game implements ApplicationListener{
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
