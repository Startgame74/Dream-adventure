package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class TextButton {
    BitmapFont font;
    String text;
    public Texture button;

    int x, y;
    int textX, textY;
    int buttonWidth, buttonHeight;
    int textWidth, textHeight;

    public TextButton(Texture btn, int x, int y, String text) {
        this.button = btn;
        this.x = x;
        this.y = y;
        this.text = text;

        font = new BitmapFont();
        font.getData().setScale(7f);
        font.setColor(0, 1, 0, 1);

        GlyphLayout gl = new GlyphLayout(font, text);
        textWidth = (int) gl.width;
        textHeight = (int) gl.height;

        buttonWidth = button.getWidth();
        buttonHeight = button.getHeight();

        textX = this.x + (buttonWidth - textWidth) / 2;
        textY = this.y + (buttonHeight + textHeight) / 2;
    }

    public void show(Batch b) {
        b.draw(button, x, y, buttonWidth, buttonHeight);
        font.draw(b, text, textX, textY);
    }

    public boolean isClicked(int tX, int tY) {
        return tX >= this.x && tX <= this.x + this.buttonWidth && tY >= this.y && tY <= this.y + this.buttonHeight;
    }

    public void dispose() {
        button.dispose();
        font.dispose();
    }
}
