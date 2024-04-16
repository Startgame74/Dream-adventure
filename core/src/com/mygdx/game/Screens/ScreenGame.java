package com.mygdx.game.Screens;

import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.characters.Player;
import com.mygdx.game.components.MovingBackground;
import com.sun.security.auth.NTSidUserPrincipal;

public class ScreenGame implements Screen {
    MyGdxGame myGdxGame;
    Texture[] framesArray;
    MovingBackground gameBG, decorations, floor;
    Player player;
    public ScreenGame(MyGdxGame myGdxGame) {
        this.framesArray = myGdxGame.framesArray;
        this.player = new Player(framesArray, SCR_WIDTH/2-300, 80);
        this.myGdxGame = myGdxGame;
        System.out.println("created");
    }

    @Override
    public void show() {
        gameBG = new MovingBackground(new Texture("level\\layer_1.png"));
        decorations = new MovingBackground(new Texture("level\\layer_2.png"));
        //floor = new Texture();
        System.out.println("showed");
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isTouched()) {
            if (Gdx.input.getX()>SCR_WIDTH/2)
                player.moveBackward();
            else
                player.moveForward();
        } else {
            player.stand();
            System.out.println("stand");
        }
        ScreenUtils.clear(0,1,1,1);
        myGdxGame.batch.begin();
        gameBG.show(myGdxGame.batch, player);
        decorations.show(myGdxGame.batch, player);
        player.show(myGdxGame.batch);
        myGdxGame.batch.end();
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
        myGdxGame.batch.dispose();
    }
}
