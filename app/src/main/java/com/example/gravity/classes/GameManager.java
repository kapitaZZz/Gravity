package com.example.gravity.classes;

import com.example.gravity.CollisionDetect;
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
    private int mPassedDistance;

    public static boolean gameOver;

    private MainPlayer mMainPlayer;
    private GeneratorBackground mGeneratorBackground;
    private GeneratorEnemy mGeneratorEnemy;
    private GeneratorGifts mGeneratorGifts;
    private HUD mHud;
//region end
    public GameManager(int sceneWidth, int sceneHeight, CoreFW coreFW) {
        init(coreFW, sceneHeight, sceneWidth);
    }

    private void init(CoreFW coreFW, int sceneHeight, int sceneWidth) {
        mHud = new HUD(coreFW);
        int mMinScreenY = mHud.getHEIGHT_HUD();
        int mMaxScreenX = sceneWidth;
        int mMaxScreenY = sceneHeight;

        mMainPlayer = new MainPlayer(coreFW, mMaxScreenX, sceneHeight, mMinScreenY);
        mGeneratorBackground = new GeneratorBackground(sceneWidth, sceneHeight, mMinScreenY);
        mGeneratorEnemy = new GeneratorEnemy(sceneWidth, sceneHeight, mMinScreenY);
        mGeneratorGifts = new GeneratorGifts(sceneWidth, sceneHeight, mMinScreenY);
        gameOver = false;
    }

    public void update() {
        mGeneratorBackground.update(mMainPlayer.getSpeedPlayer());
        mMainPlayer.update();
        mGeneratorEnemy.update(mMainPlayer.getSpeedPlayer());
        mGeneratorGifts.update(mMainPlayer.getSpeedPlayer());

        mPassedDistance += mMainPlayer.getSpeedPlayer();
        int mCurrentSpeedPlayer = (int) mMainPlayer.getSpeedPlayer() * 60;
        int mCurrentShieldsPlayer = mMainPlayer.getShieldsPlayer();

        mHud.update(mPassedDistance, mCurrentSpeedPlayer, mCurrentShieldsPlayer);

        checkHit();
    }

    private void checkHit() {
        for (int i = 0; i < mGeneratorEnemy.enemyArrayList.size(); i++) {
            if (CollisionDetect.collisionDetect(mMainPlayer, mGeneratorEnemy.enemyArrayList.get(i))) {
                UtilResource.hit.play(1);
                mMainPlayer.hitEnemy();
                mGeneratorEnemy.hitPlayer(mGeneratorEnemy.enemyArrayList.get(i));
            }
        }
        if (CollisionDetect.collisionDetect(mMainPlayer, mGeneratorGifts.getProtector())) {
            hitPlayerWithProtector();
        }

    }

    private void hitPlayerWithProtector() {
        mMainPlayer.hitProtector();
        mGeneratorGifts.hitProtectorWithPlayer();
    }

    public void drawing(GraphicsFW graphicsFW) {

        mMainPlayer.drawing(graphicsFW);
        mGeneratorBackground.drawing(graphicsFW);
        mGeneratorEnemy.drawing(graphicsFW);
        mGeneratorGifts.drawing(graphicsFW);
        mHud.drawing(graphicsFW);
    }

    public int getPassedDistance() {
        return mPassedDistance;
    }

}