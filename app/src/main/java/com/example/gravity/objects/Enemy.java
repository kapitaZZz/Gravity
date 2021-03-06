package com.example.gravity.objects;

import android.graphics.Rect;

import com.example.gravity.utilits.UtilResource;
import com.example.my_framework.AnimationFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectsFW;
import com.example.my_framework.utilits.UtilRandomFW;

public class Enemy extends ObjectsFW {

    private AnimationFW AnimEnemy;

    public Enemy(int maxScreenX, int maxScreenY, int minScreenY, int enemyType) {
        init(maxScreenX, maxScreenY, minScreenY);
        initTypeEnemy(enemyType);
    }

    private void initTypeEnemy(int enemyType) {
        switch (enemyType) {
            case 1:
                speed = UtilRandomFW.getGap(1, 6);
                AnimEnemy = new AnimationFW(3,
                        UtilResource.spriteEnemy.get(0),
                        UtilResource.spriteEnemy.get(1),
                        UtilResource.spriteEnemy.get(2),
                        UtilResource.spriteEnemy.get(3));
                break;

            case 2:
                speed = UtilRandomFW.getGap(4, 9);
                break;
        }
    }

    private void init(int maxScreenX, int maxScreenY, int minScreenY) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spriteEnemy.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        radius = UtilResource.spriteEnemy.get(0).getWidth() / 2.0;
    }

    public void update(double speedPlayer) {
        x -= speed;
        x -= speedPlayer;
        if (x < minScreenX) {
            x = maxScreenX;
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        AnimEnemy.runAnimation();
        hitBox = new Rect(x, y, UtilResource.spriteEnemy.get(0).getWidth(),
                UtilResource.spriteEnemy.get(0).getHeight());
    }

    public void drawing(GraphicsFW graphicsFW) {
        AnimEnemy.drawingAnimation(graphicsFW, x, y);
    }

}