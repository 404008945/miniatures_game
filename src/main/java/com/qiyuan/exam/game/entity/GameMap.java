package com.qiyuan.exam.game.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * 游戏地图试图
 *
 * @author liuxishan
 * @date 2024/7/5
 */
public class GameMap {
     /**
      * 地图宽
      */
    private int width;
     /**
      * 地图高
      */
    private int height;



    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    /**
     * 以point为中心点，输出所有可达的坐标
     * @param point
     * @param maxDistance
     * @return
     */
    public List<Point> getAccessiblePoint(Point point, int maxDistance) {
        // 中心点
        int centerX = point.getX();
        int centerY = point.getY();
        List<Point> allPoints = new ArrayList<>();
        int upY = getValidY(centerY - maxDistance);
        int downY = getValidY(centerY + maxDistance);
        for (int y = upY; y <= downY; y++) {
            int dy = maxDistance - Math.abs(centerY - y);
            for (int x = getValidX(centerX - dy); x <= getValidY(centerX + dy); x++) {
                allPoints.add(new Point(x, y));
            }
        }
        return allPoints;
    }

    private int getValidX(int x) {
        if (x < 0) {
            return 0;
        } else if (x >= height) {
            //按照题目的图示，x坐标从0开始
            return height - 1;
        }
        return x;
    }

    private int getValidY(int y) {
        if (y < 0) {
            return 0;
        } else if (y >= width) {
            //按照题目的图示，x坐标从0开始
            return width - 1;
        }
        return y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
