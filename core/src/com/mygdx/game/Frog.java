package com.mygdx.game;

import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.math.MathUtils;

public class Frog {
    int x, y;
    int vx, vy;
    int width, height;

    public Frog(int x, int y, int vx, int vy, int width, int height) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.width = width;
        this.height = height;
    }

    void move() {
        y+=vy;
    }

    void moveUp() {
        y-=vy;
    }


    void respawn() {
        vy = 2;
        x = (int)MathUtils.random(0, SCR_WIDTH-width);
        y = -98;
    }

    void respawnUp() {
        vx = 2;
        x = (int)MathUtils.random(0, SCR_WIDTH-width);
        y = (int)SCR_HEIGHT;
    }

    boolean hit(float tx, float ty) {
        return x<tx & tx<x+width & y<ty & ty<y+height;
    }



}
