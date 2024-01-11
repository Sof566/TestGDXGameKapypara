package com.mygdx.game;

public class MyButton {
    int x, y;
    int width, height;

    public MyButton(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    boolean hit(float tx, float ty) {
        return x<tx & tx<x+width & y<ty & ty<y+height;
    }
}
