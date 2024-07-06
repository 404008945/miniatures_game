package com.qiyuan.exam.game.entity;

/**
 * 代表地图一个点
 * @author liuxishan
 * @date 2024/7/5
 */
public class Point {

    /**
     * 地图坐标x
     */
    private int x;

    /**
     * 地图坐标y
     */
    private int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
