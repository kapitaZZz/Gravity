package com.example.gravity.scenes;

import android.graphics.Color;

import com.example.gravity.utilits.SettingsGame;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class SettingsScene extends SceneFW {
    public SettingsScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        if (coreFW.isPressedKeyBack()) {
            coreFW.setPressedKeyBack(false);
            coreFW.setScene(new MainMenuScene(coreFW));
        }
         if (coreFW.getTouchListenerFW().getTouchUp(400, 350, 100, 30));{
             SettingsGame.soundOn = !SettingsGame.soundOn;
             SettingsGame.saveSettings(coreFW);
        }
        if (coreFW.getTouchListenerFW().getTouchUp(400, 300, 100, 30));{
            SettingsGame.musicOn = !SettingsGame.musicOn;
            SettingsGame.saveSettings(coreFW);
        }
    }

    @Override
    public void drawing() {
        coreFW.getGraphicsFW().clearScene(Color.BLACK);
        coreFW.getGraphicsFW().drawText("Settings", 250, 200,
                Color.GREEN, 40, null);

        coreFW.getGraphicsFW().drawText("Music ", 250, 300,
                Color.GREEN, 30, null);
        coreFW.getGraphicsFW().drawText("Sounds ", 250, 350,
                Color.GREEN, 30, null);

        if (SettingsGame.soundOn) {
            coreFW.getGraphicsFW().drawText("On ", 400, 300,
                    Color.GREEN, 30, null);
        } else {
            coreFW.getGraphicsFW().drawText("Off", 400, 300,
                    Color.RED, 30, null);
        }

        if (SettingsGame.musicOn) {
            coreFW.getGraphicsFW().drawText("On ", 400, 350,
                    Color.GREEN, 30, null);
        } else {
            coreFW.getGraphicsFW().drawText("Off", 400, 350,
                    Color.RED, 30, null);
        }
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
