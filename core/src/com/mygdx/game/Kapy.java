package com.mygdx.game;

import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.math.MathUtils;

public class Kapy {
    int x, y;
    int vx;
    int width, height;


    public Kapy(int x, int y, int vx, int width, int height) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.width = width;
        this.height = height;
    }


    void move() {
        x -= vx;
    }

    void happy(){
        x -= vx*5;
    }

    void respawn() {
        x = (int)SCR_WIDTH;
        y = 155;
        vx = 5;
        width = height = 564;
        System.out.println("kapy respawn");
    }

    void respawn_mand() {
        x = MathUtils.random(0, 871);
        y = MathUtils.random(0, 100);
        System.out.println("kapy_mand respawn");
    }


    boolean hit(float tx, float ty) {
        return x<tx & tx<x+width & y<ty & ty<y+height;
    }

}