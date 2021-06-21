package com.example.gravity.generators;

import com.example.gravity.objects.Enemy;
import com.example.my_framework.GraphicsFW;

import java.util.ArrayList;

public class GeneratorEnemy {
    private final int MaxScreenY;
    private final int MaxScreenX;
    private final int MinScreenY;

    public ArrayList<Enemy> enemyArrayList;

    public GeneratorEnemy(int sceneWidth, int sceneHeight, int MinScreenY) {
        this.MaxScreenX = sceneWidth;
        this.MaxScreenY = sceneHeight;
        this.MinScreenY = MinScreenY;
        enemyArrayList = new ArrayList<>();
    }

    public void update(double speedPlayer) {

        if (enemyArrayList.size() < 3) {
            addEnemy();
        }

        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).update(speedPlayer);
        }
    }

    private void addEnemy() {
        for (int i = 0; i < 3; i++) {
            enemyArrayList.add(new Enemy(MaxScreenX, MaxScreenY, MinScreenY, 1));
        }
    }

    public void drawing(GraphicsFW graphicsFW) {
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).drawing(graphicsFW);
        }
    }

    public void hitPlayer(Enemy enemy) {
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.remove(enemy);
        }
    }
}
