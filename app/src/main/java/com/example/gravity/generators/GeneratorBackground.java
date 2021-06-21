package com.example.gravity.generators;

import android.graphics.Color;

import com.example.gravity.objects.Star;
import com.example.my_framework.GraphicsFW;

import java.util.ArrayList;

public class GeneratorBackground {
    private final ArrayList<Star> StarArrayList = new ArrayList<>();

    public GeneratorBackground(int sceneWidth, int sceneHeight, int minScreenY) {
        int starsSpeak = 50;
        for (int i = 0; i < starsSpeak; i++) {
            Star star = new Star(sceneWidth, sceneHeight, minScreenY);
            StarArrayList.add(star);
        }

    }

    public void update(double speedPlayer) {
        for (int i = 0; i < StarArrayList.size(); i++) {
            StarArrayList.get(i).update(speedPlayer);
        }
    }

    public void drawing(GraphicsFW graphicsFW) {
        for (int i = 0; i < StarArrayList.size(); i++) {
            graphicsFW.drawPixel(StarArrayList.get(i).getX(), StarArrayList.get(i).getY(),
                    Color.WHITE);
        }
    }
}
