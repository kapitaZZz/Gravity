package com.example.gravity.objects;

import android.graphics.Color;

import com.example.gravity.R;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

public class HUD {
    private int mPassedDistance;
    private int mCurrentSpeedPlayer;
    private int mCurrentShieldsPlayer;

    CoreFW coreFW;

    private final int HEIGHT_HUD = 50;

    public HUD(CoreFW coreFW) {
        this.coreFW = coreFW;
    }

    public void update(int passedDistance, int currentSpeedPlayer, int currentShieldsPlayer) {
        this.mPassedDistance = passedDistance;
        this.mCurrentSpeedPlayer = currentSpeedPlayer;
        this.mCurrentShieldsPlayer = currentShieldsPlayer;
    }

    public void drawing(GraphicsFW graphicsFW){
        graphicsFW.drawLine(0,HEIGHT_HUD,graphicsFW.getWidthFrameBuffer(),
                HEIGHT_HUD, Color.WHITE);
        graphicsFW.drawText(coreFW.getString(R.string.txt_hud_distance)+": "+ mPassedDistance,
                10,30,Color.GREEN,25,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_hud_currentSpeedPlayer)+": "+ mCurrentSpeedPlayer,
                350,30,Color.GREEN,25,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_hud_currentShieldsPlayer)+": "+ mCurrentShieldsPlayer,
                650,30,Color.GREEN,25,null);
    }

    public int getHEIGHT_HUD() {
        return HEIGHT_HUD;
    }
}

