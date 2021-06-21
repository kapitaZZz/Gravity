package com.example.gravity.generators;

import com.example.gravity.objects.MainPlayer;
import com.example.gravity.objects.Protector;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.utilits.UtilTimerDelay;

public class GeneratorGifts {

    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    private UtilTimerDelay timerProtector;
    private Protector Protector;

    public GeneratorGifts(int sceneWidth, int sceneHeight, int minScreenY) {
        init(sceneWidth, sceneHeight, minScreenY);

    }

    private void init(int sceneWidth, int sceneHeight, int minScreenY) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenY = minScreenY;
        this.minScreenX = 0;

        Protector = new Protector(maxScreenX, maxScreenY, minScreenY);
        timerProtector = new UtilTimerDelay();
        timerProtector.startTimer();
    }

    public void drawing(GraphicsFW graphicsFW) {
        Protector.drawing(graphicsFW);
    }

    public void update(double speedPlayer) {
        if (timerProtector.timerDelay(8) && (!MainPlayer.isShieldsOn())) {
            Protector.update(speedPlayer);
            if (Protector.getX() < minScreenX) {
                Protector = null;
                Protector = new Protector(maxScreenX, maxScreenY, minScreenY);
                timerProtector.startTimer();
            }
        }
    }

    public Protector getProtector() {
        return Protector;
    }

    public void hitProtectorWithPlayer() {
        Protector = null;
        Protector = new Protector(maxScreenX, maxScreenY, minScreenY);
        timerProtector.startTimer();
    }
}
