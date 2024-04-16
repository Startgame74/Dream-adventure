package com.mygdx.game.Screens;

import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.MovingBackground;

public class MenuScreen implements Screen {
    MyGdxGame myGdxGame;
    Texture menuImg, menuBG;

    public MenuScreen(MyGdxGame game) {
        myGdxGame = game;
        System.out.println("created menuScreen");
        menuBG = new Texture("level\\MenuBackground.png");
        menuImg = new Texture("level\\MenuText.png");
    }

    @Override
    public void show() {
        System.out.println("started menu");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 1, 1, 1);
        myGdxGame.batch.begin();

        myGdxGame.batch.draw(menuBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        myGdxGame.batch.draw(menuImg, SCR_WIDTH/2-600, SCR_HEIGHT/2-400, 1200, 800);

        myGdxGame.batch.end();
        if (Gdx.input.justTouched()) {
            System.out.println("click!");
            myGdxGame.setOnGame();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        //menuBG.dispose();
        menuImg.dispose();
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        System.out.println("menu dispose; exit");
    }
}
