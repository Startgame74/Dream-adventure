package com.mygdx.game.components;

import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.characters.Player;

public class CollidingRect {
    Texture texture;
    int w, h, x, y;
    public CollidingRect(Texture image, int width, int height, int x, int y){
        this.texture = image;
        this.w = width;
        this.h = height;
        this.x = x;
        this.y = y;
    }
    void calcPosition(Player p){
        this.x = SCR_WIDTH/2 - p.x;
    }
    void show(Batch b){
        b.draw(this.texture, this.x, this.y, this.w, this.h);
    }
}
