package com.example.gravity.utilits;

import android.content.SharedPreferences;

import com.example.my_framework.CoreFW;

public class SettingsGame {

    public static boolean musicOn = true;
    public static boolean soundOn = true;
    public static int[] distance = {9999, 7777, 5555, 3333, 1111};

    public static void saveSettings(CoreFW coreFW) {
        SharedPreferences.Editor editor = coreFW.getSharedPreference().edit();
        editor.clear();
        editor.putBoolean("soundOn", soundOn);
        editor.putBoolean("musicOn", musicOn);
        for (int i = 0; i < 5; i++) {
            editor.putInt("passedDistance" + i, distance[i]);
        }
        editor.apply();
    }

    public static void loadSettings(CoreFW coreFW) {
        soundOn = coreFW.getSharedPreference().getBoolean("soundsOn", true);
        musicOn = coreFW.getSharedPreference().getBoolean("musicOn", true);
        for (int i = 0; i < 5; i++) {
            distance[i] = coreFW.getSharedPreference().getInt("passedDistance" + i, distance[i]);
        }
    }


    public static void addDistance(int values) {
        for (int i = 0; i < 5; i++) {
            if (distance[i] < values) {
                distance[i] = values;
                break;
            }
        }
    }
}
