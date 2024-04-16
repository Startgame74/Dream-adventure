package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.MenuScreen;
import com.mygdx.game.Screens.ScreenGame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public Texture[] framesArray;
	public OrthographicCamera camera = new OrthographicCamera();
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SCR_WIDTH = screenSize.width, SCR_HEIGHT = screenSize.height;
	MenuScreen menuScreen;
	ScreenGame screenGame;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		batch = new SpriteBatch();

		framesArray = new Texture[]{
				new Texture("playerAnimation\\run_1.png"),
				new Texture("playerAnimation\\run_2.png"),
				new Texture("playerAnimation\\run_3.png"),
				new Texture("playerAnimation\\run_4.png"),
				new Texture("playerAnimation\\run_5.png"),
				new Texture("playerAnimation\\run_6.png")
		};

		setOnMenu();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
	public void setOnMenu(){
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}
	public void setOnGame() {
		screenGame = new ScreenGame(this);
		setScreen(screenGame);
	}
}
