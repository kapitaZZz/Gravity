package com.example.gravity;

import com.example.gravity.scenes.MainMenuScene;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;
import com.example.gravity.classes.LoaderAssets;

public class Main extends CoreFW {

    public SceneFW getStartScene() {
        LoaderAssets loaderAssets = new LoaderAssets(this, this.getGraphicsFW());
        return new MainMenuScene(this);
    }
}