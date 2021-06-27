package com.example.gravity;

import com.example.gravity.scenes.LoaderResourceScene;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class Main extends CoreFW {

    public SceneFW getStartScene() {

        return new LoaderResourceScene(this);
    }
}