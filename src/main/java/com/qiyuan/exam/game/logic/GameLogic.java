package com.qiyuan.exam.game.logic;

import com.qiyuan.exam.game.entity.GameMap;
import com.qiyuan.exam.game.entity.Point;
import com.qiyuan.exam.game.entity.Soldier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liuxishan
 * @date 2024/7/5
 */
public class GameLogic {
    private static final GameLogic instance = new GameLogic();

    public static GameLogic getInstance() {
        return instance;
    }

    /**
     * 获取所有合法动作
     * @param gameMap
     * @param soldier
     * @return
     */
   public List<int[][]> getAllAction(GameMap gameMap, Soldier soldier) {
       List<int[][]> allActions = new ArrayList<>();
       List<Point> movePoints = gameMap.getAccessiblePoint(soldier.getPoint(), soldier.getMoveDistance());
       for (Point point : movePoints) {
           List<Point> attackPoints = gameMap.getAccessiblePoint(point, soldier.getAttackDistance());
           for (Point attackPoint : attackPoints) {
               allActions.add(new int[][]{{point.getX(), point.getY()}, {attackPoint.getX(), attackPoint.getY()}});
           }
       }
       return allActions;
   }
}
