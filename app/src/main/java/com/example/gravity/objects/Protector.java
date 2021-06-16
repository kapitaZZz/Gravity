package com.example.gravity.objects;

import android.graphics.Rect;

import com.example.gravity.classes.GameManager;
import com.example.gravity.utilits.UtilResource;
import com.example.my_framework.AnimationFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectsFW;
import com.example.my_framework.utilits.UtilRandomFW;
import com.example.my_framework.utilits.UtilTimerDelay;

public class Protector extends ObjectsFW {
    AnimationFW animProtector;

    public Protector(int maxScreenX, int maxScreenY, int minScreenY) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spriteEnemy.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;

        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        radius = UtilResource.spriteEnemy.get(0).getWidth() / 2;
        hitBox = new Rect(x, y, UtilResource.spriteProtector.get(0).getWidth(),
                UtilResource.spriteProtector.get(0).getHeight());
        animProtector = new AnimationFW(GameManager.SPEED_ANIMATION,
                UtilResource.spriteProtector.get(0),
                UtilResource.spriteProtector.get(1),
                UtilResource.spriteProtector.get(2),
                UtilResource.spriteProtector.get(3));

    }

    public void update(double speedPlayer) {

        x -= speed;
        x -= speedPlayer;


        if (x < minScreenX) {
            x = maxScreenX;
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        animProtector.runAnimation();

        hitBox = new Rect(x, y, UtilResource.spriteEnemy.get(0).getWidth(),
                UtilResource.spriteEnemy.get(0).getHeight());
    }

    public void drawing(GraphicsFW graphicsFW) {
        animProtector.drawingAnimation(graphicsFW, x, y);
    }


}
