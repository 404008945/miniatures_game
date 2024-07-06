package com.qiyuan.exam.game.entity;

/**
 * 士兵类
 * @author liuxishan
 * @date 2024/7/5
 */
public class Soldier {


    private Point point;


    /**
     * 移动范围
     */
    private int moveDistance;

    /**
     * 攻击范围
     */
    private int attackDistance;


    public Soldier(Point point, int moveDistance, int attackDistance) {
        this.point = point;
        this.moveDistance = moveDistance;
        this.attackDistance = attackDistance;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void setMoveDistance(int moveDistance) {
        this.moveDistance = moveDistance;
    }

    public int getAttackDistance() {
        return attackDistance;
    }

    public void setAttackDistance(int attackDistance) {
        this.attackDistance = attackDistance;
    }
}
