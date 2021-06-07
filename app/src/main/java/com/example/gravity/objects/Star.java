package com.example.gravity.objects;

import com.example.my_framework.ObjectsFW;
import com.example.my_framework.utilits.UtilRandomFW;

public class Star extends ObjectsFW {

    public Star(int sceneWidth, int sceneHeight, int minScreenY) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenX = 0;
        this.minScreenY = minScreenY;
        this.speed = 2;
        this.x = UtilRandomFW.getCasualNumber(maxScreenX);
        this.y = UtilRandomFW.getGap(minScreenY, maxScreenY);
    }

    public void update(double speedPlayer) {
        x -= speedPlayer;
        x -= speed;
        if (x < 0) {
            x = UtilRandomFW.getCasualNumber(maxScreenX);
            y = UtilRandomFW.getCasualNumber(maxScreenY);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
