package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Text {
    int x, y;
    float fontSize;
    BitmapFont font;
    public Text(int x, int y, float fontSize) {
        this.x = x;
        this.y = y;
        this.fontSize = fontSize;

        font = new BitmapFont();//Gdx.files.internal("Font\\Planes_ValMore.ttf"), false);
        font.getData().setScale(fontSize);
        font.setColor(new Color(0, 0, 0, 1.0f));
    }

    public void show(Batch b, String toDraw) {
       font.draw(b, toDraw, x, y);
    }
    public void dispose() {
        font.dispose();
    }
}
