package com.qiyuan.exam.game;

import com.qiyuan.exam.game.entity.GameMap;
import com.qiyuan.exam.game.entity.Point;
import com.qiyuan.exam.game.entity.Soldier;
import com.qiyuan.exam.game.logic.GameLogic;
import com.qiyuan.exam.game.util.JsonUtil;

import java.util.List;
import java.util.Scanner;

/**
 * @author liuxishan
 * @date 2024/7/5
 */
public class  Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //模拟运行，这些参数由上游传递
        System.out.println("请按分别输入地图的宽 高，以及士兵的初始坐标和最大移动距离和最大公击距离");
        System.out.println("示例如下");
        System.out.println("14 14 5 4 4 1");
        System.out.println("代表地图宽14，高14，初始坐标为(5,4),最大移动距离为4，最大公击距离为1");
        System.out.println("请开始输入");
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            String[] split = line.split(" ");
            int width = Integer.parseInt(split[0]);
            int height = Integer.parseInt(split[1]);
            int startX = Integer.parseInt(split[2]);
            int startY = Integer.parseInt(split[3]);
            int moveDistance = Integer.parseInt(split[4]);
            int attackDistance = Integer.parseInt(split[5]);
            //构建游戏地图和士兵
            GameMap gameMap = new GameMap(width, height);
            Soldier soldier = new Soldier(new Point(startX, startY), moveDistance, attackDistance);

            //获取所有可能的移动和攻击动作
            List<int[][]> allAction = GameLogic.getInstance().getAllAction(gameMap, soldier);

            //获取格式化的json
            String json = JsonUtil.toJson(allAction);

            // 输出 JSON 字符串
            System.out.println(json);

        }

    }
}
