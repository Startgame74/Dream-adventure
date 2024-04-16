package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player {
    public Texture[] spritesArray;
    public Sprite sprite;
    public boolean state=true;

    public int textureX;

    public int curSprite = 0;
    public float runningSpeed = 0f;
    public int speed = 5;
    public int x, y;
    public int delay = 10, curDelay = 0;

    public Player(Texture[] sprites, int x, int y) {
        this.x = x;
        this.y = y;
        this.spritesArray = sprites;
    }

    public void moveForward() {
        state = false;
        this.runningSpeed += 0.05f;
        if(this.runningSpeed>=0.4f)
            this.runningSpeed = 0.4f;
        textureX += speed += (int) this.runningSpeed;
        curDelay++;
        if (curDelay == delay) {
            curSprite++;
            curDelay=0;
        }
        if (curSprite >= spritesArray.length)
            curSprite = 0;
    }
    public void stand() {
        this.runningSpeed = 0f;
    }
    public void moveBackward() {
        state = true;
        this.runningSpeed -= 0.05f;
        if(this.runningSpeed<=-0.4f)
            this.runningSpeed = -0.4f;
        textureX -= speed += (int) this.runningSpeed;
        curDelay++;
        if (curDelay == delay) {
            curSprite++;
            curDelay=0;
        }
        if (curSprite >= spritesArray.length)
            curSprite = 0;
    }
    public void show(Batch b) {
        this.sprite = new Sprite(this.spritesArray[curSprite]);
        this.sprite.setX(this.x);
        this.sprite.setY(this.y);
        if (!this.state)
            sprite.flip(true, false);
        this.sprite.draw(b);
    }
}
