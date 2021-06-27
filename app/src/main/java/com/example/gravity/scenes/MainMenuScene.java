package com.example.gravity.scenes;

import android.graphics.Color;

import com.example.gravity.R;
import com.example.gravity.utilits.UtilResource;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class MainMenuScene extends SceneFW {

    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {

        if (coreFW.getTouchListenerFW().getTouchUp(20, 300, 100, 50)) {
            coreFW.setScene(new GameScene(coreFW));
            UtilResource.touch.play(1);
        }

        if (coreFW.getTouchListenerFW().getTouchUp(20, 400, 100, 50)) {
            coreFW.setScene(new TopDistance(coreFW));
            UtilResource.touch.play(1);
        }

        if (coreFW.getTouchListenerFW().getTouchUp(20, 350, 100, 50)) {
            coreFW.setScene(new SettingsScene(coreFW));
            UtilResource.touch.play(1);
        }

        if (coreFW.getTouchListenerFW().getTouchUp(20, 450, 100, 50)) {
            coreFW.setScene(new ExitScene(coreFW));
            UtilResource.touch.play(1);
        }

    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_nameGame), 100, 100, Color.BLUE, 60,
                UtilResource.mainMenuFont);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_newGame), 20, 300, Color.BLUE, 40,
                UtilResource.mainMenuFont);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_settings), 20, 350, Color.BLUE, 40,
                UtilResource.mainMenuFont);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_results), 20, 400, Color.BLUE, 40,
                UtilResource.mainMenuFont);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_exit), 20, 450, Color.BLUE, 40,
                UtilResource.mainMenuFont);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
