package com.example.gravity.scenes;

import android.graphics.Color;

import com.example.gravity.R;
import com.example.gravity.classes.GameManager;
import com.example.gravity.utilits.SettingsGame;
import com.example.gravity.utilits.UtilResource;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class GameScene extends SceneFW {

    enum GameState {
        READY, RUNNING, PAUSE, GAME_OVER
    }

    private GameState gameState;
    private final GameManager gameManager;

    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;

        gameManager = new GameManager(sceneWidth, sceneHeight, coreFW);

        if (SettingsGame.musicOn) {
            UtilResource.gameMusic.play(true, 10f);
        }
    }

    @Override
    public void update() {
        if (gameState == GameState.READY) {
            updateStateReady();
        }
        if (gameState == GameState.RUNNING) {
            updateStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            updateStatePause();
        }
        if (gameState == GameState.GAME_OVER) {
            updateStateGameOver();
        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);

        if (gameState == GameState.READY) {
            drawingStateReady();
        }
        if (gameState == GameState.RUNNING) {
            drawingStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            drawingStatePause();
        }
        if (gameState == GameState.GAME_OVER) {
            drawingStateGameOver();
        }
    }

    private void drawingStateGameOver() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_gameOver),
                200, 300, Color.WHITE, 60, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_restart),
                200, 360, Color.WHITE, 40, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_exit),
                200, 420, Color.WHITE, 40, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_distance)
                        + gameManager.getPassedDistance(),
                200, 200, Color.WHITE, 40, null);
    }

    private void updateStateGameOver() {
        SettingsGame.addDistance(gameManager.getPassedDistance());

        if (coreFW.getTouchListenerFW().getTouchUp(250, 360, 100, 35)) {
            coreFW.setScene(new GameScene(coreFW));
        }
        if (coreFW.getTouchListenerFW().getTouchUp(250, 420, 100, 35)) {
            coreFW.setScene(new MainMenuScene(coreFW));
        }

    }

    private void drawingStatePause() {
        coreFW.getGraphicsFW().drawText("PAUSED", 400, 300, Color.GREEN,
                50, null);
    }

    private void updateStatePause() {
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }

    }

    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);
        gameManager.drawing(graphicsFW);
    }

    private void updateStateRunning() {

        gameManager.update();
        if (GameManager.gameOver) {
            gameState = GameState.GAME_OVER;
        }

        if (coreFW.isPressedKeyBack()) {
            gameState = GameState.PAUSE;
            coreFW.setPressedKeyBack(false);
        }
    }

    private void drawingStateReady() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateReady_ready),
                250, 300, Color.WHITE, 60, null);
    }

    private void updateStateReady() {
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }

    @Override
    public void pause() {
        UtilResource.gameMusic.stop();
    }

    @Override
    public void resume() {
        if (SettingsGame.musicOn) {
            UtilResource.gameMusic.play(true, 10f);
        }
    }

    @Override
    public void dispose() {
//        UtilResource.explode.dispose();
//        UtilResource.touch.dispose();
//        UtilResource.hit.dispose();
//        UtilResource.gameMusic.dispose();
    }
}
