package com.example.gravity.classes;

import com.example.my_framework.utilits.CollisionDetect;
import com.example.gravity.generators.GeneratorBackground;
import com.example.gravity.generators.GeneratorEnemy;
import com.example.gravity.generators.GeneratorGifts;
import com.example.gravity.objects.HUD;
import com.example.gravity.objects.MainPlayer;
import com.example.gravity.utilits.UtilResource;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

public class GameManager {
    //region Fields
    public final static double SPEED_ANIMATION = 3;
    private int PassedDistance;

    public static boolean gameOver;

    private MainPlayer MainPlayer;
    private GeneratorBackground GeneratorBackground;
    private GeneratorEnemy GeneratorEnemy;
    private GeneratorGifts GeneratorGifts;
    private HUD Hud;

    //region end
    public GameManager(int sceneWidth, int sceneHeight, CoreFW coreFW) {
        init(coreFW, sceneHeight, sceneWidth);
    }

    private void init(CoreFW coreFW, int sceneHeight, int sceneWidth) {
        Hud = new HUD(coreFW);
        int MinScreenY = Hud.getHEIGHT_HUD();

        MainPlayer = new MainPlayer(coreFW, sceneWidth, sceneHeight, MinScreenY);
        GeneratorBackground = new GeneratorBackground(sceneWidth, sceneHeight, MinScreenY);
        GeneratorEnemy = new GeneratorEnemy(sceneWidth, sceneHeight, MinScreenY);
        GeneratorGifts = new GeneratorGifts(sceneWidth, sceneHeight, MinScreenY);
        gameOver = false;
    }

    public void update() {
        GeneratorBackground.update(MainPlayer.getSpeedPlayer());
        MainPlayer.update();
        GeneratorEnemy.update(MainPlayer.getSpeedPlayer());
        GeneratorGifts.update(MainPlayer.getSpeedPlayer());

        PassedDistance += MainPlayer.getSpeedPlayer();
        int mCurrentSpeedPlayer = (int) MainPlayer.getSpeedPlayer() * 60;
        int mCurrentShieldsPlayer = MainPlayer.getShieldsPlayer();

        Hud.update(PassedDistance, mCurrentSpeedPlayer, mCurrentShieldsPlayer);

        checkHit();
    }

    private void checkHit() {
        for (int i = 0; i < GeneratorEnemy.enemyArrayList.size(); i++) {
            if (CollisionDetect.collisionDetect(MainPlayer, GeneratorEnemy.enemyArrayList.get(i))) {
                UtilResource.hit.play(1);
                MainPlayer.hitEnemy();
                GeneratorEnemy.hitPlayer(GeneratorEnemy.enemyArrayList.get(i));
            }
        }
        if (CollisionDetect.collisionDetect(MainPlayer, GeneratorGifts.getProtector())) {
            hitPlayerWithProtector();
        }

    }

    private void hitPlayerWithProtector() {
        MainPlayer.hitProtector();
        GeneratorGifts.hitProtectorWithPlayer();
    }

    public void drawing(GraphicsFW graphicsFW) {

        MainPlayer.drawing(graphicsFW);
        GeneratorBackground.drawing(graphicsFW);
        GeneratorEnemy.drawing(graphicsFW);
        GeneratorGifts.drawing(graphicsFW);
        Hud.drawing(graphicsFW);
    }

    public int getPassedDistance() {
        return PassedDistance;
    }

}