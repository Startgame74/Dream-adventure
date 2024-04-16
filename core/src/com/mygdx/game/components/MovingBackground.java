package com.mygdx.game.components;



import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.characters.Player;

public class MovingBackground {
    public Texture background;
    //public int BG_WIDTH = this.background.getWidth() * (SCR_HEIGHT / this.background.getHeight());
    public MovingBackground(Texture bg) {
        this.background = bg;
    }
    public void show(Batch b, Player player) {b.draw(background, player.textureX, 0, this.background.getWidth() * ((float) SCR_HEIGHT / this.background.getHeight()), SCR_HEIGHT);}

    public void move() {

    }

    public void dispose() {
        background.dispose();
    }
}
