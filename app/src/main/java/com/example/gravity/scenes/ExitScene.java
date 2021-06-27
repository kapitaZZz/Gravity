package com.example.gravity.scenes;

import android.graphics.Color;

import com.example.gravity.utilits.UtilResource;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class ExitScene extends SceneFW {

    public ExitScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        if (coreFW.getTouchListenerFW().getTouchUp(150, 250, 100, 35)) {
            coreFW.finish();
        }

        if (coreFW.getTouchListenerFW().getTouchUp(150, 300, 100, 35)) {
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }

    @Override
    public void drawing() {
        coreFW.getGraphicsFW().clearScene(Color.BLACK);
        coreFW.getGraphicsFW().drawText("Are you sure??", 150, 200,
                Color.GREEN, 50, UtilResource.mainMenuFont);
        coreFW.getGraphicsFW().drawText("YES", 150, 250,
                Color.GREEN, 35, UtilResource.mainMenuFont);
        coreFW.getGraphicsFW().drawText("NO", 150, 300,
                Color.GREEN, 35, UtilResource.mainMenuFont);
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
